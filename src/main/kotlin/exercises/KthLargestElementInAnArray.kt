package exercises

//https://leetcode.com/problems/kth-largest-element-in-an-array/

class KthLargestElementInAnArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nums.sort()
        val size = nums.size
        return nums[size - k]
    }
}