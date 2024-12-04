package exercises

import datastructure.TreeNode

//https://leetcode.com/problems/binary-tree-level-order-traversal/

class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {

        if (root == null) {
            return listOf()
        }

        if (root.left == null && root.right == null) {
            return listOf(listOf(root.`val`))
        }

        val listByLevel = mutableListOf<List<Int>>()

        var currentLevel = mutableListOf(root)
        var nextLevel = mutableListOf<TreeNode>()
        if (root.left != null) nextLevel.add(root.left!!)
        if (root.right != null) nextLevel.add(root.right!!)

        listByLevel.add(currentLevel.map { node -> node.`val` })

        while (nextLevel.size != 0) {
            currentLevel = nextLevel
            nextLevel = mutableListOf()

            currentLevel.forEach {
                if (it.left != null) nextLevel.add(it.left!!)
                if (it.right != null) nextLevel.add(it.right!!)
            }

            listByLevel.add(currentLevel.map { node -> node.`val` })
        }

        return listByLevel
    }
}

fun main() {
    val result = BinaryTreeLevelOrderTraversal().levelOrder(BinaryTreeLevelOrderTraversalTests.test1())
    print(result)
}

object BinaryTreeLevelOrderTraversalTests {
    fun test1(): TreeNode {
        val node1 = TreeNode(3)
        val node2 = TreeNode(9)
        val node3 = TreeNode(20)
        val node4 = TreeNode(15)
        val node5 = TreeNode(7)

        node1.left = node2
        node1.right = node3
        node3.left = node4
        node3.right = node5

        return node1
    }

    fun test2(): TreeNode {
        val node1 = TreeNode(1)
        return node1
    }

    fun test3(): TreeNode? = null

    fun test4(): TreeNode {
        val node1 = TreeNode(3)
        val node2 = TreeNode(9)

        node1.left = node2

        return node1
    }
}

