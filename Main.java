
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final ArrayOperations array =
            new ArrayOperations();
    private static final StackOperations stack =
            new StackOperations();
    private static final QueueOperations queue =
            new QueueOperations();
    private static final LinkedListOperations linkedList =
            new LinkedListOperations();
    private static final Graph graph = new Graph();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n====================================");
            System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("====================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            System.out.println("====================================");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    arrayMenu();
                    break;
                case 2:
                    stackMenu();
                    break;
                case 3:
                    queueMenu();
                    break;
                case 4:
                    linkedListMenu();
                    break;
                case 5:
                    searchMenu();
                    break;
                case 6:
                    graphMenu();
                    break;
                case 7:
                    performanceMenu();
                    break;
                case 8:
                    displayAll();
                    break;
                case 9:
                    running = false;
                    System.out.println("Application closed.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    private static int readInt(String message) {
        System.out.print(message);

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Enter an integer.");
            scanner.next();
            System.out.print(message);
        }

        return scanner.nextInt();
    }

    private static void arrayMenu() {
        while (true) {
            System.out.println("\n--- ARRAY OPERATIONS ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    array.insert(readInt("Enter value: "));
                    break;
                case 2:
                    array.delete(readInt("Enter value to delete: "));
                    break;
                case 3: {
                    int value = readInt("Enter value to search: ");
                    int index = array.search(value);
                    System.out.println(index == -1
                            ? "Value not found."
                            : "Found at index " + index);
                    break;
                }
                case 4:
                    array.display();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void stackMenu() {
        while (true) {
            System.out.println("\n--- STACK OPERATIONS ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    stack.push(readInt("Enter value: "));
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    Integer top = stack.peek();
                    if (top != null) {
                        System.out.println("Top value: " + top);
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void queueMenu() {
        while (true) {
            System.out.println("\n--- QUEUE OPERATIONS ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Front");
            System.out.println("4. Display");
            System.out.println("5. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    queue.enqueue(readInt("Enter value: "));
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    Integer front = queue.peek();
                    if (front != null) {
                        System.out.println("Front value: " + front);
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void linkedListMenu() {
        while (true) {
            System.out.println("\n--- LINKED LIST OPERATIONS ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    linkedList.insert(readInt("Enter value: "));
                    break;
                case 2:
                    linkedList.delete(readInt("Enter value to delete: "));
                    break;
                case 3: {
                    int value = readInt("Enter value to search: ");
                    System.out.println(linkedList.search(value)
                            ? "Value found."
                            : "Value not found.");
                    break;
                }
                case 4:
                    linkedList.display();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void searchMenu() {
        System.out.println("\n--- SEARCHING OPERATIONS ---");
        PerformanceAnalyzer.compareSearch(
                scanner, array.getData());
    }

    private static void graphMenu() {
        while (true) {
            System.out.println("\n--- GRAPH OPERATIONS ---");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    graph.addVertex(readInt("Enter vertex: "));
                    break;
                case 2: {
                    int source = readInt("Enter source vertex: ");
                    int destination =
                            readInt("Enter destination vertex: ");
                    graph.addEdge(source, destination);
                    break;
                }
                case 3:
                    graph.displayGraph();
                    break;
                case 4: {
                    int start = readInt("Enter starting vertex: ");
                    if (graph.containsVertex(start)) {
                        System.out.println("BFS: " + graph.bfs(start));
                    } else {
                        System.out.println("Starting vertex not found.");
                    }
                    break;
                }
                case 5: {
                    int start = readInt("Enter starting vertex: ");
                    if (graph.containsVertex(start)) {
                        System.out.println("DFS: " + graph.dfs(start));
                    } else {
                        System.out.println("Starting vertex not found.");
                    }
                    break;
                }
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void performanceMenu() {
        while (true) {
            System.out.println("\n--- PERFORMANCE COMPARISON ---");
            System.out.println("1. Compare Linear and Binary Search");
            System.out.println("2. Compare BFS and DFS");
            System.out.println("3. Back");

            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    PerformanceAnalyzer.compareSearch(
                            scanner, array.getData());
                    break;
                case 2:
                    PerformanceAnalyzer.compareGraph(scanner, graph);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void displayAll() {
        System.out.println("\n========== ALL RESULTS ==========");
        array.display();
        stack.display();
        queue.display();
        linkedList.display();
        graph.displayGraph();
    }
}