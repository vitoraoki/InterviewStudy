package algorithms

import kotlin.math.floor

class Heap {
    private fun swap(heap: MutableList<Int>, current: Int, new: Int) {
        val aux = heap[current]
        heap[current] = heap[new]
        heap[new] = aux
    }

    fun minHeap(heap: MutableList<Int>) {
        val start = (heap.size / 2) - 1

        (start downTo 0).forEach {
            minHeapify(heap, it)
        }
    }

    private fun minHeapify(heap: MutableList<Int>, i: Int) {
        val n = heap.size
        var smallest = i
        val leftChild = (2 * i) + 1
        val rightChild = (2 * i) + 2

        if (leftChild < n && heap[leftChild] < heap[smallest]) smallest = leftChild
        if (rightChild < n && heap[rightChild] < heap[smallest]) smallest = rightChild

        if (smallest != i) {
            swap(heap, i, smallest)
            minHeapify(heap, smallest)
        }
    }

    fun maxHeap(heap: MutableList<Int>) {
        val start = (heap.size / 2) - 1

        (start downTo 0).forEach {
            maxHeapify(heap, it)
        }
    }

    private fun maxHeapify(heap: MutableList<Int>, i: Int) {
        val n = heap.size
        var largest = i
        val leftChild = (2 * i) + 1
        val rightChild = (2 * i) + 2

        if (leftChild < n && heap[leftChild] > heap[largest]) largest = leftChild
        if (rightChild < n && heap[rightChild] > heap[largest]) largest = rightChild

        if (largest != i) {
            swap(heap, i, largest)
            maxHeapify(heap, largest)
        }
    }
}

fun main() {
    val heap = mutableListOf(1, 12, 9, 5, 6, 10)

    Heap().minHeap(heap)
    print(heap)
}