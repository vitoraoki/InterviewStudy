package exercises

import datastructure.TreeNode
import kotlin.math.max

class BinarySearchTreeToGreaterSumTree {

    private fun bstToGst(root: TreeNode?, offset: Int): Int {
        if (root == null) return offset

        val rightTreeMaxValue = bstToGst(root.right, offset)
        root.`val` += rightTreeMaxValue
        val leftTreeMaxValue = bstToGst(root.left, root.`val`)

        return max(root.`val`, leftTreeMaxValue)
    }

    fun bstToGst(root: TreeNode?): TreeNode? {
        bstToGst(root, 0)
        return root
    }
}

fun main() {
    val root = TreeNode(4).apply {
        right = TreeNode(6).apply {
            right = TreeNode(7).apply {
                right = TreeNode(8)
            }
            left = TreeNode(5)
        }
        left = TreeNode(1).apply {
            right = TreeNode(2).apply {
                right = TreeNode(3)
            }
            left = TreeNode(0)
        }
    }
    printBFS(root)
    BinarySearchTreeToGreaterSumTree().bstToGst(root)
    println()
    printBFS(root)
}

private fun printBFS(root: TreeNode?) {
    val visited = mutableSetOf<TreeNode?>()
    val queue = mutableListOf(root)

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        if (current !in visited) {
            print("${current?.`val`} ")
            visited.add(current)
            current?.left?.let { queue.add(it) }
            current?.right?.let { queue.add(it) }
        }
    }
}

private fun printDFS(root: TreeNode?) {
    val visited = mutableSetOf<TreeNode?>()
    val stack = mutableListOf(root)

    while (stack.isNotEmpty()) {
        val current = stack.last()

        if (current !in visited) {
            print("${current?.`val`} ")
            visited.add(current)
        }

        if (current?.left != null && current.left !in visited) {
            stack.add(current.left)
        } else if (current?.right != null && current.right !in visited) {
            stack.add(current.right)
        } else {
            stack.removeLast()
        }
    }
}
