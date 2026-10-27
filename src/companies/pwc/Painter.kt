package companies.pwc

class Painter {

    companion object {
        fun solve(A: ArrayList<ArrayList<Character>>): ArrayList<ArrayList<Character>> {
            var evenColor = 'B'
            var found = false

            for (i in 0 until A.size) {
                for (j in 0 until A[i].size) {
                    val ch = A[i][j].charValue()
                    if (ch != '.' && !found) {
                        evenColor = if ((i + j) % 2 == 0) ch else if (ch == 'B') 'W' else 'B'
                        found = true
                    }
                }
            }

            val oddColor = if (evenColor == 'B') 'W' else 'B'

            for (i in 0 until A.size) {
                for (j in 0 until A[i].size) {
                    if (A[i][j].charValue() == '.') {
                        A[i][j] = Character(if ((i + j) % 2 == 0) evenColor else oddColor)
                    }
                }
            }

            return A
        }
    }
}
