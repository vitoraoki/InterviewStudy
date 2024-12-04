package exercises

//https://leetcode.com/problems/build-array-from-permutation/description/

class BuildArrayFromPermutation {
    fun buildArray(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)

        nums.forEachIndexed { index, value ->
            ans[index] = nums[value]
        }

        return ans
    }
}

fun main() {
    println(BuildArrayFromPermutation().buildArray(intArrayOf(0, 2, 1, 5, 3, 4)).toList())
    println(BuildArrayFromPermutation().buildArray(intArrayOf(5, 0, 1, 2, 3, 4)).toList())
}