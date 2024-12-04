package algorithms

class BinarySearch {
    private fun binarySearchRecursive(list: List<Int>, start: Int, end: Int, target: Int): Int {
        if (start == end) {
            return if (list[start] == target) {
                start
            } else {
                -1
            }
        }

        val middleIndex = (start + end) / 2
        return if (target <= list[middleIndex]) {
            binarySearchRecursive(list, start, middleIndex, target)
        } else {
            binarySearchRecursive(list, middleIndex + 1, end, target)
        }
    }

    fun searchRecursive(list: List<Int>, target: Int): Int {
        return binarySearchRecursive(list, 0, list.size - 1, target)
    }

    private fun binarySearchIterative(list: List<Int>, target: Int): Int {
        var start = 0
        var end = list.size - 1

        while (start < end) {
            val middleIndex = (start + end) / 2
            if (target <= list[middleIndex]) {
                end = middleIndex
            } else {
                start = middleIndex + 1
            }
        }

        return if (target == list[end]) end else -1
    }

    fun searchIterative(list: List<Int>, target: Int): Int {
        return binarySearchIterative(list, target)
    }
}

fun main() {
    val list = BinarySearchTests.test5()
    val index = BinarySearch().searchIterative(list, 5)
    println(index)
}

object BinarySearchTests {
    fun test1() = listOf(1)
    fun test2() = listOf(1, 1)
    fun test3() = listOf(1, 2)
    fun test4() = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    fun test5() = listOf(1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10)
}