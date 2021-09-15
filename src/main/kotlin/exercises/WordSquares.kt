//https://techdevguide.withgoogle.com/resources/former-interview-question-word-squares/#!

/*
* - Temos uma lista de k strings com tamanho k
*/

class WordSquares {
    fun isSquareWords(k: Int, listOfStrings: List<String>): Boolean {
        val listOfChars = listOfStrings.map { it.toList() }

        (0 until k - 1).forEach { i ->
            (i + 1 until k).forEach { j ->
                if (listOfChars[i][j] != listOfChars[j][i]) return false
            }
        }

        return true
    }
}

/*
* B A L L
* A R E A
* L E A D
* L A D Y
*/
fun main() {
    val listOfStrings = WordSquaresTests.test1()
    println(WordSquares().isSquareWords(listOfStrings.size, listOfStrings))
}

object WordSquaresTests {
    fun test1() = listOf("BALL", "AREA", "LEAD", "LADY")
    fun test2() = listOf("BALL", "ARET", "LEAD", "LADY")
    fun test3() = listOf("BA", "AB")
}

