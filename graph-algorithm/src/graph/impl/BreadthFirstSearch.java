package graph.impl;

import graph.GraphSearch;
import graph.datastructures.Graph;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch extends GraphSearch {

    private final LinkedList<Graph> queue = new LinkedList<>();

    public BreadthFirstSearch(int count) {
        if (count <= 0) {
            count = 20;
        }
        List<Graph> graphs = getGraphs(count);

        for (int i = 0; i < graphs.size(); i++) {
            Graph graph = graphs.get(i);
            for (int j = 1; j <= 2; j++) {
                int nextIndex = i * 2 + j;
                if (nextIndex < count) {
                    Graph nextGraph = graphs.get(nextIndex);
                    nextGraph.setDepth(graph.getDepth() + 1);
                    graph.addNextGraph(nextGraph);
                }
            }
        }
        this.rootGraph = graphs.get(0);
    }

    @Override
    public void searching(int keyword) {
        queue.add(rootGraph);
        int count = 0;
        while (!queue.isEmpty()) {
            rootGraph = queue.poll();
            count++;
            if (isEquals(keyword)) {
                System.out.println("[depth] : " + rootGraph.getDepth() + " / [round] : " + count);
                return;
            }
            queue.addAll(rootGraph.getNextGraphList());
        }
        System.out.println("keyword not found");
    }
}
