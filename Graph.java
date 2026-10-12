
import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> adjacencyList =
            new LinkedHashMap<>();

    public void addVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {
            System.out.println("Vertex already exists.");
            return;
        }

        adjacencyList.put(vertex, new ArrayList<>());
        System.out.println("Vertex " + vertex + " added.");
    }

    public void addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source) ||
            !adjacencyList.containsKey(destination)) {
            System.out.println(
                "Both vertices must exist. Add them first.");
            return;
        }

        if (source == destination) {
            System.out.println("Self-edges are not allowed.");
            return;
        }

        if (adjacencyList.get(source).contains(destination)) {
            System.out.println("Edge already exists.");
            return;
        }

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);

        System.out.println("Edge added: " +
                           source + " - " + destination);
    }

    public void displayGraph() {
        if (adjacencyList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }

        System.out.println("Graph (Adjacency List):");

        for (int vertex : adjacencyList.keySet()) {
            System.out.println(
                vertex + " -> " + adjacencyList.get(vertex));
        }
    }

    public List<Integer> bfs(int startVertex) {
        List<Integer> result = new ArrayList<>();

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Starting vertex not found.");
            return result;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            result.add(current);

            for (int neighbour :
                    adjacencyList.get(current)) {
                if (visited.add(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }

        return result;
    }

    public List<Integer> dfs(int startVertex) {
        List<Integer> result = new ArrayList<>();

        if (!adjacencyList.containsKey(startVertex)) {
            System.out.println("Starting vertex not found.");
            return result;
        }

        Set<Integer> visited = new HashSet<>();
        dfsHelper(startVertex, visited, result);

        return result;
    }

    private void dfsHelper(
            int vertex,
            Set<Integer> visited,
            List<Integer> result) {

        visited.add(vertex);
        result.add(vertex);

        for (int neighbour : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbour)) {
                dfsHelper(neighbour, visited, result);
            }
        }
    }

    public int vertexCount() {
        return adjacencyList.size();
    }

    public boolean containsVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }
}