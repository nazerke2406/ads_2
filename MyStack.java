public class MyStack<T extends Comparable<T>> {

    // Internal data structure to store stack elements using MyArrayList
    private MyArrayList<T> stack = new MyArrayList<>();
    // MyArrayList is used here because Stack operates on the last added element (LIFO).
    // Array-based lists provide fast access and updates at the end of the list (O(1)),
    // making them ideal for push() and pop() operations.

    // Checks if the stack is empty
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    // Returns the number of elements in the stack
    public int size() {
        return stack.size();
    }

    // Returns the top element without removing it
    public T peek() {
        return stack.getLast(); // Top is the last added item
    }

    // Adds an element to the top of the stack
    public void push(T item) {
        stack.addLast(item); // Add to the end of the internal list
    }

    // Removes and returns the top element from the stack
    public T pop() {
        T top = stack.getLast();  // Save the top element
        stack.removeLast();       // Remove it from the list
        return top;               // Return it to the caller
    }

    // Clears all elements from the stack
    public void clear() {
        stack.clear();
    }
}
