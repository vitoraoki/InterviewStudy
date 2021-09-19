package exercises

import datastructure.ListNode

//https://leetcode.com/problems/odd-even-linked-list/

class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) {
            return head
        }

        var isEven = false
        var current = head

        var headEven: ListNode? = null
        var lastEven = headEven
        var lastOdd: ListNode? = null

        while(current != null) {
            if (isEven) {
                if (headEven == null) {
                    headEven = current
                    lastEven = headEven
                } else {
                    lastEven?.next = current
                    lastEven = lastEven?.next
                }
                lastOdd?.next = current.next
            } else {
                lastOdd = current
            }
            isEven = !isEven
            current = current.next
        }
        lastEven?.next = null

        lastOdd?.next = headEven
        return head
    }
}

fun printList(head: ListNode?) {
    var current = head

    while(current != null) {
        println(current.`val`)
        current = current.next
    }
}

fun main() {
    val result = OddEvenLinkedList().oddEvenList(OddEvenLinkedListTests.test1())

    printList(result)
}

object OddEvenLinkedListTests {
    fun test1(): ListNode {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)


        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = null

        return node1
    }

    fun test2(): ListNode {
        val node1 = ListNode(2)
        val node2 = ListNode(1)
        val node3 = ListNode(3)
        val node4 = ListNode(5)
        val node5 = ListNode(6)
        val node6 = ListNode(4)
        val node7 = ListNode(7)


        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7
        node7.next = null

        return node1
    }

    fun test3(): ListNode {
        val node1 = ListNode(2)

        node1.next = null

        return node1
    }

    fun test4(): ListNode {
        val node1 = ListNode(5)
        val node2 = ListNode(8)

        node1.next = node2
        node2.next = null

        return node1
    }

    fun test5(): ListNode? = null
}


