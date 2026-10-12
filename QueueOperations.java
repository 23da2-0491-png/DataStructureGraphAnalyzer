
public class QueueOperations {
    private int[] queue = new int[100];
    private int size = 0;

    public void enqueue(int value) {
        if (size == queue.length) {
            System.out.println("Queue is full!");
            return;
        }

        queue[size] = value;
        size++;
        System.out.println(value + " added to queue.");
    }

    public Integer dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return null;
        }

        int value = queue[0];

        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }

        size--;
        System.out.println("Removed: " + value);
        return value;
    }

    public Integer peek() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return null;
        }

        return queue[0];
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}