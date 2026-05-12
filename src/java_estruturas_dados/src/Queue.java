public class Queue {

    private int[] elements;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        elements = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == elements.length) {
            throw new RuntimeException("Queue overflow");
        }

        rear = (rear + 1) % elements.length;
        elements[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }

        int removed = elements[front];
        front = (front + 1) % elements.length;
        size--;

        return removed;
    }

    public int rear() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return elements[rear];
    }

    public int front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return elements[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
