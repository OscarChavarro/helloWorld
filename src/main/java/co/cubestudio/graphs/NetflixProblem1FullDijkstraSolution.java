package co.cubestudio.graphs;

import java.util.List;

public final class NetflixProblem1FullDijkstraSolution {
    private static final int NO_PATH = Integer.MIN_VALUE;

    private static final String NODE_ONE = "One";
    private static final String NODE_TWO = "Two";
    private static final String NODE_THREE = "Three";
    private static final String NODE_FOUR = "Four";
    private static final String NODE_FIVE = "Five";
    private static final String NODE_SIX = "Six";
    private static final String NODE_SEVEN = "Seven";

    private NetflixProblem1FullDijkstraSolution() {
    }

    private int lengthOfLongestPath(Graph graph) {
        if (graph.getAllNodes().isEmpty()) {
            return 0;
        }
        int maxPath = Integer.MIN_VALUE;
        for (GraphNode sourceNode : graph.getAllNodes()) {
            for (GraphNode targetNode : graph.getAllNodes()) {
                List<GraphNode> path = Dijkstra.getShortestPathRecursive(graph, sourceNode, targetNode);
                int currentLength = path.size();
                if (currentLength != 0 && currentLength > maxPath) {
                    maxPath = currentLength;
                }
            }
        }
        return maxPath == NO_PATH ? 1 : maxPath;
    }

    public boolean testSimpleExample() {
        String[] nodeNames = {NODE_ONE, NODE_TWO, NODE_THREE, NODE_FOUR};
        int[][] arcs = {{1, 2}, {2, 3}, {3, 4}, {1, 4}};

        Graph graph = new Graph(nodeNames, arcs);
        return lengthOfLongestPath(graph) == 3;
    }

    public boolean testDisconnectedNodes() {
        String[] nodeNames = {NODE_ONE, NODE_TWO, NODE_THREE, NODE_FOUR};
        int[][] arcs = {};

        Graph graph = new Graph(nodeNames, arcs);
        return lengthOfLongestPath(graph) == 1;
    }

    public boolean testEmptyGraph() {
        String[] nodeNames = {};
        int[][] arcs = {};

        Graph graph = new Graph(nodeNames, arcs);
        return lengthOfLongestPath(graph) == 0;
    }

    public boolean testDisconnectedGraphs() {
        String[] nodeNames = {NODE_ONE, NODE_TWO, NODE_THREE, NODE_FOUR, NODE_FIVE, NODE_SIX, NODE_SEVEN};
        int[][] arcs = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {5, 6}, {6, 7}};

        Graph graph = new Graph(nodeNames, arcs);
        return lengthOfLongestPath(graph) == 3;
    }

    public static void main(String[] args) {
        NetflixProblem1FullDijkstraSolution instance = new NetflixProblem1FullDijkstraSolution();
        System.out.println("Test1 (simple): " + instance.testSimpleExample());
        System.out.println("Test2 (disconnected nodes): " + instance.testDisconnectedNodes());
        System.out.println("Test3 (empty graph): " + instance.testEmptyGraph());
        System.out.println("Test4 (disconnected graphs): " + instance.testDisconnectedGraphs());
    }
}
