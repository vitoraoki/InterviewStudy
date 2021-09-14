package exercises//https://leetcode.com/problems/longest-increasing-subsequence/

class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        val LIS = mutableListOf<Int>()

        nums.forEach {
            LIS.add(1)
        }

        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (nums[i] > nums[j] && LIS[j] + 1 > LIS[i]) {
                    LIS[i]++
                }
            }
        }

        return LIS.maxOrNull()!!
    }
}

fun main() {
    val solution = LongestIncreasingSubsequence()
    val nums = listOf<Int>(10, 9, 2, 5, 3, 7, 101, 18)
    println(solution.lengthOfLIS(nums.toIntArray()))
}