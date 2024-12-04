package exercises

import datastructure.TreeNode
import java.util.*

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

class BinaryTreeZigzagLevelOrderTraversal {
    private var isLeft = true

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val listOfLevels = LinkedList<LinkedList<TreeNode>>()
        var listOfNodesByLevel = LinkedList<TreeNode>()
        val listOfValuesByLevel = mutableListOf<List<Int>>()

        listOfNodesByLevel.add(root)
        listOfLevels.add(listOfNodesByLevel)
        listOfValuesByLevel.add(listOfNodesByLevel.map { it.`val` })
        while (listOfLevels.isNotEmpty()) {
            val currentLevel = listOfLevels.removeFirst()
            listOfNodesByLevel = LinkedList<TreeNode>()

            while (currentLevel.isNotEmpty()) {
                val currentNode = currentLevel.removeFirst()

                if (isLeft) {
                    if (currentNode.left != null) listOfNodesByLevel.addFirst(currentNode.left!!)
                    if (currentNode.right != null) listOfNodesByLevel.addFirst(currentNode.right!!)
                } else {
                    if (currentNode.right != null) listOfNodesByLevel.addFirst(currentNode.right!!)
                    if (currentNode.left != null) listOfNodesByLevel.addFirst(currentNode.left!!)
                }
            }

            isLeft = !isLeft
            if (listOfNodesByLevel.isNotEmpty()) {
                listOfLevels.add(listOfNodesByLevel)
                listOfValuesByLevel.add(listOfNodesByLevel.map { it.`val` })
            }
        }

        return listOfValuesByLevel
    }
}

fun main() {
    val node1 = TreeNode(3)
    val node2 = TreeNode(9)
    val node3 = TreeNode(20)
    val node4 = TreeNode(15)
    val node5 = TreeNode(7)

    node1.apply {
        left = node2
        right = node3
    }

    node3.apply {
        left = node4
        right = node5
    }

    val result = BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(node1)
    println(result)
}
