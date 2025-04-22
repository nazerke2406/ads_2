import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {

    // Inner node class representing each element in the list
    private class MyNode {
        T element;          // The data stored in the node
        MyNode next;        // Reference to the next node
        MyNode prev;        // Reference to the previous node

        public MyNode(T element) {
            this.element = element;
        }
    }

    // Pointers to the start and end of the list
    private MyNode head, tail;

    // Counter for the number of elements
    private int length;

    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    // Utility method to check if index is valid
    private void checkBounds(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + length);
        }
    }

    @Override
    public void add(T item) {
        // Add element to the end of the list
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;  // First node in list
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;         // Move tail to new end
        }
        length++;
    }

    @Override
    public void set(int index, T item) {
        // Replace element at index
        checkBounds(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        current.element = item;
    }

    @Override
    public void add(int index, T item) {
        // Insert element at specific index
        if (index == length) {
            add(item);
            return;
        }
        checkBounds(index);
        MyNode newNode = new MyNode(item);

        if (index == 0) {
            // Insert at the head
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            // Insert in the middle
            MyNode current = head;
            for (int i = 0; i < index - 1; i++) current = current.next;
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        length++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);  // Wrapper for insertion at the beginning
    }

    @Override
    public void addLast(T item) {
        add(item);     // Wrapper for insertion at the end
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.element;
    }

    @Override
    public T getFirst() {
        return head.element;  // Return head element
    }

    @Override
    public T getLast() {
        return tail.element;  // Return tail element
    }

    @Override
    public void remove(int index) {
        // Remove element by index
        checkBounds(index);

        if (index == 0) {
            // Remove head
            head = head.next;
            if (head != null) head.prev = null;
        } else if (index == length - 1) {
            // Remove tail
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            // Remove from the middle
            MyNode current = head;
            for (int i = 0; i < index; i++) current = current.next;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        length--;
    }

    @Override
    public void removeFirst() {
        remove(0);  // Remove from head
    }

    @Override
    public void removeLast() {
        remove(length - 1);  // Remove from tail
    }

    @Override
    public void sort() {
        // Bubble sort by comparing and swapping node values
        for (MyNode i = head; i != null; i = i.next) {
            for (MyNode j = i.next; j != null; j = j.next) {
                if (((Comparable) j.element).compareTo(i.element) < 0) {
                    T temp = i.element;
                    i.element = j.element;
                    j.element = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        for (int i = 0; i < length; i++) {
            if (current.element.equals(object)) return i;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        for (int i = length - 1; i >= 0; i--) {
            if (current.element.equals(object)) return i;
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;  // Check if element exists
    }

    @Override
    public Object[] toArray() {
        // Convert list to array
        Object[] result = new Object[length];
        MyNode current = head;
        for (int i = 0; i < length; i++) {
            result[i] = current.element;
            current = current.next;
        }
        return result;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        length = 0;  // Reset list
    }

    @Override
    public int size() {
        return length;  // Return element count
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();  // Return iterator object
    }

    // Inner iterator class
    private class MyIterator implements Iterator<T> {
        private MyNode current = head;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < length;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T value = current.element;
            current = current.next;
            index++;
            return value;
        }
    }
}

