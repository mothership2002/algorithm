package graph;

import abs.Search;
import graph.datastructures.Graph;

import java.util.List;
import java.util.stream.IntStream;

public abstract class GraphSearch extends Search {

    protected Graph rootGraph;

    protected boolean isEquals(int keyword) {
        return rootGraph.getValue() == keyword;
    }

    protected List<Graph> getGraphs(int count) {
        if ((count % 2) == 0) {
            return IntStream.rangeClosed(1, count).mapToObj(Graph::new).toList();
        }
        return getReverseGraphs(count);
    }

    protected List<Graph> getReverseGraphs(int count) {
        return IntStream
                .iterate(count, n -> n - 1)
                .limit(count)
                .mapToObj(Graph::new).toList();
    }
}
