package exercises

//https://leetcode.com/problems/implement-strstr/

class ImplementStrStr {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        if (needle.length > haystack.length) return -1

        haystack.forEachIndexed { index, c ->
            if (c == needle[0]) {
                val areEqual = stringsAreEqual(haystack, needle, index, index + needle.length - 1)
                if (areEqual) return index
            }
        }

        return -1
    }

    private fun stringsAreEqual(haystack: String, needle: String, start: Int, end: Int): Boolean {
        if (end > haystack.length - 1) return false
        return haystack.substring(start, end + 1) == needle
    }
}

fun main() {
    val haystack = ""
    val needle = ""
    val result = ImplementStrStr().strStr(haystack, needle)
    println(result)
}