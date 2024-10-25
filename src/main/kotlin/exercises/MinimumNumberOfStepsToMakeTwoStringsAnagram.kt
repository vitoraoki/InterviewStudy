package exercises

//https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/

class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    fun minSteps(s: String, t: String): Int {
        val charactersCount = mutableMapOf<Char, Int>()

        s.forEach { character ->
            if (charactersCount[character] == null) {
                charactersCount[character] = 1
            } else {
                charactersCount[character] = charactersCount[character]!! + 1
            }
        }

        var steps = 0

        t.forEach { character ->
            if (charactersCount[character] == null || charactersCount[character]!! <= 0) {
                steps += 1
            } else {
                if (charactersCount[character] != null) {
                    charactersCount[character] = charactersCount[character]!! - 1
                }
            }
        }

        return steps
    }
}

fun main() {
    println(MinimumNumberOfStepsToMakeTwoStringsAnagram().minSteps("bab", "aba"))
    println(MinimumNumberOfStepsToMakeTwoStringsAnagram().minSteps("leetcode", "practice"))
    println(MinimumNumberOfStepsToMakeTwoStringsAnagram().minSteps("anagram", "practice"))
}