package exercises

import datastructure.TreeNode

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private var preorderIndex: Int = 0

    private fun searchIndex(inorder: IntArray, rootValue: Int): Int {
        var indexIn = 0
        inorder.forEachIndexed { index, it ->
            if (it == rootValue) {
                indexIn = index
            }
        }
        return indexIn
    }

    private fun buildTree(preorder: IntArray, inorder: IntArray, startIn: Int, endIn: Int): TreeNode {
        val rootTree = TreeNode(preorder[preorderIndex++])

        if (endIn == startIn) return rootTree

        val indexIn = searchIndex(inorder, rootTree.`val`)

        if (indexIn - 1 >= startIn) {
            rootTree.left = buildTree(preorder, inorder, startIn, indexIn - 1)
        }

        if (indexIn + 1 <= endIn) {
            rootTree.right = buildTree(preorder, inorder, indexIn + 1, endIn)
        }

        return rootTree
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode {
        return buildTree(preorder, inorder, 0, inorder.size - 1)
    }
}

fun main() {
    val tree = ConstructBinaryTreeFromPreorderAndInorderTraversalTests.test1()
    println(tree)
}

object ConstructBinaryTreeFromPreorderAndInorderTraversalTests {
    fun test1(): TreeNode {
        val preorder = intArrayOf(3, 9, 20, 15, 7)
        val inorder = intArrayOf(9, 3, 15, 20, 7)
        return ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder)
    }

    fun test2(): TreeNode {
        val preorder = intArrayOf(-1)
        val inorder = intArrayOf(-1)
        return ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder)
    }

    fun test3(): TreeNode {
        val preorder = intArrayOf(1, 2)
        val inorder = intArrayOf(2, 1)
        return ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder)
    }

    fun test4(): TreeNode {
        val preorder = intArrayOf(1, 2, 3)
        val inorder = intArrayOf(1, 2, 3)
        return ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder)
    }
}