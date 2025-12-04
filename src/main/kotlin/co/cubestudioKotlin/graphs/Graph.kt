package co.cubestudioKotlin.graphs

class Graph(
    names: Array<String>,
    arcs: Array<IntArray>
) {
    companion object {
        private const val DEFAULT_COST: Int = 1
    }

    private val nodes: MutableMap<Int, GraphNode> = HashMap()

    init {
        for (i in names.indices) {
            val id = i + 1
            nodes[id] = GraphNode(id, names[i])
        }

        for (arc in arcs) {
            if (arc.size < 2) {
                continue
            }
            val fromId = arc[0]
            val toId = arc[1]
            val cost = if (arc.size >= 3) arc[2] else DEFAULT_COST

            val fromNode = nodes[fromId]
                ?: throw IllegalArgumentException("Unknown from node id: $fromId")
            val toNode = nodes[toId]
                ?: throw IllegalArgumentException("Unknown to node id: $toId")

            fromNode.addArc(GraphArc(fromNode, toNode, cost))
        }
    }

    fun getNode(id: Int): GraphNode? = nodes[id]

    fun getAllNodes(): Collection<GraphNode> = nodes.values

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("GraphK:\n")
        for (id in nodes.keys.sorted()) {
            val node = nodes[id]!!
            sb.append("  ")
                .append(node.name)
                .append(" -> ")

            if (node.neighbors.isEmpty()) {
                sb.append("[]\n")
            } else {
                sb.append("[")
                node.neighbors.forEachIndexed { index, arc ->
                    sb.append(arc.to.name)
                        .append("(w=")
                        .append(arc.cost)
                        .append(")")
                    if (index < node.neighbors.size - 1) {
                        sb.append(", ")
                    }
                }
                sb.append("]\n")
            }
        }
        return sb.toString()
    }
}
