package graph_directed.graph;

import graph_directed.edge.DirectedEdge;
import graph_directed.vertex.DirectedVertex;
import graph_directed.vertex.Vertex;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class DefaultDirectedGraph<V extends DirectedVertex<E>, E extends DirectedEdge> extends AbstractBaseGraph<V, E> {

    private int sumOfVertex;
    public DefaultDirectedGraph() {
        edges = new HashSet<>();
        vertexes = new HashSet<>();
    }

    @Override
    public E addEdge(V from, V to, E edge) {
//        throw new UnsupportedOperationException();
        edges.add(edge);
        edge.setFrom(from);
        edge.setTo(to);
        from.getOutgoingEdges().add(edge);// думаю в вертекс нужно добавить информацию о том что от нее теперь есть ребро, сделала через сэт
        to.getIncomingEdges().add(edge);
        return edge;
    }

    public LinkedList<E> findPass(V from, V to) {// беру вершину начала, ищу ребра, и рекурсивно иду по каждому в поисках
//        throw new UnsupportedOperationException();
        LinkedList<E> way = new LinkedList<>(); // список с пройденным путем (по ребрам)
        int[] isFound = new int[]{0};
        passToFindWay(from, to, way, isFound);
        return way;
    }

    @SuppressWarnings("unchecked")
    private void passToFindWay(DirectedVertex<E> vertex, DirectedVertex<E> to, LinkedList<E> way, int[] isFound) { // идем по каждому ребру в глубину
        if (vertex.getOutgoingEdges() != null) { // если есть путь
            for (E edge : vertex.getOutgoingEdges()) {
                way.add(edge);
                Vertex vert = edge.getTo();
                if (vert.equals(to)) {
                    isFound[0] = 1;
                    return;
                } else {
                    passToFindWay((DirectedVertex<E>) vert, to, way, isFound);
                }
            }
        }
        if (isFound[0] == 0) { // если тупик или с самого начала нет ребер или нет верного пути, то путь остается пустой
            if (way.size() != 0) {
                way.remove();
            }
        }
    }

    public void dfs(){
        // взять верншину (первую из сета вершин), добавить ей маркер о посещении, распечатать вершину
        // (нужен еще стак, туда складываем вершины) положить вершину через пуш
        // беру ребра текущей вершины и прохожу по ним к вершинам вглубь каждую пройденную вершину
        // помечаю пройденной и закидываю с стак(чтобы в конце понять что все вершины прошла и можно заканчивать)
        //
    }

    public void visitAll(V startFrom) {

        Set<V> visited = new HashSet<>();
        for (E edge : edges) {
            visited.add(startFrom);
            visited.contains(startFrom);
        }
    }



}
