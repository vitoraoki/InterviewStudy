package exercises

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
    val n = -3
    println(NumberOf1Bits().hammingWeight(n))
}