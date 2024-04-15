/*
    Complete the code below, follow the instructions in code
*/

public class Graph {

    private Map<Integer, List<Integer>> adjVertices;

    Graph() {
        adjVertices = new HashMap<>();
    }

    void addVertex(int label) {
        adjVertices.putIfAbsent(label, new ArrayList<>());
    }

    void addEdge(int source, int destination) {
        adjVertices.get(source).add(destination);
        adjVertices.get(destination).add(source);
    }

    void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjVertices.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Graph graph = createGraph();
        System.out.println("Graph:");
        graph.printGraph();
    }

    static Graph createGraph() {
        Graph graph = new Graph();
        // Add loop for adding for 5 Vertex

        // Add 6 edges, specifying the two vertices it connects

        return graph;
    }
}
}