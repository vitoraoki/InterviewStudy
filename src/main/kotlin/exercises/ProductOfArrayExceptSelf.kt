package exercises

import java.util.*

class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val listOfProducts = IntArray(nums.size) {1}
        var previousAccumulator = 1
        var posteriorAccumulator = 1
        for (i in 0 until nums.size) {
            if (i != 0) {
                previousAccumulator *= nums[i - 1]
                posteriorAccumulator *= nums[nums.size - i]
            }

            listOfProducts[i] *= previousAccumulator
            listOfProducts[nums.size - 1 - i] *= posteriorAccumulator
        }

        return listOfProducts
    }

    fun productExceptSelf2(nums: IntArray): IntArray {
        var previousAccumulator = 1
        var posteriorAccumulator = 1
        val previousProduct = LinkedList<Int>()
        val posteriorProduct = LinkedList<Int>()
        for (i in 0 until nums.size) {
            if (i != 0) {
                previousAccumulator *= nums[i - 1]
                posteriorAccumulator *= nums[nums.size - i]
            }

            previousProduct.add(previousAccumulator)
            posteriorProduct.addFirst(posteriorAccumulator)
        }

        val listOfProducts = IntArray(nums.size)
        for (i in 0 until nums.size) {
            listOfProducts[i] = previousProduct[i] * posteriorProduct[i]
        }

        return listOfProducts
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    val result = ProductOfArrayExceptSelf().productExceptSelf(nums)
    println(result)
}