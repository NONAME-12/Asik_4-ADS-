Assignment 4 Overview: In the original lecture code, graphs used a separate Edge class to represent connections. This assignment restructures the graph model so that each Vertex directly contains its own outgoing edges using a map of neighbors and weights. This allows BFS and Dijkstra to be implemented in a more object-oriented way, where all relationships are encapsulated within the Vertex objects themselves.

The new structure still allows the unchanged Main.java from GitHub to run as expected.

Project Structure:

Vertex.javaWeightedGraph.javaSearch.javaBreadthFirstSearch.javaDijkstraSearch.javaMain.java

Design Details:

Vertex uses a string id as identifier and stores a map of outgoing neighbors with weights.

Edge weights are stored as double values.

WeightedGraph handles all vertex and edge creation.

BFS is implemented using a queue and visited set.

Dijkstra uses Java’s PriorityQueue and a record class for queue entries.

The Search interface provides a unified API for both algorithms.

Build and Run Instructions:

Compile: javac -d out src/*.javaRun: java -cp out Main