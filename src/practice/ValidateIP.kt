package practice

class ValidateIP {

    fun validateIP(ip: String): Boolean {

        val parts = ip.split(".")
        if (parts.size != 4) return false
        for (part in parts) {
            if (part.isEmpty() || part.length>1 && part.startsWith('0')) return false
            val chars = part.toCharArray()
            for (char in chars) {
                if (!char.isDigit()) return false
            }
            if (part.toInt() > 255) return false

        }
        return true
    }
}