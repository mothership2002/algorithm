package graph.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int value;
    private int depth;
    private final List<Graph> nextGraphList = new ArrayList<>();

    public Graph(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public List<Graph> getNextGraphList() {
        return nextGraphList;
    }

    public void changeValue(int value) {
        this.value = value;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void addNextGraph(Graph nextGraph) {
        this.nextGraphList.add(nextGraph);
    }
}
