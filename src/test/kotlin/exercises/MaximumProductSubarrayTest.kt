package exercises

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MaximumProductSubarrayTest {
    private val solution = MaximumProductSubarray()

    @Test
    fun test1() {
        val nums = intArrayOf(0)
        val expected = 0
        val result = solution.maxProduct(nums)
        assertEquals(expected, result)
    }

    @Test
    fun test2() {
        val nums = intArrayOf(-1)
        val expected = -1
        val result = solution.maxProduct(nums)
        assertEquals(expected, result)
    }

    @Test
    fun test3() {
        val nums = intArrayOf(-1, -4)
        val expected = 4
        val result = solution.maxProduct(nums)
        assertEquals(expected, result)
    }

    @Test
    fun test4() {
        val nums = intArrayOf(5)
        val expected = 5
        val result = solution.maxProduct(nums)
        assertEquals(expected, result)
    }

    @Test
    fun test5() {
        val nums = intArrayOf(5, 2)
        val expected = 10
        val result = solution.maxProduct(nums)
        assertEquals(expected, result)
    }

    @Test
    fun test6() {
        val nums = intArrayOf(2, 3, -2, 4)
        val expected = 6
        val result = solution.maxProduct(nums)
        assertEquals(expected, result)
    }

    @Test
    fun test7() {
        val nums = intArrayOf(2, 3, 0, 4)
        val expected = 6
        val result = solution.maxProduct(nums)
        assertEquals(expected, result)
    }

    @Test
    fun test8() {
        val nums = intArrayOf(-2, 0, -1)
        val expected = 0
        val result = solution.maxProduct(nums)
        assertEquals(expected, result)
    }
}