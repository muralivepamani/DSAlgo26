package companies.wipro


class University(
    private val repo: StudentRepository
) {
    fun getPaidCoursesWithTheNumbersOfSubscribedStudents(
        courseCount: Int
    ): Map<Course, Int> {
        val students = repo.get().toList()
        val countMap = HashMap<Course, Int>()

        students.forEach { it ->
            it.subscribedCourse.filter {
                it.isPaid
            }.forEach {
                countMap[it] = countMap.getOrDefault(it, 0) + 1
            }
        }

        return countMap.toList()
            .sortedByDescending { it.second }
            .take(courseCount)
            .toMap()
    }
}

class StudentRepository {
    private val course = mutableListOf(
        Course(1, "C1", false), Course(2, "C2", true), Course(3, "C3", true)
    )

    val students = listOf(
        Student(1, "A", listOf(course[0], course[1])),
        Student(2, "B", listOf(course[1], course[2])),
        Student(3, "C", listOf(course[1]))
    )

    fun get(): List<Student> {
        return students
    }
}

data class Course(
    val id: Int, val name: String, val isPaid: Boolean
)

data class Student(
    val id: Int, val name: String, val subscribedCourse: List<Course>
)