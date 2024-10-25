package exercises

//https://leetcode.com/problems/concatenation-of-array

class ConcatenationOfArray {
    fun getConcatenation(nums: IntArray): IntArray {
        val result = IntArray(nums.size * 2)

        for (i in nums.indices) {
            result[i] = nums[i]
            result[i + nums.size] = nums[i]
        }
        return  result
    }
}

fun main() {
    println(ConcatenationOfArray().getConcatenation(intArrayOf(1, 2, 1)).toList())
    println(ConcatenationOfArray().getConcatenation(intArrayOf(1, 3, 2, 1)).toList())
}