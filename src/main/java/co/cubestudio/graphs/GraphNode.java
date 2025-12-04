package co.cubestudio.graphs;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class GraphNode {
    private final int id;
    private final String name;
    private final List<GraphArc> neighbors;
    private boolean flagged;

    GraphNode(int id, String name) {
        this.id = id;
        this.name = name;
        this.flagged = false;
        this.neighbors = new ArrayList<>();
    }

    void addArc(GraphArc arc) {
        neighbors.add(arc);
    }
}
