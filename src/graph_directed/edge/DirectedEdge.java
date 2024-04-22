package graph_directed.edge;

import graph_directed.vertex.Vertex;

public interface DirectedEdge extends Edge {
    Vertex getFrom();
    Vertex getTo();
    void setFrom(Vertex v);
    void setTo(Vertex v);
}
