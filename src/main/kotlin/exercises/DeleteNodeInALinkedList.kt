package exercises

import datastructure.ListNode

class DeleteNodeInALinkedList {
    fun deleteNode(node: ListNode?) {
        var currentNode = node
        var nextNode = currentNode!!.next

        while (currentNode != null) {
            if (nextNode != null) {
                currentNode.`val` = nextNode.`val`
                if (nextNode.next == null) {
                    currentNode.next = null
                    currentNode = currentNode.next
                } else {
                    currentNode = currentNode.next
                    nextNode = nextNode.next
                }
            }
        }
    }
}