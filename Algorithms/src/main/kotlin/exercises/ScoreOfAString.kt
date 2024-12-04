package exercises

import kotlin.math.absoluteValue

//https://leetcode.com/problems/score-of-a-string/description/

class ScoreOfAString {
    fun scoreOfString(s: String): Int {
        var score = 0

        for (i in s.indices) {
            if (i < (s.length - 1)) {
                score += (s[i].code - s[i + 1].code).absoluteValue
            }
        }
        return score
    }
}

fun main() {
    println(ScoreOfAString().scoreOfString("hello"))
    println(ScoreOfAString().scoreOfString("zaz"))
}