package co.cubestudio.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class Dijkstra {
    private Dijkstra() {}

    public static List<GraphNode> getShortestPathRecursive(Graph graph, GraphNode source, GraphNode target) {
        Map<GraphNode, Integer> distances = new HashMap<>();
        Map<GraphNode, GraphNode> previous = new HashMap<>();

        for (GraphNode node : graph.getAllNodes()) {
            distances.put(node, node == source ? 0 : Integer.MAX_VALUE);
            node.setFlagged(false);
        }

        recursiveGraphTraversal(source, distances, previous);

        List<GraphNode> path = new ArrayList<>();
        for (GraphNode at = target; at != null; at = previous.get(at)) {
            path.add(at);
        }

        Collections.reverse(path);
        if (path.isEmpty() || path.get(0) != source) {
            return Collections.emptyList();
        }
        return path;
    }

    private static void recursiveGraphTraversal(GraphNode current, Map<GraphNode, Integer> distances, Map<GraphNode, GraphNode> previous) {
        current.setFlagged(true);

        for (GraphArc arc : current.getNeighbors()) {
            GraphNode neighbor = arc.to();
            if (neighbor.isFlagged()) continue;

            int alt = distances.get(current) + arc.cost();
            if (alt < distances.get(neighbor)) {
                distances.put(neighbor, alt);
                previous.put(neighbor, current);
            }
        }

        GraphNode next = null;
        int minDist = Integer.MAX_VALUE;
        for (Map.Entry<GraphNode, Integer> entry : distances.entrySet()) {
            GraphNode node = entry.getKey();
            int dist = entry.getValue();
            if (!node.isFlagged() && dist < minDist) {
                minDist = dist;
                next = node;
            }
        }

        if (next != null) {
            recursiveGraphTraversal(next, distances, previous);
        }
    }
}
