package exercises

class KthSmallestElementBinarySearchTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root != null) {
            return inorderTraversal(root)[k - 1]
        }
        return 0
    }

    private fun inorderTraversal(root: TreeNode): MutableList<Int> {
        val inorderNodes = mutableListOf<Int>()

        if (root.left != null) {
            inorderNodes.addAll(inorderTraversal(root.left!!))
        }

        inorderNodes.add(root.`val`)

        if (root.right != null) {
            inorderNodes.addAll(inorderTraversal(root.right!!))
        }

        return inorderNodes
    }
}

fun main() {
    val node1 = KthSmallestElementBinarySearchTree.TreeNode(1)
    val node2 = KthSmallestElementBinarySearchTree.TreeNode(2).apply {
        left = node1
    }
    val node4 = KthSmallestElementBinarySearchTree.TreeNode(4)
    val node3 = KthSmallestElementBinarySearchTree.TreeNode(3).apply {
        left = node2
        right = node4
    }
    val node6 = KthSmallestElementBinarySearchTree.TreeNode(6)
    val node5 = KthSmallestElementBinarySearchTree.TreeNode(5).apply {
        left = node3
        right = node6
    }

    val solution = KthSmallestElementBinarySearchTree().kthSmallest(node5, 3)
    print(solution)
}