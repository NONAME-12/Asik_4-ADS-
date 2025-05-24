import java.util.*;

public class BreadthFirstSearch<Vertex> extends Search<Vertex> {
    private final WeightedGraph<Vertex> graph;

    public BreadthFirstSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        this.graph = graph;
        bfs();
    }

    private void bfs() {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        marked.add(source);

        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            for (Edge<Vertex> edge : graph.getEdges(v)) {
                Vertex w = edge.getDest();
                if (!marked.contains(w)) {
                    marked.add(w);
                    edgeTo.put(w, v);
                    queue.add(w);
                }
            }
        }
    }
}
