package exercises

//https://leetcode.com/problems/number-of-1-bits

class NumberOf1Bits {
    fun hammingWeight(n:Int):Int {
        var count = 0
        var number = n.toUInt()
        while (number > 0u) {
            val remainder = number % 2u
            if (remainder == 1u) count++
            number /= 2u
        }
        return count
    }
}

fun main() {
    val n = 11
    println(NumberOf1Bits().hammingWeight(n))
}