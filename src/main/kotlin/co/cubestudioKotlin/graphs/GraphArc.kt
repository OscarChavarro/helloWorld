package co.cubestudioKotlin.graphs

data class GraphArc(
    val from: GraphNode,
    val to: GraphNode,
    val cost: Int
)
