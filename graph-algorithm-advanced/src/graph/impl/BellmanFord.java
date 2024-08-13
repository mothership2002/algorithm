package graph.impl;

import graph.datastructures.Edge;
import graph.datastructures.Graph;

import java.util.Arrays;

public class BellmanFord {

    public void bellmanFord(Graph graph, int startVertex) {

        int vertexCount = graph.getVertexCount();
        int[] distances = new int[vertexCount];

        // init
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int i = 0; i < vertexCount; i++) {
            for (Edge edge : graph.getEdgeList()) {
                int startNode = edge.getStartNode();
                int destinationNode = edge.getDestinationNode();
                int weight = edge.getWeight();

                // infinity and startNode weight + weight less than destination weight.
                if (distances[startNode] != Integer.MAX_VALUE
                        && distances[startNode] + weight < distances[destinationNode]) {
                    distances[destinationNode] = distances[startNode] + weight;
                }
            }
        }

        for (Edge edge : graph.getEdgeList()) {
            int startNode = edge.getStartNode();
            int destinationNode = edge.getDestinationNode();
            int weight = edge.getWeight();

            if (distances[startNode] != Integer.MAX_VALUE
                    && distances[startNode] + weight < distances[destinationNode]) {
                System.out.println("had negative number in graph");
                return;
            }
        }

        printSolution(distances, startVertex);
    }

    private void printSolution(int[] distances, int startVertex) {
        System.out.println("Vertex Distance from Source " + startVertex);
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Vertex " + i + " : " + distances[i]);
        }
    }
}
