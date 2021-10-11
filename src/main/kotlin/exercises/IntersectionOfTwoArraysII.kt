package exercises

//https://leetcode.com/problems/intersection-of-two-arrays-ii/

class IntersectionOfTwoArraysII {
    private fun buildMap(nums: IntArray): MutableMap<Int, Int> {
        val mapNums = mutableMapOf<Int, Int>()

        nums.forEach {
            if (mapNums[it] == null) {
                mapNums[it] = 1
            } else {
                mapNums[it] = mapNums[it]!! + 1
            }
        }

        return mapNums
    }

    private fun intersect(minList: IntArray, maxMap: MutableMap<Int, Int>): IntArray {
        val result = mutableListOf<Int>()

        minList.forEach {
            if (maxMap[it] != null && maxMap[it]!! > 0) {
                result.add(it)
                maxMap[it] = maxMap[it]!! - 1
            }
        }

        return result.toIntArray()
    }

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        return if (nums1.size < nums2.size) {
            intersect(nums1, buildMap(nums2))
        } else {
            intersect(nums2, buildMap(nums1))
        }
    }
}

fun main() {
    val nums1 = intArrayOf(4,9,5)
    val nums2 = intArrayOf(9,4,9,8,4)

    val result = IntersectionOfTwoArraysII().intersect(nums1, nums2)

    println(result.toList())
}