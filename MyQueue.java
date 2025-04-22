public class MyQueue<T> {

    // Internal data structure to store queue elements using MyLinkedList
    private MyLinkedList<T> queue = new MyLinkedList<>();
    // MyLinkedList is used here because Queue operates on both ends (FIFO).
    // Removing the first element in an array-based list would require shifting all elements (O(n)).
    // A linked list allows fast addition at the tail and removal from the head (O(1)),
    // which is perfect for enqueue() and dequeue() operations.

    // Checks if the queue is empty
    public boolean isEmpty() {
        return queue.size() == 0;
    }

    // Returns the number of elements in the queue
    public int size() {
        return queue.size();
    }

    // Returns the front element without removing it
    public T peek() {
        return queue.getFirst(); // First element is the front
    }

    // Adds an element to the back of the queue
    public void enqueue(T item) {
        queue.addLast(item); // Add to the tail
    }

    // Removes and returns the front element of the queue
    public T dequeue() {
        T front = queue.getFirst();  // Save the front element
        queue.removeFirst();         // Remove it from the head
        return front;                // Return it
    }

    // Clears all elements from the queue
    public void clear() {
        queue.clear();
    }
}
