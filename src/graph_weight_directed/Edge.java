package graph_weight_directed;

public class Edge {
    public Vertex vertexFrom;
    public Vertex vertexTo;
    private final String name;
    private final int weight;


    public Edge(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Vertex getFrom() {
        return vertexFrom;
    }

    public Vertex getTo() {
        return vertexTo;
    }

    public void setFrom(Vertex from) {
        this.vertexFrom = from;
    }

    public void setTo(Vertex to) {
        this.vertexTo = to;
    }

    public int getWeight() {
        return weight;
    }
}
