public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Astana", "Shymkent", 3.5);
        graph.addEdge("Almaty", "Shymkent", 4.2);

        graph.printGraph();
    }
}