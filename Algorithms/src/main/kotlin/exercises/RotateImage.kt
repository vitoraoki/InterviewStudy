package exercises

//https://leetcode.com/problems/rotate-image/

class RotateImage {
    private fun rotateExternalElements(matrix: Array<IntArray>, numberOfElements: Int, startPoint: Int) {
        val endPoint = startPoint + numberOfElements - 1

        var i = startPoint //start line and columns
        var j = endPoint //end line and columns

        var count = 0
        while (count < numberOfElements - 1) {
            val index1 = matrix[startPoint][i]
            val index2 = matrix[i][endPoint]
            val index3 = matrix[endPoint][j]
            val index4 = matrix[j][startPoint]

            matrix[startPoint][i] = index4
            matrix[i][endPoint] = index1
            matrix[endPoint][j] = index2
            matrix[j][startPoint] = index3

            count++
            i = startPoint + count
            j = endPoint - count
        }
    }

    fun rotate(matrix: Array<IntArray>) {
        var startpoint = 0
        var numberOfElements = matrix.size
        while (numberOfElements > 1) {
            rotateExternalElements(matrix, numberOfElements, startpoint)
            numberOfElements -= 2
            startpoint++
        }
    }
}

fun main() {
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    RotateImage().rotate(matrix)

    matrix.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }
}