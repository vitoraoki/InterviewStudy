package exercises

import java.util.*

class IF<T>(iterList: List<Iterator<T>>) {
    private val queue = LinkedList<Iterator<T>>()

    /*
    int[] arr1 = [1, 2, 3];
    int[] arr2 = [4, 5];
    int[] arr3 = [6, 7, 8, 9];
    */

    init {
        iterList.forEach {
            queue.add(it)
        }
    }

    fun next() : T? {
        return if (hasNext()) {
            val currentQueue = queue.pop()
            val next = currentQueue.next()
            if (currentQueue.hasNext()) {
                queue.add(currentQueue)
            }
            next
        } else {
            null
        }
    }

    fun hasNext(): Boolean = queue.size != 0
}

/*
int[] arr1 = [1, 2, 3];
int[] arr2 = [4, 5];
int[] arr3 = [6, 7, 8, 9];
*/
fun main() {
    val arr1 = listOf(1).iterator()
    val arr2 = listOf(4, 5, 6, 7, 8, 9).iterator()
    val arr3 = listOf(10).iterator()
//    var arr4 = listOf(10).iterator()

    val iterList = listOf(arr1, arr2, arr3)

    val test = IF(iterList)

    while (test.hasNext()) {
        println(test.next())
    }
}