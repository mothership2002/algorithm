package graph.impl;

import graph.GraphSearch;
import graph.datastructures.Graph;

import java.util.List;
import java.util.stream.IntStream;

public class BreadthFirstSearch extends GraphSearch {

    public BreadthFirstSearch(int count) {
        if (count <= 0) {
            count = 20;
        }
        List<Graph> graphs = IntStream.rangeClosed(1, count).mapToObj(Graph::new).toList();
        for (int i = 0; i < graphs.size(); i++) {
            Graph graph = graphs.get(i);
            for (int j = 1; j <= 2; j++) {
                int nextIndex = i * 2 + j;
                if (nextIndex < count) {
                    graph.addNextGraph(graphs.get(nextIndex));
                }
            }
        }
        this.rootGraph = graphs.get(0);
    }

    @Override
    public void searching(int keyword) {

    }
}
