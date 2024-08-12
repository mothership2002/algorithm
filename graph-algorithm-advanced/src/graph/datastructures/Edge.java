package graph.datastructures;

public class Edge {
    private final int startNode;
    private final int destinationNode;
    private final int weight;

    public Edge(int startNode, int destinationNode, int weight) {
        this.startNode = startNode;
        this.destinationNode = destinationNode;
        this.weight = weight;
    }

    public int getStartNode() {
        return startNode;
    }

    public int getDestinationNode() {
        return destinationNode;
    }

    public int getWeight() {
        return weight;
    }
}
