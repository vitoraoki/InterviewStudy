package exercises

//https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/

class MinimumNumberOfPushesToTypeWordII {
    fun minimumPushes(word: String): Int {
        val charactersCount = mutableMapOf<Char, Int>()

        word.forEach { char ->
            if (charactersCount[char] == null) {
                charactersCount[char] = 1
            } else {
                charactersCount[char] = charactersCount[char]!! + 1
            }
        }

        val countList = charactersCount.values.sortedDescending()

        var pushes = 0
        var totalPushes = 0
        countList.forEachIndexed { index, count ->
            if (index % 8 == 0) {
                pushes += 1
            }
            totalPushes += pushes * count
        }

        return totalPushes
    }
}

fun main() {
    println(MinimumNumberOfPushesToTypeWordII().minimumPushes("abcde"))
    println(MinimumNumberOfPushesToTypeWordII().minimumPushes("xyzxyzxyzxyz"))
    println(MinimumNumberOfPushesToTypeWordII().minimumPushes("aabbccddeeffgghhiiiiii"))
}