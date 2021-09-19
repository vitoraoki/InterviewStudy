package exercises

import datastructure.TreeNode
import org.junit.Test
import kotlin.test.assertEquals

class BinaryTreeZigzagLevelOrderTraversalTest {
    private val solution = BinaryTreeZigzagLevelOrderTraversal()

    @Test
    fun `tree is empty returns empty list`() {
        val root = null
        val result = solution.zigzagLevelOrder(root)
        val expected = emptyList<List<Int>>()

        assertEquals(expected, result)
    }

    @Test
    fun `tree has on node returns list with one level list`() {
        val root = TreeNode(1)
        val result = solution.zigzagLevelOrder(root)
        val expected = listOf(listOf(1))

        assertEquals(expected, result)
    }

    @Test
    fun `tree has more than one node returns list of multiple levels test1`() {
        val root = TreeNode(3)
        val node2 = TreeNode(9)
        val node3 = TreeNode(20)
        val node4 = TreeNode(15)
        val node5 = TreeNode(7)
        root.apply {
            left = node2
            right = node3
        }
        node3.apply {
            left = node4
            right = node5
        }
        val result = solution.zigzagLevelOrder(root)
        val expected = listOf(listOf(3), listOf(20, 9), listOf(15, 7))

        assertEquals(expected, result)
    }

    @Test
    fun `tree has more than one node returns list of multiple levels test2`() {
        val root = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        root.apply {
            left = node2
            right = node3
        }
        node2.apply {
            left = node4
            right = node5
        }
        val result = solution.zigzagLevelOrder(root)
        val expected = listOf(listOf(1), listOf(3, 2), listOf(4, 5))

        assertEquals(expected, result)
    }
}