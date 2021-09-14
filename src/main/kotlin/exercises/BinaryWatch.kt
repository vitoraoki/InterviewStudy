package exercises

class BinaryWatch {
    fun readBinaryWatch(turnedOn: Int): List<String> {
        val times = mutableListOf<String>()

        if (turnedOn > 8) return times

        val minutes = buildMinutesMap()
        (0..11).forEach { hour ->
            val hourInBits = Integer.bitCount(hour)

            if (turnedOn - hourInBits >= 0 && minutes[turnedOn - hourInBits] != null) {
                val listOfMinutes = minutes[turnedOn - hourInBits]
                listOfMinutes?.forEach {
                    times.add("$hour:$it")
                }
            }
        }
        return times
    }

    private fun buildMinutesMap(): MutableMap<Int, MutableList<String>> {
        val minutesByBits = mutableMapOf<Int, MutableList<String>>()
        (0..59).forEach { minute ->
            val minutesInBits = Integer.bitCount(minute)
            val formattedMinute = if (minute < 10) "0$minute" else "$minute"

            if (minutesByBits[minutesInBits] == null) {
                minutesByBits[minutesInBits] = mutableListOf(formattedMinute)
            } else {
                minutesByBits[minutesInBits]!!.add(formattedMinute)
            }
        }

        return minutesByBits
    }
}

fun main() {
    val test = 6
    println(BinaryWatch().readBinaryWatch(test))
}