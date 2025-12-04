package co.cubestudioKotlin.graphs

class NetflixProblem1DeepFirstTraversalSolution {
    private fun minNumberOfSemesters(n: Int, prerequisites: Array<IntArray>): Int {
        if (n == 0) {
            return 0
        }
        if (prerequisites.isEmpty()) {
            return 1
        }

        val graph = buildGraph(n, prerequisites)
        val longestPath = lengthOfLongestPath(graph)
        return longestPath + 1
    }

    private fun buildGraph(n: Int, prerequisites: Array<IntArray>): Graph {
        val names = Array(n) { i -> "Course${i + 1}" }
        return Graph(names, prerequisites)
    }

    private fun lengthOfLongestPath(graph: Graph): Int {
        val maxDepthsFromNodes = HashMap<GraphNode, Int>()
        val visiting = HashSet<GraphNode>()
        var maxPath = 0
        for (node in graph.getAllNodes()) {
            val pathLength = deepFirstTraversal(node, maxDepthsFromNodes, visiting)
            if (pathLength > maxPath) {
                maxPath = pathLength
            }
        }
        return maxPath
    }

    private fun deepFirstTraversal(
        node: GraphNode,
        maxDepthsFromNodes: MutableMap<GraphNode, Int>,
        visiting: MutableSet<GraphNode>
    ): Int {
        maxDepthsFromNodes[node]?.let { return it }

        check(node !in visiting) { "Graph has at least one cycle" }

        if (node.neighbors.isEmpty()) {
            maxDepthsFromNodes[node] = 0
            return 0
        }

        visiting.add(node)
        var maxDepth = 0
        for (arc in node.neighbors) {
            val neighbor = arc.to
            val depthFromNeighbor = 1 + deepFirstTraversal(neighbor, maxDepthsFromNodes, visiting)
            if (depthFromNeighbor > maxDepth) {
                maxDepth = depthFromNeighbor
            }
        }
        visiting.remove(node)
        maxDepthsFromNodes[node] = maxDepth
        return maxDepth
    }

    private fun testSimpleExample(): Boolean {
        val n = 4
        val prerequisites = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(1, 4)
        )
        return minNumberOfSemesters(n, prerequisites) == 4
    }

    private fun testDisconnectedNodes(): Boolean {
        val n = 4
        val prerequisites = emptyArray<IntArray>()
        return minNumberOfSemesters(n, prerequisites) == 1
    }

    private fun testEmptyGraph(): Boolean {
        val n = 0
        val prerequisites = emptyArray<IntArray>()
        return minNumberOfSemesters(n, prerequisites) == 0
    }

    private fun testDisconnectedGraphs(): Boolean {
        val n = 7
        val prerequisites = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(1, 4),
            intArrayOf(5, 6),
            intArrayOf(6, 7)
        )
        return minNumberOfSemesters(n, prerequisites) == 4
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val instance = NetflixProblem1DeepFirstTraversalSolution()
            println("Test1 (simple): " + instance.testSimpleExample())
            println("Test2 (disconnected nodes): " + instance.testDisconnectedNodes())
            println("Test3 (empty graph): " + instance.testEmptyGraph())
            println("Test4 (disconnected graphs): " + instance.testDisconnectedGraphs())
        }
    }
}
