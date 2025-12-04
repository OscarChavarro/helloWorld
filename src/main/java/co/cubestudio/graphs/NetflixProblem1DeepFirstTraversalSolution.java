package co.cubestudio.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class NetflixProblem1DeepFirstTraversalSolution {
    private NetflixProblem1DeepFirstTraversalSolution() {}

    int minNumberOfSemesters(int n, int[][] prerequisites) {
        if (n == 0) {
            return 0;
        }

        if (prerequisites.length == 0) {
            return 1;
        }

        Graph graph = buildGraph(n, prerequisites);
        int longestPath = lengthOfLongestPath(graph);

        return longestPath + 1;
    }

    private Graph buildGraph(int n, int[][] prerequisites) {
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = "Course" + (i + 1);
        }
        return new Graph(names, prerequisites);
    }

    private int lengthOfLongestPath(Graph graph) {
        Map<GraphNode, Integer> maxDepthsFromNodes = new HashMap<>();
        Set<GraphNode> visiting = new HashSet<>();
        int maxPath = 0;
        for (GraphNode node : graph.getAllNodes()) {
            int pathLength = deepFirstTraversal(node, maxDepthsFromNodes, visiting);
            maxPath = Math.max(maxPath, pathLength);
        }
        return maxPath;
    }

    private int deepFirstTraversal(
        GraphNode node,
        Map<GraphNode, Integer> maxDepthsFromNodes,
        Set<GraphNode> visiting) {
        if (maxDepthsFromNodes.containsKey(node)) {
            return maxDepthsFromNodes.get(node);
        }
        if (visiting.contains(node)) {
            return 0;
        }

        visiting.add(node);
        int maxDepth = 0;
        for (GraphArc arc : node.getNeighbors()) {
            GraphNode neighbor = arc.to();
            maxDepth = Math.max(maxDepth, 1 + deepFirstTraversal(neighbor, maxDepthsFromNodes, visiting));
        }
        visiting.remove(node);
        maxDepthsFromNodes.put(node, maxDepth);
        return maxDepth;
    }

    private boolean testSimpleExample() {
        int n = 4;
        int[][] prerequisites = {{1, 2}, {2, 3}, {3, 4}, {1, 4}};
        return minNumberOfSemesters(n, prerequisites) == 4;
    }

    private boolean testDisconnectedNodes() {
        int n = 4;
        int[][] prerequisites = {};
        return minNumberOfSemesters(n, prerequisites) == 1;
    }

    private boolean testEmptyGraph() {
        int n = 0;
        int[][] prerequisites = {};
        return minNumberOfSemesters(n, prerequisites) == 0;
    }

    private boolean testDisconnectedGraphs() {
        int n = 7;
        int[][] prerequisites = {
            {1, 2}, {2, 3}, {3, 4}, {1, 4}, {5, 6}, {6, 7}
        };
        return minNumberOfSemesters(n, prerequisites) == 4;
    }

    public static void main(String[] args) {
        NetflixProblem1DeepFirstTraversalSolution instance = new NetflixProblem1DeepFirstTraversalSolution();
        System.out.println("Test1 (simple): " + instance.testSimpleExample());
        System.out.println("Test2 (disconnected nodes): " + instance.testDisconnectedNodes());
        System.out.println("Test3 (empty graph): " + instance.testEmptyGraph());
        System.out.println("Test4 (disconnected graphs): " + instance.testDisconnectedGraphs());
    }
}
