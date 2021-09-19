package exercises

//https://leetcode.com/problems/unique-paths/

class UniquePaths {
    private val paths = mutableMapOf<String, Int>()

    private fun uniquePathsSimple(m: Int, n: Int, currentM: Int, currentN: Int): Int {
        var pathsCount = 0

        if (currentM == m - 1 && currentN == n - 1) pathsCount = 1
        if (currentM < m - 1) pathsCount += uniquePathsSimple(m, n, currentM + 1, currentN)
        if (currentN < n - 1) pathsCount += uniquePathsSimple(m, n, currentM, currentN + 1)

        return pathsCount
    }

    fun uniquePathsSimple(m: Int, n: Int): Int {
        return uniquePathsSimple(m, n, 0, 0)
    }

    private fun uniquePathsWithMemoization(m: Int, n: Int, currentM: Int, currentN: Int): Int {
        if (currentM == m - 1 && currentN == n - 1) {
            return 1
        }

        val key = "$currentM:$currentN"
        if (paths[key] != null) {
            return paths[key]!!
        }

        paths[key] = 0
        if (currentM < m - 1) paths[key] = paths[key]!! + uniquePathsWithMemoization(m, n, currentM + 1, currentN)
        if (currentN < n - 1) paths[key] = paths[key]!! + uniquePathsWithMemoization(m, n, currentM, currentN + 1)

        return paths[key]!!
    }

    fun uniquePathsWithMemoization(m: Int, n: Int): Int {
        return uniquePathsWithMemoization(m, n, 0, 0)
    }
}

fun main() {
    println(UniquePaths().uniquePathsWithMemoization(3, 7))
}