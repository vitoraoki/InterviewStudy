package exercises

//https://leetcode.com/problems/find-the-maximum-achievable-number

class MaximumAchievableNumber {
    fun theMaximumAchievableX(num: Int, t: Int): Int {
        return num + (t * 2)
    }
}

fun main() {
    println(MaximumAchievableNumber().theMaximumAchievableX(4, 1))
    println(MaximumAchievableNumber().theMaximumAchievableX(3, 2))
}