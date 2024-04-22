package graph_directed;

import graph_directed.edge.DefaultDirectedEdge;
import graph_directed.vertex.DefaultDirectedVertex;
import graph_weight_directed.DirectedWeightedGraph;
import graph_weight_directed.Edge;
import graph_weight_directed.Vertex;

public class Main {


    public static void main(String[] args) {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();
        Vertex A = graph.addVertex(new Vertex("A"));
        Vertex B = graph.addVertex(new Vertex("B"));
        Vertex C = graph.addVertex(new Vertex("C"));
        Vertex D = graph.addVertex(new Vertex("D"));
        Vertex E = graph.addVertex(new Vertex("E"));
        Vertex F = graph.addVertex(new Vertex("F"));
        graph.addEdge(A, B, new Edge("1", 2));
        graph.addEdge(A, C, new Edge("2", 1));
//        graph.addEdge(A, D, new Edge("3", 3));
        graph.addEdge(C, D, new Edge("4", 3));
        graph.addEdge(C, E, new Edge("5", 2));
        graph.addEdge(D, B, new Edge("6", 4));
        graph.addEdge(D, E, new Edge("7", 4));
        graph.addEdge(D, F, new Edge("8", 2));
        graph.addEdge(E, F, new Edge("9", 2));
        graph.findBestWeightWayFromEveryToEvery();






//    DefaultDirectedGraph<MyDirectedVertex, DefaultDirectedEdge<MyDirectedVertex>> graph = new DefaultDirectedGraph<>();
//        var ver1 = new MyDirectedVertex("ver1");
//        var ver2 = new MyDirectedVertex("ver2");
//        var ver3 = new MyDirectedVertex("ver3");
//        var ver4 = new MyDirectedVertex("ver4");
//        DefaultDirectedEdge<MyDirectedVertex> ed1 = new DefaultDirectedEdge<>("ed1");
//        DefaultDirectedEdge<MyDirectedVertex> ed2 = new DefaultDirectedEdge<>("ed2");
//        DefaultDirectedEdge<MyDirectedVertex> ed3 = new DefaultDirectedEdge<>("ed3");
//
//        graph.addEdge(ver1,ver2, ed1);
//        graph.addEdge(ver2,ver3, ed2);
//        graph.addEdge(ver3,ver4, ed3);
////        graph.findPass(ver1,ver4);
//
//        for (var edges: graph.findPass(ver1,ver4)) {
//            System.out.println(edges.getName());
//        }






    }

    static class MyDirectedVertex extends DefaultDirectedVertex<DefaultDirectedEdge<MyDirectedVertex>> {
        private final String name;

        public String getName() {
            return name;
        }

        MyDirectedVertex(String name) {
            this.name = name;
        }
    }


}
