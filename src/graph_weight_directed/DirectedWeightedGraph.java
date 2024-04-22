package graph_weight_directed;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DirectedWeightedGraph {

    private final Set<Vertex> vertices;
    private final Set<Edge> edges;
    private final Integer infinity = 20;

    public DirectedWeightedGraph() {
        this.edges = new HashSet<>();
        this.vertices = new HashSet<>();
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    void removeVertex(Vertex vertex) {
        vertices.remove(vertex);
    }

    public Vertex addVertex(Vertex vertex) {
        vertices.add(vertex);
        return vertex;
    }

    public Edge addEdge(Vertex from, Vertex to, Edge edge) {
        edges.add(edge);
        edge.setFrom(from);
        edge.setTo(to);
        from.getOutgoingEdges().add(edge);// думаю в вертекс нужно добавить информацию о том что от нее теперь есть ребро, сделала через сэт
        to.getIncomingEdges().add(edge);
        return edge;
    }

    /* Дейкстра
    найти и обойти все вертексы между from и to, через поиск по ссылкам от ребер (в глубину),
    1. начинаю с from ищу ребра, для каждого ребра беру вершину to и проверяю есть ли она в map, если нет, то передаю в map, а значение даю infinity
    сравниваю ее текущее значение и (вес ребра + вес вершины from) записываю меньшее значение в значение вершины
    2. передаю вершину to в метод прохода
    3. возвращаю значение вертекса to
     */

    //    public void findShortestWay(){
//        Vertex vertex = vertices.stream().findFirst().get();
//        Edge minEdge = vertex.getOutgoingEdges().stream().min(Comparator.comparingInt(Edge::getWeight)).get();
//    }
    public Integer findBestPassWeight(Vertex from, Vertex to) {
        HashMap<Vertex, Integer> vertexesFromTo = new HashMap<>();
        vertexesFromTo.put(from, 0); // сразу закину первое значение от него до него путь = 0, а у остальных изначально будет бесконечность
        passToFindAllVertexesBetweenFromTo(from, to, vertexesFromTo);
        return vertexesFromTo.get(to);
    }

    public void passToFindAllVertexesBetweenFromTo(Vertex vertex, Vertex to, HashMap<Vertex, Integer> vertexesFromTo) {
        if (vertex.getOutgoingEdges() != null) { // есть ребра из
            for (Edge edge : vertex.getOutgoingEdges()) {
                Vertex curVertexTo = edge.vertexTo;
                if (!vertexesFromTo.containsKey(curVertexTo)) {
                    vertexesFromTo.put(curVertexTo, infinity);
                }
                int weightOfWayBeforeCurVertexTo = edge.getWeight() + vertexesFromTo.get(vertex);
                if (weightOfWayBeforeCurVertexTo < vertexesFromTo.get(curVertexTo)) {
                    vertexesFromTo.put(curVertexTo, weightOfWayBeforeCurVertexTo);
                }
                if (curVertexTo.equals(to)) {
                    return;
                }
                passToFindAllVertexesBetweenFromTo(curVertexTo, to, vertexesFromTo);
            }

        }
    }

    /* Флойд
    1. Создать матрицу кратчайшего пути от вершины к вершине ( i и j заполняется из сета вершин), изначально все значения равны бесконечности
    2. матрица записывает в значение мин. путь, (но если i = j, то значение будет 0)
     2.1. берем текущее значение (бесконечность) и сравниваем со значением (вес ребра от i до j) записываем мин.
     2.2. берем текущее значение и сравниваем со значением (вес ребра от a до x + от x до b) напрямую до x без других вершин записываем мин.
     2.3. все дальнейшие проходы должны разрешать искать путь через отработанные выше (на предыдущей итерации) вершины x   записываем мин.
     уонечные результаты будут получены, когда будут пройдены все значения из матрицы столько раз сколько вершин в графе

     1. сначала создаю и заполняю 2 матрицы:
     1.1. делаю матрицу 1 distance с длиной от каждой вершины до каждой:
     правила заполнения матрицы:
     - заполняются весом ребра, только если есть проход напрямую, без других вертексов
     - если прохода нет, то вписываю бесконечность inf
     1.2. делаю матрицу 2 way с записью о том есть ли вообще прямой проход к вершине или нет (заполнены будут в одинаковых местах с 1-ой матрицей)
     - если проход есть, то матрица[i][j] = j
     - если нет, то 0
     2. для каждого j (for each 1) по каждому i (for each 2) проверяю по матрице 1 не равно ли оно inf
     2.1. и если не равно, то для каждого x (for each 3) x - это те же вершины, но проще будет думать что это i2
     проверяю будет ли путь от ij + jx короче чем ix, если да, то матрица 1 записывает (перезаписывает, т.к. x   значение
     */

    public void findBestWeightWayFromEveryToEvery() {
        int[][] distance = new int[vertices.size()][vertices.size()]; // здесь значением будет вес пути
        int[][] way = new int[vertices.size()][vertices.size()]; // здесь значением будет путь, значение будет ссылаться на след. шаг
        Vertex[] vert = new Vertex[vertices.size()];    // пояснение: сделала массив вертексов, они соответствуют i и j в матрице,
        int x = 0;                                       // и считаем что индексы i и j соответствуют индексам массива vert
        for (Vertex vertex : vertices) {
            vert[x++] = vertex;
        }
        for (int i = 0; i < vert.length; i++) {            // заполняю матрицу distance и way
            for (int j = 0; j < vert.length; j++) {
                if (i == j) {                                  // заполняю матрицу distance бесконечностью и нулями, а матрицу way нулями
                    distance[i][j] = 0;
                    way[i][j] = 0;
                } else distance[i][j] = infinity;
                for (Edge edge : vert[i].getOutgoingEdges()) { // для каждого ребра i-той вершины
                    if (edge.vertexTo.equals(vert[j])) {    // смотрю не равны ли вершина j и вершина в которую идет ребро
                        distance[i][j] = edge.getWeight();  // и если равны, значит записываю вес ребра в матрицу distance
                        way[i][j] = j;                      // в матрицу way записываю что путь есть, отмечаю j, она означает,
                    } // что для поиска путь нам нужно будет перейти на i с таким же индексом(что указано в ячейке), и если теперь в ячейке [i][j] 0, то путь окончен в предыдущем [i][j]
                }
            }
        }
        printMatrix(distance); // заполняет верно

        System.out.println();
        for (int i = 0; i < vert.length; i++) { // массив B F A E D C
            System.out.print(" " + vert[i].getName());
        }
        System.out.println();

        //
        for (int i = 0; i < vert.length; i++) {
            for (int j = 0; j < vert.length; j++) {
                if(distance[i][j] != infinity){
                    for (int y = 0; y < vert.length; y++) {
                        if(distance[i][y] > (distance[i][j] + distance[j][y])){
                            distance[i][y] = distance[i][j] + distance[j][y];
                            way[i][y] = way[i][j];
                        }
                    }
                }

            }
        }

        printMatrix(distance);
//        System.out.println();
//        printMatrix(way);
    }


//    private void printShortestWay(Vertex from, Vertex to){
//        System.out.println(from.);
//    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}