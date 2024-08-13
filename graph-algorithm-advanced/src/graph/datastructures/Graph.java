package graph.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int vertices;
    private final List<Edge> edges;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public int getVertexCount() {
        return vertices;
    }

    public List<Edge> getEdgeList() {
        return edges;
    }

}
