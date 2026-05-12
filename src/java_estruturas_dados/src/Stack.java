public class Stack {

    private int[] elements;
    private int top;

    public Stack(int capacity) {
        elements = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == elements.length - 1) {
            throw new RuntimeException("Stack overflow");
        }

        elements[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }

        return elements[top--];
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
