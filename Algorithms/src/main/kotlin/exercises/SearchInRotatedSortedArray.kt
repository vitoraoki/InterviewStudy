package exercises

//https://leetcode.com/problems/search-in-rotated-sorted-array/

class SearchInRotatedSortedArray {
    private fun modifiedBinarySearch(list: IntArray, start: Int, end: Int, target: Int): Int {
        if (start == end) {
            return if (list[start] == target) {
                start
            } else {
                -1
            }
        }

        val middleIndex = (start + end) / 2
        if (target == list[middleIndex]) {
            return middleIndex
        }

        return if (target >= list[start] && target <= list[middleIndex]) {
            modifiedBinarySearch(list, start, middleIndex, target)
        } else {
            if (target >= list[middleIndex + 1] && target <= list[end]) {
                modifiedBinarySearch(list, middleIndex + 1, end, target)
            } else {
                if (list[start] > list[middleIndex]) {
                    modifiedBinarySearch(list, start, middleIndex, target)
                } else {
                    modifiedBinarySearch(list, middleIndex + 1, end, target)
                }
            }
        }
    }

    fun search(nums: IntArray, target: Int): Int {
        return modifiedBinarySearch(nums, 0, nums.size - 1, target)
    }
}

fun main() {
    val index = SearchInRotatedSortedArrayTests.test1()
    println(index)
}

object SearchInRotatedSortedArrayTests {
    fun test1(): Int {
        val nums = intArrayOf(4,5,6,7,0,1,2)
        val target = 0
        return SearchInRotatedSortedArray().search(nums, target)
    }

    fun test2(): Int {
        val nums = intArrayOf(4,5,6,7,0,1,2)
        val target = 3
        return SearchInRotatedSortedArray().search(nums, target)
    }

    fun test3(): Int {
        val nums = intArrayOf(1)
        val target = 0
        return SearchInRotatedSortedArray().search(nums, target)
    }
}