
public class StackOperations {
    private int[] stack = new int[100];
    private int top = -1;

    public void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Stack is full!");
            return;
        }

        stack[++top] = value;
        System.out.println(value + " pushed onto stack.");
    }

    public Integer pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return null;
        }

        int value = stack[top--];
        System.out.println("Popped: " + value);
        return value;
    }

    public Integer peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return null;
        }

        return stack[top];
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}