package algorithms

import kotlin.math.sign

class BinarySearch {
    private fun binarySearch(list: List<Int>, start: Int, end: Int, target: Int): Int {
        if (start == end) {
            return if (list[start] == target) {
                start
            } else {
                -1
            }
        }

        val middleIndex = (start + end) / 2
        return if (target == list[middleIndex]) {
            middleIndex
        } else if (target < list[middleIndex]) {
            binarySearch(list, start, middleIndex, target)
        } else {
            binarySearch(list, middleIndex + 1, end, target)
        }
    }

    fun search(list: List<Int>, target: Int): Int {
        return binarySearch(list, 0, list.size - 1, target)
    }
}

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val index = BinarySearch().search(list, 90)
    println(index)
}