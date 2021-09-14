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
}

fun main() {
    val heap = mutableListOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)

    Sort().heapSortInPlace(heap)
    print(heap)
}