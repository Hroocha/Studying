package graph_directed.vertex;

import graph_directed.edge.Edge;

import java.util.HashSet;
import java.util.Set;

public class DefaultDirectedVertex<E extends Edge> implements DirectedVertex<E> {
    private final Set<E> outgoingEdges = new HashSet<>();
    private final Set<E> incomingEdges = new HashSet<>();

    @Override
    public Set<E> getOutgoingEdges() {
        return outgoingEdges;
    }

    @Override
    public Set<E> getIncomingEdges() {
        return incomingEdges;
    }
}
