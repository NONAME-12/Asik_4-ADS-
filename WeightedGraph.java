import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        map.putIfAbsent(v, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
        addVertex(source);
        addVertex(dest);
        map.get(source).add(new Edge<>(source, dest, weight));
        if (undirected) {
            map.get(dest).add(new Edge<>(dest, source, weight));
        }
    }

    public List<Edge<Vertex>> getEdges(Vertex v) {
        return map.get(v);
    }

    public void printGraph() {
        for (Vertex v : map.keySet()) {
            System.out.print(v + ": ");
            for (Edge<Vertex> e : map.get(v)) {
                System.out.print(e + " | ");
            }
            System.out.println();
        }
    }
}
