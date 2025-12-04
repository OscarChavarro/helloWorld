package co.cubestudio.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class Graph {
    private static final int DEFAULT_COST = 1;
    final Map<Integer, GraphNode> nodes = new HashMap<>();

    // Arcs arrays can have 2 or 3 positions: [from, to, <cost>]
    Graph(String[] names, int[][] arcs) {
        for (int i = 1; i <= names.length; i++) {
            nodes.put(i, new GraphNode(i, names[i - 1]));
        }
        for (int[] arc : arcs) {
            GraphNode from = nodes.get(arc[0]);
            GraphNode to = nodes.get(arc[1]);
            int weight = arc.length > 2 ? arc[2] : DEFAULT_COST;
            GraphArc graphArc = new GraphArc(from, to, weight);
            from.addArc(graphArc);
        }
    }

    GraphNode getNodeById(int id) {
        return nodes.get(id);
    }

    List<GraphNode> getAllNodes() {
        return new ArrayList<>(nodes.values());
    }

    public void printPath(List<GraphNode> nodes) {
        for (GraphNode n: nodes) {
            System.out.print("->" + n.getName());
        }
        System.out.print("\n");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (GraphNode node : nodes.values()) {
            sb.append(node.getName()).append(" -> ");
            if (node.getNeighbors().isEmpty()) {
                sb.append("[]\n");
            } else {
                sb.append("[");
                for (int i = 0; i < node.getNeighbors().size(); i++) {
                    GraphArc arc = node.getNeighbors().get(i);
                    sb.append(arc.to().getName()).append("(w=").append(arc.cost()).append(")");
                    if (i < node.getNeighbors().size() - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("]\n");
            }
        }
        return sb.toString();
    }
}
