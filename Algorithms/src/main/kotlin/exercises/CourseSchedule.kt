package exercises
//https://leetcode.com/problems/course-schedule-iii/

class CourseSchedule {
    private var totalDays = 0

    private fun getIndexOfMax(course: IntArray, listOfPossibleCourses: MutableList<IntArray>): Int {
        var currentMaxCourse = course
        var maxIndex = -1

        listOfPossibleCourses.forEachIndexed { index, it ->
            if (it[0] > currentMaxCourse[0]) {
                currentMaxCourse = it
                maxIndex = index
            }
        }

        return maxIndex
    }
    private fun updateCourse(course: IntArray, listOfPossibleCourses: MutableList<IntArray>): MutableList<IntArray> {
        val indexOfMax = getIndexOfMax(course, listOfPossibleCourses)

        if (indexOfMax > -1) {
            val updatedTotalDays = totalDays - listOfPossibleCourses[indexOfMax][0] + course[0]

            if (updatedTotalDays <= course[1]) {
                listOfPossibleCourses[indexOfMax] = course
                totalDays = updatedTotalDays
            }
        }

        return listOfPossibleCourses
    }

    fun scheduleCourse(courses: Array<IntArray>): Int {
        var listOfPossibleCourses = mutableListOf<IntArray>()
        courses.sortBy { it[1] }

        courses.forEach {
            if (it[0] <= it[1]) {
                if (totalDays + it[0] <= it[1]) {
                    totalDays += it[0]
                    listOfPossibleCourses.add(it)
                } else {
                    listOfPossibleCourses = updateCourse(it, listOfPossibleCourses)
                }
            }
        }
        return listOfPossibleCourses.size
    }
}

fun main() {
    val courses = CourseScheduleTests.test1()

    val result = CourseSchedule().scheduleCourse(courses)

    println(result)
}

object CourseScheduleTests {
    fun test1() = arrayOf(
        intArrayOf(100, 200), intArrayOf(200, 1300), intArrayOf(1000, 1250), intArrayOf(2000, 3200)
    )

    fun test2() = arrayOf(
        intArrayOf(1, 2)
    )

    fun test3() = arrayOf(
        intArrayOf(3, 2), intArrayOf(4, 3)
    )

    fun test4() = arrayOf(
        intArrayOf(5, 5), intArrayOf(4, 6), intArrayOf(2, 6)
    )

    fun test5() = arrayOf(
        intArrayOf(7, 17),
        intArrayOf(3, 12),
        intArrayOf(10, 20),
        intArrayOf(9, 10),
        intArrayOf(5, 20),
        intArrayOf(10, 19),
        intArrayOf(4, 18)
    )
}

//private var totalDays = 0
//
//    private fun addCourse(course: IntArray, listOfPossibleCourses: MutableList<IntArray>): MutableList<IntArray> {
//        for (i in listOfPossibleCourses.indices) {
//            if (course[0] < listOfPossibleCourses[i][0]) {
//                return (listOfPossibleCourses.subList(0, i) +
//                    mutableListOf(course) +
//                    listOfPossibleCourses.subList(i, listOfPossibleCourses.size)).toMutableList()
//            }
//        }
//        listOfPossibleCourses.add(course)
//        return listOfPossibleCourses
//    }
//
//    private fun updateCourse(course: IntArray, listOfPossibleCourses: MutableList<IntArray>): MutableList<IntArray> {
//        var cumulativeDays = 0
//        val lastIndex = listOfPossibleCourses.lastIndex
//
//        for (i in lastIndex downTo 0) {
//            if (listOfPossibleCourses[i][0] <= course[0]) {
//                break
//            } else {
//                cumulativeDays += listOfPossibleCourses[i][0]
//                val totalDaysUpdated = totalDays - cumulativeDays + course[0]
//                if (totalDaysUpdated <= course[1]) {
//                    listOfPossibleCourses[i] = course
//                    totalDays = totalDaysUpdated
//                    break
//                }
//            }
//        }
//
//        return listOfPossibleCourses
//    }
//
//fun scheduleCourse(courses: Array<IntArray>): Int {
//    var listOfPossibleCourses = mutableListOf<IntArray>()
//    courses.sortBy { it[1] }
//
//    courses.forEach {
//        if (it[0] <= it[1]) {
//            if (totalDays + it[0] <= it[1]) {
//                totalDays += it[0]
//                listOfPossibleCourses = addCourse(it, listOfPossibleCourses)
//            } else {
//                listOfPossibleCourses = updateCourse(it, listOfPossibleCourses)
//            }
//        }
//    }
//    return listOfPossibleCourses.size
//}
