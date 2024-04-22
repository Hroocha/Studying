package graph_directed.edge;

import graph_directed.vertex.Vertex;

public class DefaultDirectedEdge<V extends Vertex> implements DirectedEdge{
    public V vertexFrom;
    public V vertexTo;
    private final String name;

    public DefaultDirectedEdge(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    @Override
    public V getFrom() {
        return vertexFrom;
    }

    @Override
    public V getTo(){
        return vertexTo;
    }

    @Override
    public void setFrom(Vertex v) {
       this.vertexFrom = (V) v;
    }

    @Override
    public void setTo(Vertex v) {
        this.vertexTo = (V) v;
    }


    @Override
    public Vertex[] getVertexes() {
        return new Vertex[]{vertexFrom,vertexTo};
    }
}