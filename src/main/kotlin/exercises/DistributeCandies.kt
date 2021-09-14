package exercises//https://leetcode.com/problems/distribute-candies/submissions/

/*
* Perguntas:
* - candyType está ordenado?
*/
class DistributeCandies {
    fun distributeCandies(candyType: IntArray): Int {
        var numTypes = 0
        val n = candyType.size / 2
        val hashTypes = mutableMapOf<Int, Int>()

        candyType.forEach { type ->
            if (hashTypes[type] == null) {
                hashTypes[type] = 1
                numTypes++
            } else {
                hashTypes[type] = hashTypes[type]?.plus(1) ?: 1
            }
        }

        return if (n < numTypes) {
            n
        } else {
            numTypes
        }
    }
}

fun main() {
    val solution = DistributeCandies()
    val candyType = listOf(1,1,2,3)
    println(solution.distributeCandies(candyType.toIntArray()))
}