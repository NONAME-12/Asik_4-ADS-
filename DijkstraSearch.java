import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private final WeightedGraph<Vertex> graph;
    private final Set<Vertex> unsettledNodes;
    private final Map<Vertex, Double> distances;

    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        this.graph = graph;
        this.unsettledNodes = new HashSet<>();
        this.distances = new HashMap<>();
        dijkstra();
    }

    private void dijkstra() {
        distances.put(source, 0.0);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex current = getVertexWithMinimumWeight(unsettledNodes);
            marked.add(current);
            unsettledNodes.remove(current);

            for (Vertex neighbor : graph.adjacencyList(current)) {
                double newDist = getShortestDistance(current) + getDistance(current, neighbor);

                if (getShortestDistance(neighbor) > newDist) {
                    distances.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private double getDistance(Vertex from, Vertex to) {
        for (Edge<Vertex> edge : graph.getEdges(from)) {
            if (edge.getDest().equals(to)) {
                return edge.getWeight();
            }
        }
        return Double.MAX_VALUE;
    }

    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex min = null;
        for (Vertex v : vertices) {
            if (min == null || getShortestDistance(v) < getShortestDistance(min)) {
                min = v;
            }
        }
        return min;
    }

    private double getShortestDistance(Vertex v) {
        return distances.getOrDefault(v, Double.MAX_VALUE);
    }
}
