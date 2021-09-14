package exercises

//https://leetcode.com/problems/binary-tree-level-order-traversal/

class BinaryTreeLevelOrderTraversal {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

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
    val result = BinaryTreeLevelOrderTraversal().levelOrder(BinaryTreeLevelOrderTraversalTests().test1())
    print(result)
}

class BinaryTreeLevelOrderTraversalTests {
    fun test1(): BinaryTreeLevelOrderTraversal.TreeNode {
        val node1 = BinaryTreeLevelOrderTraversal.TreeNode(3)
        val node2 = BinaryTreeLevelOrderTraversal.TreeNode(9)
        val node3 = BinaryTreeLevelOrderTraversal.TreeNode(20)
        val node4 = BinaryTreeLevelOrderTraversal.TreeNode(15)
        val node5 = BinaryTreeLevelOrderTraversal.TreeNode(7)

        node1.left = node2
        node1.right = node3
        node3.left = node4
        node3.right = node5

        return node1
    }

    fun test2(): BinaryTreeLevelOrderTraversal.TreeNode {
        val node1 = BinaryTreeLevelOrderTraversal.TreeNode(1)
        return node1
    }

    fun test3(): BinaryTreeLevelOrderTraversal.TreeNode? = null

    fun test4(): BinaryTreeLevelOrderTraversal.TreeNode {
        val node1 = BinaryTreeLevelOrderTraversal.TreeNode(3)
        val node2 = BinaryTreeLevelOrderTraversal.TreeNode(9)

        node1.left = node2

        return node1
    }
}

