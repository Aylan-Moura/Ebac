public class Main {

    public static void main(String[] args) {

        System.out.println("=== STACK ===");

        Stack stack = new Stack(10);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());

        System.out.println("\n=== QUEUE ===");

        Queue queue = new Queue(10);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front: " + queue.front());
        System.out.println("Rear: " + queue.rear());
        System.out.println("Dequeue: " + queue.dequeue());

        System.out.println("\n=== LINKED LIST ===");

        LinkedList list = new LinkedList();

        list.push(new Node(10));
        list.push(new Node(20));
        list.push(new Node(30));

        list.insert(1, new Node(15));

        list.printList();

        list.remove(2);

        list.printList();

        System.out.println("Element at 1: " + list.elementAt(1).value);

        System.out.println("\n=== HASH MAP ===");

        HashMapCustom map = new HashMapCustom();

        map.put(1, 100);
        map.put(2, 200);
        map.put(12, 300);

        System.out.println("Key 1: " + map.get(1));
        System.out.println("Key 12: " + map.get(12));

        map.delete(2);

        System.out.println("Key 2 after delete: " + map.get(2));
    }
}
