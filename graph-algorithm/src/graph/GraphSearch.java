package graph;

import abs.Algorithm;
import graph.datastructures.Graph;

public abstract class GraphSearch extends Algorithm {

    protected Graph rootGraph;

    protected void initGraph(Graph graph) {
        this.rootGraph = graph;
    }

}
