package co.cubestudioKotlin.graphs

data class GraphNode(
    val id: Int,
    val name: String
) {
    val neighbors: MutableList<GraphArc> = mutableListOf()
    var flagged: Boolean = false

    fun addArc(arc: GraphArc) {
        neighbors.add(arc)
    }
}
