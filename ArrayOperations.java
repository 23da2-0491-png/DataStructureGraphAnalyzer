
public class ArrayOperations {
    private int[] data = new int[100];
    private int size = 0;

    public void insert(int value) {
        if (size == data.length) {
            System.out.println("Array is full!");
            return;
        }

        data[size] = value;
        size++;
        System.out.println(value + " inserted.");
    }

    public void delete(int value) {
        int index = search(value);

        if (index == -1) {
            System.out.println("Value not found.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        System.out.println(value + " deleted.");
    }

    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }

        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public int[] getData() {
        int[] copy = new int[size];
        for (int i = 0; i < size; i++) {
            copy[i] = data[i];
        }
        return copy;
    }
}