package exercises

import datastructure.ListNode
import kotlin.math.max
import kotlin.math.min

//https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/

class InsertGreatestCommonDivisorsInLinkedList {
    private fun getGreaterCommonDivisorIterative(a: Int, b: Int): Int {
        if (a == 0) return b
        if (b == 0) return a

        var dividend = max(a, b)
        var divisor = min(a, b)
        var remainder = Int.MAX_VALUE

        while (remainder != 0) {
            remainder = dividend % divisor
            dividend = divisor
            divisor = remainder
        }

        return dividend
    }

    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        val next = head.next
        val greaterCommonDivisor = getGreaterCommonDivisorIterative(head.`val`, next!!.`val`)

        head.next = ListNode(greaterCommonDivisor).apply {
            this.next = insertGreatestCommonDivisors(next)
        }

        return head
    }
}

fun main() {
    val nodes = ListNode(18).apply {
        next = ListNode(6).apply {
            next = ListNode(10).apply {
                next = ListNode(3)
            }
        }
    }

    printNodes(InsertGreatestCommonDivisorsInLinkedList().insertGreatestCommonDivisors(nodes))
}

private fun printNodes(node: ListNode?) {
    var next = node
    while (next != null) {
        print("${next.`val`} ")
        next = next.next
    }
}