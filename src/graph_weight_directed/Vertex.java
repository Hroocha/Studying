package graph_weight_directed;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
    private String name;
    private final Set<Edge> outgoingEdges = new HashSet<>();
    private final Set<Edge> incomingEdges = new HashSet<>();

    public Vertex(String name) {
        this.name = name;
    }
    public String getName() {return name;};

    public Set<Edge> getOutgoingEdges() {
        return outgoingEdges;
    }


    public Set<Edge> getIncomingEdges() {
        return incomingEdges;
    }
}
