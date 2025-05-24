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

    public List<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return Collections.emptyList();
        List<Vertex> neighbors = new LinkedList<>();
        for (Edge<Vertex> e : map.get(v)) {
            neighbors.add(e.getDest());
        }
        return neighbors;
    }

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        for (Edge<Vertex> edge : map.get(source)) {
            if (edge.getDest().equals(dest)) {
                return true;
            }
        }
        return false;
    }

}