package algorithms

class TreeTraversal {
    fun inorder(tree: List<Int>, root: Int): List<Int> {
        val leftChild = (2 * root) + 1
        val rightChild = (2 * root) + 2
        val inorderList = mutableListOf<Int>()

        if (leftChild < tree.size) {
            inorderList.addAll(inorder(tree, leftChild))
        }

        inorderList.add(tree[root])

        if (rightChild < tree.size) {
            inorderList.addAll(inorder(tree, rightChild))
        }

        return inorderList
    }

    fun preorder(tree: List<Int>, root: Int): List<Int> {
        val leftChild = (2 * root) + 1
        val rightChild = (2 * root) + 2
        val inorderList = mutableListOf<Int>()

        inorderList.add(tree[root])

        if (leftChild < tree.size) {
            inorderList.addAll(preorder(tree, leftChild))
        }

        if (rightChild < tree.size) {
            inorderList.addAll(preorder(tree, rightChild))
        }

        return inorderList
    }

    fun postorder(tree: List<Int>, root: Int): List<Int> {
        val leftChild = (2 * root) + 1
        val rightChild = (2 * root) + 2
        val inorderList = mutableListOf<Int>()

        if (leftChild < tree.size) {
            inorderList.addAll(postorder(tree, leftChild))
        }

        if (rightChild < tree.size) {
            inorderList.addAll(postorder(tree, rightChild))
        }

        inorderList.add(tree[root])

        return inorderList
    }
}

fun main() {
    val tree = listOf(1, 2, 3, 4, 5)

    print("Inorder: ")
    println(TreeTraversal().inorder(tree, 0))

    print("Preorder: ")
    println(TreeTraversal().preorder(tree, 0))

    print("Postorder: ")
    println(TreeTraversal().postorder(tree, 0))
}