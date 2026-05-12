public class LinkedList {

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void push(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = node;
        }

        size++;
    }

    public Node pop() {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            Node removed = head;
            head = null;
            size--;
            return removed;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        Node removed = current.next;
        current.next = null;
        size--;

        return removed;
    }

    public void insert(int index, Node node) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            node.next = head;
            head = node;
            size++;
            return;
        }

        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;

        size++;
    }

    public void remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        size--;
    }

    public Node elementAt(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public int size() {
        return size;
    }

    public void printList() {

        Node current = head;

        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}
