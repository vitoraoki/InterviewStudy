package algorithms

class Sort {
    fun heapSortNewList(list: List<Int>): List<Int> {
        val orderedList = list.toMutableList()
        maxHeap(orderedList, orderedList.size)

        var lastPosition = orderedList.size - 1
        while(lastPosition > 0) {
            swap(orderedList, 0, lastPosition)
            lastPosition--
            maxHeap(orderedList, lastPosition + 1)
        }

        return orderedList
    }

    fun heapSortInPlace(list: MutableList<Int>) {
        maxHeap(list, list.size)

        var lastPosition = list.size - 1
        while(lastPosition > 0) {
            swap(list, 0, lastPosition)
            lastPosition--
            maxHeap(list, lastPosition + 1)
        }
    }

    private fun maxHeap(heap: MutableList<Int>, n: Int) {
        val start = (n / 2) - 1

        (start downTo 0).forEach {
            maxHeapify(heap, it, n)
        }
    }

    private fun swap(heap: MutableList<Int>, current: Int, new: Int) {
        val aux = heap[current]
        heap[current] = heap[new]
        heap[new] = aux
    }


    private fun maxHeapify(heap: MutableList<Int>, i: Int, n: Int) {
        var largest = i
        val leftChild = (2 * i) + 1
        val rightChild = (2 * i) + 2

        if (leftChild < n && heap[leftChild] > heap[largest]) largest = leftChild
        if (rightChild < n && heap[rightChild] > heap[largest]) largest = rightChild

        if (largest != i) {
            swap(heap, i, largest)
            maxHeapify(heap, largest, n)
        }
    }

    private fun merge(list1: List<Int>, list2: List<Int>): List<Int> {
        var i = 0
        var j = 0
        val mergedList = mutableListOf<Int>()

        while(i < list1.size && j < list2.size) {
            if (list1[i] < list2[j]) {
                mergedList.add(list1[i])
                i++
            } else {
                mergedList.add(list2[j])
                j++
            }
        }

        if (i < list1.size) mergedList.addAll(list1.subList(i, list1.size))
        if (j < list2.size) mergedList.addAll(list2.subList(j, list2.size))

        return mergedList
    }

    private fun mergeSort(list: List<Int>, start: Int, end: Int): List<Int> {
        if (start == end) {
            return listOf(list[start])
        }

        val middleIndex = (start + end) / 2

        val list1 = mergeSort(list, start, middleIndex)
        val list2 = mergeSort(list, middleIndex + 1, end)

        return merge(list1, list2)
    }

    fun mergeSort(list: List<Int>): List<Int> {
        if (list.isEmpty()) return list
        return mergeSort(list, 0, list.size - 1)
    }
}

fun main() {
    val result = Sort().mergeSort(SortTests.test3())
    print(result)
}

object SortTests {
    fun test1() = mutableListOf(3, 2, 1)
    fun test2() = mutableListOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
    fun test3() = mutableListOf(2, 4, 1, 10, 1, 2, 5, 7, 8, 1, 9)
    fun test4() = mutableListOf(1)
    fun test5() = mutableListOf<Int>()
}