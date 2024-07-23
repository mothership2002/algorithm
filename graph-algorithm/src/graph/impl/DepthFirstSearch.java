package graph.impl;

import graph.GraphSearch;
import graph.datastructures.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class DepthFirstSearch extends GraphSearch {

    private final Stack<Graph> stack = new Stack<>();

    public DepthFirstSearch(int count) {
        if (count <= 0) count = 20;

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
    protected void searching(int keyword) {
        stack.push(rootGraph);
        int count = 0;
        while (!stack.isEmpty()) {
            rootGraph = stack.pop();
            count++;
            if (isEquals(keyword)) {
                System.out.println("[depth] : " + rootGraph.getDepth() + " / [round] : " + count);
                return;
            }
            List<Graph> childList = rootGraph.getNextGraphList();
            for (int i = childList.size() -1; i >= 0; i--) {
                stack.push(childList.get(i));
            }
        }
        System.out.println("keyword not found");
    }
}
