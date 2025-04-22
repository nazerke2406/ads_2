import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {

    // Internal array used to store elements
    private Object[] arr;

    // Keeps track of the number of elements currently in the list
    private int length;

    // Default constructor initializes array with capacity 5
    public MyArrayList() {
        this(5);
    }

    // Constructor that accepts initial capacity
    public MyArrayList(int initialCapacity) {
        arr = new Object[initialCapacity];
    }

    // Doubles the array size when capacity is reached
    private void increaseCapacity() {
        Object[] temp = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    // Adds an item to the end of the list
    @Override
    public void add(T item) {
        if (length >= arr.length) {
            increaseCapacity(); // Make room if full
        }
        arr[length++] = item; // Add item and increment length
    }

    // Replaces the item at the given index with a new value
    @Override
    public void set(int index, T item) {
        if (index >= arr.length) {
            increaseCapacity(); // Expand if needed (optional logic)
        }
        arr[index] = item;
    }

    // Inserts an item at a specific index, shifting elements right
    @Override
    public void add(int index, T item) {
        if (length >= arr.length) {
            increaseCapacity(); // Ensure there is space
        }
        for (int i = length; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        length++;
    }

    // Inserts an item at the start (index 0)
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // Appends an item to the end of the list
    @Override
    public void addLast(T item) {
        add(item);
    }

    // Retrieves the item at the specified index
    @Override
    public T get(int index) {
        return (T) arr[index];
    }

    // Returns the first element (index 0)
    @Override
    public T getFirst() {
        return (T) arr[0];
    }

    // Returns the last element (at length - 1)
    @Override
    public T getLast() {
        return (T) arr[length - 1];
    }

    // Removes the element at a specific index
    @Override
    public void remove(int index) {
        for (int i = index; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--length] = null; // Clear last element and update length
    }

    // Removes the first element (index 0)
    @Override
    public void removeFirst() {
        remove(0);
    }

    // Removes the last element (at length - 1)
    @Override
    public void removeLast() {
        remove(length - 1);
    }

    // Sorts the list in ascending order using bubble sort
    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (((T) arr[i]).compareTo((T) arr[j]) > 0) {
                    T temp = (T) arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // Returns the first index of the specified object
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(object)) return i;
        }
        return -1;
    }

    // Returns the last index of the specified object
    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i].equals(object)) return i;
        }
        return -1;
    }

    // Checks if an object exists in the list
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Returns a shallow copy of elements in array format
    @Override
    public Object[] toArray() {
        Object[] result = new Object[length];
        System.arraycopy(arr, 0, result, 0, length);
        return result;
    }

    // Clears all elements from the list
    @Override
    public void clear() {
        for (int i = 0; i < length; i++) arr[i] = null;
        length = 0;
    }

    // Returns number of elements in the list
    @Override
    public int size() {
        return length;
    }

    // Provides iterator for use in foreach loops
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    // Inner class that implements Iterator<T> for MyArrayList
    private class MyIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < length;
        }

        @Override
        public T next() {
            return (T) arr[index++];
        }
    }
}