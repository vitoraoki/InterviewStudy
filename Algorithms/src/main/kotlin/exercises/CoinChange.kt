package exercises

import kotlin.math.min

class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        coins.sort()
        val table = mutableListOf<MutableList<Int>>(mutableListOf(0))
        (1..amount).forEach { table[0].add(Int.MAX_VALUE) }

        for (i in 1 until coins.size + 1) {
            table.add(mutableListOf(0))
            for (j in 1..amount) {
                if (coins[i - 1] > j) {
                    table[i].add(table[i - 1][j])
                } else {
                    table[i].add(min(table[i - 1][j], 1 + table[i][j - coins[i - 1]]))
                }
            }
        }

        return table[table.size - 1][amount]
    }
}

fun main() {
    val solution = CoinChange()
    val coins = listOf(1,2,5)
    val amount = 6
    println(solution.coinChange(coins.toIntArray(), amount))
}