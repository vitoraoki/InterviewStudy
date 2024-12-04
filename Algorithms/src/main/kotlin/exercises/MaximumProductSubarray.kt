package exercises

//https://leetcode.com/problems/maximum-product-subarray

class MaximumProductSubarray {
    fun maxProduct(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        var maxProduct = Int.MIN_VALUE
        var min = 1
        var max = 1

        nums.forEach {
            val currentMin = minOf(min * it, max * it, it)
            val currentMax = maxOf(min * it, max * it, it)

            maxProduct = maxOf(maxProduct, currentMax)

            min = currentMin
            max = currentMax
        }

        return maxProduct
    }
}

fun main() {
    val nums = intArrayOf(2, -5, -2, -4, 3)
    println(MaximumProductSubarray().maxProduct(nums))
}

