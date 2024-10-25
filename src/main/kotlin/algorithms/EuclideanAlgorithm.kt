package algorithms

import kotlin.math.max
import kotlin.math.min

class EuclideanAlgorithm {
    fun getGreaterCommonDivisorIterative(a: Int, b: Int): Int {
        if (a == 0) return b
        if (b == 0) return a

        var dividend = max(a, b)
        var divisor = min(a, b)
        var remainder = Int.MAX_VALUE

        while (remainder != 0) {
            remainder = dividend % divisor
            dividend = divisor
            divisor = remainder
        }

        return dividend
    }

    fun getGreaterCommonDivisorRecursive(a: Int, b: Int): Int {
        if (a == 0) return b
        if (b == 0) return a

        val dividend = max(a, b)
        val divisor = min(a, b)

        return getGreaterCommonDivisorRecursive(divisor, dividend % divisor)
    }
}

fun main() {
    println(EuclideanAlgorithm().getGreaterCommonDivisorIterative(40, 24))
    println(EuclideanAlgorithm().getGreaterCommonDivisorIterative(270, 192))

    println(EuclideanAlgorithm().getGreaterCommonDivisorRecursive(40, 24))
    println(EuclideanAlgorithm().getGreaterCommonDivisorRecursive(270, 192))
}