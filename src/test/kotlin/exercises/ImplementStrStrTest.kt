package exercises

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class ImplementStrStrTest {
    val solution = ImplementStrStr()

    @Test
    fun test1() {
        val haystack = ""
        val needle = ""
        val expected = 0
        val result = ImplementStrStr().strStr(haystack, needle)

        assertEquals(expected, result)
    }

    @Test
    fun test2() {
        val haystack = "aaaaa"
        val needle = "bba"
        val expected = -1
        val result = ImplementStrStr().strStr(haystack, needle)

        assertEquals(expected, result)
    }

    @Test
    fun test3() {
        val haystack = "hello"
        val needle = "ll"
        val expected = 2
        val result = ImplementStrStr().strStr(haystack, needle)

        assertEquals(expected, result)
    }
}