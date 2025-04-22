public class Main {
    public static void main(String[] args) {
        // Testing our custom array-based list implementation
        testMyArrayList();

        // Testing our custom doubly-linked list implementation
        testMyLinkedList();

        // Testing the stack which uses MyArrayList under the hood
        testMyStack();

        // Testing the queue which is based on MyLinkedList
        testMyQueue();

        // Testing the min-heap that stores data using MyArrayList
        testMyMinHeap();
    }

    public static void testMyArrayList() {
        // Creating a new array list of integers
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        System.out.println("Testing MyArrayList");

        // Adding values to the list
        arrayList.add(100);
        arrayList.add(200);
        arrayList.addFirst(50);
        arrayList.addLast(300);
        arrayList.add(2, 150);

        // Displaying the current list
        printList("Current ArrayList:", arrayList);

        // Testing element access methods
        System.out.println("Element at index 3: " + arrayList.get(3));
        System.out.println("First: " + arrayList.getFirst());
        System.out.println("Last: " + arrayList.getLast());

        // Testing element replacement
        arrayList.set(1, 77);
        printList("After setting index 1 to 77:", arrayList);

        // Removing elements by index and from ends
        arrayList.remove(2);
        arrayList.removeFirst();
        arrayList.removeLast();
        printList("After removing elements:", arrayList);

        // Adding more elements and sorting
        arrayList.add(250);
        arrayList.add(10);
        arrayList.sort();
        printList("Sorted ArrayList:", arrayList);

        // Testing search methods
        System.out.println("Index of 200: " + arrayList.indexOf(200));
        System.out.println("Last index of 200: " + arrayList.lastIndexOf(200));
        System.out.println("Contains 77? " + arrayList.exists(77));

        // Testing size and clearing the list
        System.out.println("Size: " + arrayList.size());
        arrayList.clear();
        System.out.println("Size after clearing: " + arrayList.size());
    }

    public static void testMyLinkedList() {
        // Creating a new linked list of strings
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        System.out.println("\nTesting MyLinkedList");

        // Adding elements in various ways
        linkedList.add("Prada");
        linkedList.add("MiuMiu");
        linkedList.addFirst("YSL");
        linkedList.addLast("Dior");
        linkedList.add(1, "Chanel");

        // Displaying the current list
        printList("Current LinkedList:", linkedList);

        // Accessing elements by index and position
        System.out.println("Element at index 2: " + linkedList.get(2));
        System.out.println("First: " + linkedList.getFirst());
        System.out.println("Last: " + linkedList.getLast());

        // Replacing element at specific index
        linkedList.set(1, "Apple");
        printList("After setting index 1 to Apple:", linkedList);

        // Removing by index, first and last
        linkedList.remove(2);
        linkedList.removeFirst();
        linkedList.removeLast();
        printList("After removing elements:", linkedList);

        // Adding more items and sorting
        linkedList.add("Adidas");
        linkedList.add("Abibas");
        linkedList.sort();
        printList("Sorted LinkedList:", linkedList);

        // Searching for values
        System.out.println("Index of Apple: " + linkedList.indexOf("Apple"));
        System.out.println("Exists G: " + linkedList.exists("Gucci"));

        // Converting to array and printing
        Object[] arr = linkedList.toArray();
        System.out.print("To array: ");
        for (Object o : arr) System.out.print(o + " ");

        // Checking size and clearing the list
        System.out.println("\nSize: " + linkedList.size());
        linkedList.clear();
        System.out.println("Size after clearing: " + linkedList.size());
    }

    public static void testMyStack() {
        // Creating a new stack of strings
        MyStack<String> stack = new MyStack<>();

        System.out.println("\nTesting MyStack");

        // Pushing elements onto the stack
        stack.push("A");
        stack.push("B");
        stack.push("C");

        // Accessing and removing elements from top
        System.out.println("Top of stack: " + stack.peek());
        System.out.println("Removing top: " + stack.pop());
        System.out.println("Now top: " + stack.peek());

        // Checking if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());

        // Clearing stack
        stack.clear();
        System.out.println("Stack cleared. Is empty? " + stack.isEmpty());
    }

    public static void testMyQueue() {
        // Creating a new queue of integers
        MyQueue<Integer> queue = new MyQueue<>();

        System.out.println("\nTesting MyQueue");

        // Adding elements to the queue
        queue.enqueue(11);
        queue.enqueue(22);
        queue.enqueue(33);

        // Accessing and removing from the front
        System.out.println("Front of queue: " + queue.peek());
        System.out.println("Removing front: " + queue.dequeue());
        System.out.println("Now front: " + queue.peek());

        // Checking queue size and clearing
        System.out.println("Queue size: " + queue.size());

        queue.clear();
        System.out.println("Queue cleared. Is empty? " + queue.isEmpty());
    }

    public static void testMyMinHeap() {
        // Creating a new min-heap of integers
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        System.out.println("\nTesting MyMinHeap");

        // Inserting elements (heap will reorder)
        heap.insert(45);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);
        heap.insert(80);

        // Checking and removing min elements
        System.out.println("Min element (root): " + heap.getMin());
        System.out.println("Extracting min: " + heap.extractMin());
        System.out.println("New min after extraction: " + heap.getMin());

        // Checking heap size and clearing
        System.out.println("Heap size: " + heap.size());

        heap.clear();
        System.out.println("Heap cleared. Is empty? " + heap.isEmpty());
    }

    private static <T> void printList(String message, Iterable<T> list) {
        // Utility function to print contents of any list
        System.out.print(message + " ");
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
