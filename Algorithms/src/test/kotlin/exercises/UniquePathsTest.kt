package exercises

import org.junit.Test
import kotlin.test.assertEquals

class UniquePathsTest {
    private val solution = UniquePaths()

    @Test
    fun `uniquePathsSimple - for m equals to 1 and n equals to 1 returns 1`() {
        val result = solution.uniquePathsSimple(1, 1)
        val expected = 1
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsSimple - for m equals to 1 and n equals to 2 returns 1`() {
        val result = solution.uniquePathsSimple(1, 2)
        val expected = 1
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsSimple - for m equals to 2 and n equals to 1 returns 1`() {
        val result = solution.uniquePathsSimple(2, 1)
        val expected = 1
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsSimple - for m equals to 2 and n equals to 2 returns 2`() {
        val result = solution.uniquePathsSimple(2, 2)
        val expected = 2
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsSimple - for m equals to 3 and n equals to 7 returns 28`() {
        val result = solution.uniquePathsSimple(3, 7)
        val expected = 28
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsSimple - for m equals to 3 and n equals to 2 returns 3`() {
        val result = solution.uniquePathsSimple(3, 2)
        val expected = 3
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsSimple - for m equals to 7 and n equals to 3 returns 28`() {
        val result = solution.uniquePathsSimple(7, 3)
        val expected = 28
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsSimple - for m equals to 3 and n equals to 3 returns 6`() {
        val result = solution.uniquePathsSimple(3, 3)
        val expected = 6
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsSimple - for m equals to 23 and n equals to 12 returns 193536720`() {
        val result = solution.uniquePathsSimple(23, 12)
        val expected = 193536720
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsWithMemoization - for m equals to 1 and n equals to 1 returns 1`() {
        val result = solution.uniquePathsWithMemoization(1, 1)
        val expected = 1
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsWithMemoization - for m equals to 1 and n equals to 2 returns 1`() {
        val result = solution.uniquePathsWithMemoization(1, 2)
        val expected = 1
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsWithMemoization - for m equals to 2 and n equals to 1 returns 1`() {
        val result = solution.uniquePathsWithMemoization(2, 1)
        val expected = 1
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsWithMemoization - for m equals to 2 and n equals to 2 returns 2`() {
        val result = solution.uniquePathsWithMemoization(2, 2)
        val expected = 2
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsWithMemoization - for m equals to 3 and n equals to 7 returns 28`() {
        val result = solution.uniquePathsWithMemoization(3, 7)
        val expected = 28
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsWithMemoization - for m equals to 3 and n equals to 2 returns 3`() {
        val result = solution.uniquePathsWithMemoization(3, 2)
        val expected = 3
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsWithMemoization - for m equals to 7 and n equals to 3 returns 28`() {
        val result = solution.uniquePathsWithMemoization(7, 3)
        val expected = 28
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsWithMemoization - for m equals to 3 and n equals to 3 returns 6`() {
        val result = solution.uniquePathsWithMemoization(3, 3)
        val expected = 6
        assertEquals(expected, result)
    }

    @Test
    fun `uniquePathsWithMemoization - for m equals to 23 and n equals to 12 returns 193536720`() {
        val result = solution.uniquePathsWithMemoization(23, 12)
        val expected = 193536720
        assertEquals(expected, result)
    }
}