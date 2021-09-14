import java.util.*

//https://techdevguide.withgoogle.com/resources/former-interview-question-find-longest-word/#

/*
* Perguntas:
* - Caso duas strings tenham o mesmo tamanho, qual retornar?
* - Posso considerar que as strings de D vem em uma lista?
* - Posso usar qualquer estrutura de dados?
* - Posso ter strings vazias em D?
* - Caso nenhuma string em D seja substring de S, o que retornar?
*/

class FindLongestWorld {
    fun isSubstring(target: String, candidate: String): Boolean {

        if (target.length < candidate.length) return false

        val targetQueue = LinkedList(target.toList())
        val candidateQueue = LinkedList(candidate.toList())

        while (candidateQueue.size != 0) {
            val currentChar = candidateQueue.pop()

            while (targetQueue.size != 0) {
                if (currentChar == targetQueue.pop()) {
                    break
                }
            }

            if (targetQueue.size == 0) {
                return candidateQueue.size == 0
            }
        }

        return true
    }

    /*O(K + M), sendo K o tamanho da string target e M o tamanho da string candidate. Isso porque para montar o hashmap
    * e necessario somente percorrer target uma vez e para verificar se candidate é uma substring, so e preciso percorrer
    * candidate uma vez e as operacoes de get do hash e pop da queue sao O(1)
    */
    fun isSubstring2(target: String, candidate: String): Boolean {
        val targetHash = mutableMapOf<Char, LinkedList<Int>>()

        target.forEachIndexed { index, c ->
            if (targetHash[c] == null) {
                targetHash[c] = LinkedList(listOf(index))
            } else {
                targetHash[c]!!.add(index)
            }
        }

        var previousIndex = -1
        candidate.forEach {
            if (targetHash[it] == null) {
                return false
            }

            val currentIndex = targetHash[it]!!.pop()

            if (currentIndex < previousIndex) {
                return false
            } else {
                previousIndex = currentIndex
            }
        }

        return true
    }

    fun getLongestWord(s: String, d: List<String>): String? {
        var biggestLength = 0
        var longestWord: String? = null

        d.forEach {
            if (isSubstring2(s, it)) {
                if (it.length > biggestLength) {
                    biggestLength = it.length
                    longestWord = it
                }
            }
        }

        return longestWord
    }
}


fun main() {
    val s = "abppplee"
    val d = listOf("able", "ale", "apple", "bale", "kangaroo")

    println(FindLongestWorld().getLongestWord(s, d))
    println(FindLongestWorld().isSubstring2(s, d[0]))
    println(FindLongestWorld().isSubstring2(s, d[1]))
    println(FindLongestWorld().isSubstring2(s, d[2]))
    println(FindLongestWorld().isSubstring2(s, d[3]))
    println(FindLongestWorld().isSubstring2(s, d[4]))
}