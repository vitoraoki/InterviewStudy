package algorithms

class TraversalAlgorithms {
    fun depthFirstSearch(graph: Map<Char, MutableList<Char>>, root: Char) {
        val stack = mutableListOf<Char>()
        val visited = mutableMapOf<Char, Boolean>()
        stack.add(root)

        while (stack.isNotEmpty()) {
            val current = stack.last()

            if (visited[current] == null) {
                println(current)
                visited[current] = true
            }

            if (graph[current]!!.isNotEmpty()) {
                val child = graph[current]!!.removeFirst()
                if (visited[child] == null) {
                    stack.add(child)
                }
            } else {
                stack.removeLast()
            }
        }
    }

    fun breadthFirstSearch(graph: Map<Char, MutableList<Char>>, root: Char) {
        val queue = mutableListOf<Char>()
        val visited = mutableMapOf<Char, Boolean>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            if (visited[current] == null) {
                println(current)
                visited[current] = true
                queue.addAll(graph[current]!!.filter { visited[it] == null })
            }
        }
    }
}

fun main() {
    TraversalAlgorithmsTests.testDFS1()
    TraversalAlgorithmsTests.testDFS2()
}

object TraversalAlgorithmsTests {
    fun testDFS1() {
        println("Test DFS 1: ")
        val graph = mapOf(
            '1' to mutableListOf('2', '3', '4'),
            '2' to mutableListOf('5'),
            '3' to mutableListOf('6', '7'),
            '4' to mutableListOf('8'),
            '5' to mutableListOf(),
            '6' to mutableListOf('9'),
            '7' to mutableListOf(),
            '8' to mutableListOf(),
            '9' to mutableListOf()
        )

        TraversalAlgorithms().depthFirstSearch(graph, '1')
    }

    fun testDFS2() {
        println("Test DFS 2: ")
        val graph = mapOf(
            'A' to mutableListOf('B', 'S'),
            'B' to mutableListOf(),
            'S' to mutableListOf('C', 'G'),
            'C' to mutableListOf('D', 'E', 'F', 'S'),
            'G' to mutableListOf('F', 'H', 'S'),
            'D' to mutableListOf('C'),
            'E' to mutableListOf('C', 'H'),
            'F' to mutableListOf('C', 'G'),
            'H' to mutableListOf('E', 'G')
        )

        TraversalAlgorithms().depthFirstSearch(graph, 'A')
    }

    fun testBFS1() {
        println("Test BFS 1: ")
        val graph = mapOf(
            '1' to mutableListOf('2', '3', '4'),
            '2' to mutableListOf('5'),
            '3' to mutableListOf('6', '7'),
            '4' to mutableListOf('8'),
            '5' to mutableListOf(),
            '6' to mutableListOf('9'),
            '7' to mutableListOf(),
            '8' to mutableListOf(),
            '9' to mutableListOf()
        )

        TraversalAlgorithms().breadthFirstSearch(graph, '1')
    }

    fun testBFS2() {
        println("Test BFS 2: ")
        val graph = mapOf(
            'A' to mutableListOf('B', 'S'),
            'B' to mutableListOf(),
            'S' to mutableListOf('C', 'G'),
            'C' to mutableListOf('D', 'E', 'F', 'S'),
            'G' to mutableListOf('F', 'H', 'S'),
            'D' to mutableListOf('C'),
            'E' to mutableListOf('C', 'H'),
            'F' to mutableListOf('C', 'G'),
            'H' to mutableListOf('E', 'G')
        )

        TraversalAlgorithms().breadthFirstSearch(graph, 'A')
    }
}
