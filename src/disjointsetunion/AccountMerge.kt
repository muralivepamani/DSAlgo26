package disjointsetunion

class `Accounts Merge` {

    fun merge(accounts: List<List<String>>): List<List<String>> {

        // Maps every unique email to a unique integer ID.
        // DSU works with integer indices, so each email gets an ID.
        val emailToId = HashMap<String, Int>()

        // Stores the account owner's name for each email.
        val emailToName = HashMap<String, String>()

        // Used to assign unique IDs to emails.
        var id = 0

        // Step 1: Assign a unique ID to every email.
        for (account in accounts) {

            // The first element of every account is the user's name.
            val name = account[0]

            // Remaining elements are email addresses.
            for (i in 1 until account.size) {
                val email = account[i]

                // Assign a new ID only if this email has not been seen before.
                if (email !in emailToId) {
                    emailToId[email] = id++
                }

                // Associate this email with its owner's name.
                emailToName[email] = name
            }
        }

        // parent[i] represents the parent of email with ID i.
        // Initially, every email is its own parent.
        val parent = IntArray(id) { it }

        // Finds the ultimate parent/root of a node.
        fun find(x: Int): Int {

            // If x is not its own parent, recursively find its root.
            if (parent[x] != x) {

                // Path compression:
                // Directly connect x to the root for faster future lookups.
                parent[x] = find(parent[x])
            }

            return parent[x]
        }

        // Connects two emails so they belong to the same account/group.
        fun union(a: Int, b: Int) {

            // Find the root parent of both emails.
            val rootA = find(a)
            val rootB = find(b)

            // Only connect them if they belong to different groups.
            if (rootA != rootB) {
                parent[rootA] = rootB
            }
        }

        // Step 2: Union all emails belonging to the same account.
        for (account in accounts) {

            // Take the first email as the representative for this account.
            val firstEmail = emailToId[account[1]]!!

            // Connect every other email with the first email.
            for (i in 2 until account.size) {

                // Get the ID of the current email.
                // Important: account[i], not account[1].
                val currentEmail = emailToId[account[i]]!!

                // Merge both emails into the same DSU group.
                union(firstEmail, currentEmail)
            }
        }

        // Maps each root ID to all emails belonging to that group.
        val groups = HashMap<Int, MutableList<String>>()

        // Step 3: Group emails based on their DSU root.
        for ((email, emailId) in emailToId) {

            // Find the ultimate parent of this email.
            val root = find(emailId)

            // Add the email to the list belonging to its root group.
            groups.getOrPut(root) {
                mutableListOf()
            }.add(email)
        }

        val result = mutableListOf<List<String>>()

        // Step 4: Convert every email group into the required output format.
        for (emails in groups.values) {

            // Emails must be returned in lexicographical order.
            emails.sort()

            // Get the account owner's name using any email in this group.
            val name = emailToName[emails[0]]!!

            // Output format:
            // [Name, email1, email2, email3...]
            result.add(listOf(name) + emails)
        }

        return result
    }
}