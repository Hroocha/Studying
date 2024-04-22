package graph_directed.graph;

import graph_directed.edge.Edge;
import graph_directed.vertex.Vertex;

public class GraphFirstTry implements Graph {
    private int maxG = 10; // максимальное количество графов
    private int [][] connection; // массив показывает есть ли между графами ребра
    Vertex[] vertices;
    Edge[] edges;
    private int curV;
    private int curE;

    public GraphFirstTry(){
        vertices = new Vertex[maxG];
        edges = new Edge [maxG*maxG]; // количество всех возможных сечетаний вершин, считая сочетания с собой
        connection = new int[maxG][maxG];
        curV = 0;
        curE = 0;

    }

    private class V implements Vertex {
        public String name;
        public boolean isVisited;

        public V (String name){
            this.name = name;
            isVisited = false;
        }
    }

    public boolean checkVisiting(Vertex vertex){ // даем вершину с которой начитаем обход,
        for (int i = 0; i < maxG; i++) { // и будем обходить все вершины
            if (connection[findIndexV(vertices,vertex)][i] == 1 ) {

            } // посмотреть в матрице связей, если есть связь и посещали ли мы такую вершину
        }

        return false;
    }


    public Edge addEdge(Edge edge, Vertex vertex1, Vertex vertex2) {
        connection[findIndexV(vertices,vertex1)][findIndexV(vertices,vertex2)] = 1;// тогда логично внести эту связь в матрицу связи
        edges [curE++] = edge;
        return edge;
    }
    public int findIndexV(Vertex[]vertices, Vertex vertex){
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] == vertex){
                return i;
            }
        }
        return -1;
    }

    public Vertex addVertex(Vertex vertex) {
        vertices[curV++] = vertex;// Добавление в массив вершин
        return vertex;
    }
}
