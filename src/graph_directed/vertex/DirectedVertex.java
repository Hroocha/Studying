package graph_directed.vertex;

import graph_directed.edge.Edge;

import java.util.Set;

public interface DirectedVertex <E extends Edge> extends Vertex{
    Set<E> getOutgoingEdges();
    Set<E> getIncomingEdges();
}