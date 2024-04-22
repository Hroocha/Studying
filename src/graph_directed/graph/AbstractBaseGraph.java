package graph_directed.graph;

import graph_directed.edge.Edge;
import graph_directed.vertex.Vertex;

import java.util.Set;

public abstract class AbstractBaseGraph<V extends Vertex, E extends Edge> implements Graph {
    protected Set<E> edges;
    protected Set<V> vertexes;

    void removeEdge(E edge) {
        edges.remove(edge);
    }

    void removeVertex(V vertex) {
        vertexes.remove(vertex);
    }

    public V addVertex(V vertex) {
        vertexes.add(vertex);
        return vertex;
    }

    public abstract E addEdge(V from, V to, E edge);
}
