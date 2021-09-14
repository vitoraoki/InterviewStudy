package algorithms

data class AggregatedData(
    val shortestDistance: Int,
    val previousNode: Char
)

class Dijkstra {
    private fun buildShortestDistanceMap(graph: Map<Char, MutableList<Char>>, start: Char): MutableMap<Char, Int> =
        graph.keys.associate {
            when (it) {
                start -> it to 0
                else -> it to Int.MAX_VALUE
            }
        }.toMutableMap()

    private fun buildPreviousVertexMap(graph: Map<Char, MutableList<Char>>): MutableMap<Char, Char> =
        graph.mapValues { it.key }.toMutableMap()

    private fun nodeWithShortestDistance(
        graph: MutableMap<Char, MutableList<Char>>,
        shortestDistanceMap: MutableMap<Char, Int>
    ): Char = shortestDistanceMap.filter { graph[it.key] != null }.minByOrNull { it.value }!!.key

    private fun aggregatedData(
        shortestDistance: MutableMap<Char, Int>,
        previousVertex: MutableMap<Char, Char>
    ): Map<Char, AggregatedData> = shortestDistance.toSortedMap().mapValues {
        AggregatedData(it.value, previousVertex[it.key]!!)
    }

    fun shortestPath(
        graph: MutableMap<Char, MutableList<Char>>,
        edges: Map<String, Int>,
        start: Char
    ): Map<Char, AggregatedData> {
        val shortestDistance = buildShortestDistanceMap(graph, start)
        val previousVertex = buildPreviousVertexMap(graph)

        while (graph.isNotEmpty()) {
            val current = nodeWithShortestDistance(graph, shortestDistance)
            val nodeSiblings = graph[current]!!.filter { graph[it] != null }
            graph.remove(current)

            nodeSiblings.forEach {
                val distance = shortestDistance[current]!! + edges["$current$it"]!!
                if (distance < shortestDistance[it]!!) {
                    shortestDistance[it] = distance
                    previousVertex[it] = current
                }
            }
        }

        return aggregatedData(shortestDistance, previousVertex)
    }
}

fun main() {
    val graph = mutableMapOf(
        'A' to mutableListOf('B', 'D'),
        'B' to mutableListOf('A', 'C', 'D', 'E'),
        'C' to mutableListOf('B', 'E'),
        'D' to mutableListOf('A', 'B', 'E'),
        'E' to mutableListOf('B', 'C', 'D'),
    )
    val edges = buildEdges()
    val result = Dijkstra().shortestPath(graph, edges, 'A')
    println("Vertex  Shortest Distance  Previous Vertex")
    result.forEach { c, aggregatedData ->
        println("$c       ${aggregatedData.shortestDistance}                  ${aggregatedData.previousNode}")
    }
}

fun buildEdges(): Map<String, Int> {
    return mapOf(
        "AB" to 6,
        "AD" to 1,
        "BA" to 6,
        "BC" to 5,
        "BD" to 2,
        "BE" to 2,
        "CB" to 5,
        "CE" to 5,
        "DA" to 1,
        "DB" to 2,
        "DE" to 1,
        "EB" to 2,
        "EC" to 5,
        "ED" to 1
    )
}