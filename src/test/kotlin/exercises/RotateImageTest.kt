package exercises

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RotateImageTest {
    private val solution = RotateImage()

    @Test
    fun fun1() {
        val matrix = arrayOf(intArrayOf(1))
        val expected = arrayOf(intArrayOf(1))

        solution.rotate(matrix)

        assertArrayEquals(expected, matrix)
    }

    @Test
    fun fun2() {
        val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        val expected = arrayOf(intArrayOf(7, 4, 1), intArrayOf(8, 5, 2), intArrayOf(9, 6, 3))

        solution.rotate(matrix)

        assertArrayEquals(expected, matrix)
    }

    @Test
    fun fun3() {
        val matrix = arrayOf(
            intArrayOf(5, 1, 9, 11), intArrayOf(2, 4, 8, 10), intArrayOf(13, 3, 6, 7), intArrayOf(15, 14, 12, 16)
        )
        val expected = arrayOf(
            intArrayOf(15, 13, 2, 5), intArrayOf(14, 3, 4, 1), intArrayOf(12, 6, 8, 9), intArrayOf(16, 7, 10, 11)
        )

        solution.rotate(matrix)

        assertArrayEquals(expected, matrix)
    }

    private fun assertArrayEquals(expected: Array<IntArray>, result: Array<IntArray>) {
        expected.forEachIndexed { indexLine, ints ->
            ints.forEachIndexed { indexColunm, i ->
                assertEquals(i, result[indexLine][indexColunm])
            }
        }
    }
}