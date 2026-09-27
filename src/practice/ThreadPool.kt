package practice


import okhttp3.internal.notify
import okhttp3.internal.notifyAll
import okhttp3.internal.wait
import java.util.LinkedList


class ThreadPool(private val size: Int) {

    // Shared queue that stores tasks waiting to be executed
    private val taskQueue = LinkedList<Runnable>()

    // Used to stop workers during shutdown
    private var isShutdown = false

    // Create the required number of worker threads
    private val workers = List(size) { index ->

        Thread({

            // Worker keeps running until shutdown
            while (true) {

                // Task that this worker will execute
                val task: Runnable

                // Access to the queue must be thread-safe
                synchronized(taskQueue) {

                    // If there are no tasks, worker waits
                    // wait() releases the lock while waiting
                    while (taskQueue.isEmpty() && !isShutdown) {
                        taskQueue.wait()
                    }

                    // If shutdown is requested and no tasks remain,
                    // exit this worker thread
                    if (taskQueue.isEmpty() && isShutdown) {
                        return@Thread
                    }

                    // Take the first task from the queue
                    task = taskQueue.removeFirst()
                }

                // Execute the task outside the synchronized block
                // so other workers can access the queue
                task.run()
            }

        }, "Worker-$index")
    }

    init {

        // Start all worker threads
        workers.forEach { it.start() }
    }

    fun submit(task: Runnable) {

        // Access the queue safely
        synchronized(taskQueue) {

            // Do not accept new tasks after shutdown
            if (isShutdown) {
                throw IllegalStateException("ThreadPool is shut down")
            }

            // Add the task to the queue
            taskQueue.addLast(task)

            // Wake up one waiting worker
            taskQueue.notify()
        }
    }

    fun shutdown() {

        // Access the queue safely
        synchronized(taskQueue) {

            // Prevent new tasks from being submitted
            isShutdown = true

            // Wake up all workers so they can check shutdown state
            taskQueue.notifyAll()
        }
    }
}