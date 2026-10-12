
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PerformanceAnalyzer {

    public static void compareSearch(
            Scanner scanner, int[] data) {

        if (data.length == 0) {
            System.out.println(
                "Insert some array values first.");
            return;
        }

        System.out.print("Enter target value: ");
        int target = readInteger(scanner);

        long start = System.nanoTime();
        SearchingAlgorithms.SearchResult linear =
                SearchingAlgorithms.linearSearch(data, target);
        long linearTime = System.nanoTime() - start;

        long binaryStart = System.nanoTime();
        SearchingAlgorithms.SearchResult binary =
                SearchingAlgorithms.binarySearch(data, target);
        long binaryTime = System.nanoTime() - binaryStart;

        System.out.println("\nSEARCH PERFORMANCE");
        System.out.println("------------------------------");

        System.out.println("Linear Search:");
        System.out.println("Found: " + (linear.index != -1));
        System.out.println("Original array index: " + linear.index);
        System.out.println("Comparisons: " + linear.comparisons);
        System.out.println("Time: " + linearTime + " ns");

        System.out.println("\nBinary Search:");
        System.out.println("Found: " + (binary.index != -1));
        System.out.println("Index in sorted copy: " + binary.index);
        System.out.println("Comparisons: " + binary.comparisons);
        System.out.println("Time (including sorting): "
                           + binaryTime + " ns");
    }

    public static void compareGraph(
            Scanner scanner, Graph graph) {

        if (graph.vertexCount() == 0) {
            System.out.println("Add graph vertices first.");
            return;
        }

        System.out.print("Enter starting vertex: ");
        int startVertex = readInteger(scanner);

        if (!graph.containsVertex(startVertex)) {
            System.out.println("Starting vertex not found.");
            return;
        }

        long start = System.nanoTime();
        List<Integer> bfsResult = graph.bfs(startVertex);
        long bfsTime = System.nanoTime() - start;

        long dfsStart = System.nanoTime();
        List<Integer> dfsResult = graph.dfs(startVertex);
        long dfsTime = System.nanoTime() - dfsStart;

        System.out.println("\nGRAPH PERFORMANCE");
        System.out.println("------------------------------");
        System.out.println("BFS Traversal: " + bfsResult);
        System.out.println("BFS visited vertices: "
                           + bfsResult.size());
        System.out.println("BFS time: " + bfsTime + " ns");

        System.out.println("\nDFS Traversal: " + dfsResult);
        System.out.println("DFS visited vertices: "
                           + dfsResult.size());
        System.out.println("DFS time: " + dfsTime + " ns");
    }

    public static void displayAll(
            int[] data, Graph graph) {

        System.out.println("\nALL RESULTS");
        System.out.println("------------------------------");
        System.out.println("Array values: "
                           + Arrays.toString(data));
        System.out.println("Graph vertices: "
                           + graph.vertexCount());

        if (graph.vertexCount() > 0) {
            List<Integer> reachableVertices =
                    graph.bfs(graphStart(graph));

            System.out.println("Reachable vertices from first vertex: "
                               + reachableVertices);
        }
    }

    private static int graphStart(Graph graph) {
        // Find the first existing vertex by checking
        // integer values from 0 to 1000.
        for (int i = 0; i <= 1000; i++) {
            if (graph.containsVertex(i)) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int readInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid integer: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}