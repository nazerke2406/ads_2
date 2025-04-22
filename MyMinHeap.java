public class MyMinHeap<T extends Comparable<T>> {

    // Internal array-based storage for the heap
    private MyArrayList<T> heap = new MyArrayList<>();
    // MyArrayList is used here because a Heap is best implemented using arrays.
    // The parent-child relationships in a binary heap can be calculated using index formulas:
    // left = 2*i + 1, right = 2*i + 2, parent = (i - 1)/2.
    // This makes arrays more efficient and simpler than linked lists for heap operations.

    // Checks whether the heap is empty
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    // Returns the number of elements in the heap
    public int size() {
        return heap.size();
    }

    // Returns the minimum (root) element without removing it
    public T getMin() {
        return heap.getFirst();
    }

    // Removes and returns the root (minimum) element of the heap
    public T extractMin() {
        T min = heap.get(0); // Store the root element to return later
        T last = heap.get(heap.size() - 1); // Get the last element
        heap.set(0, last); // Move the last element to the root
        heap.removeLast(); // Remove the last element from the heap
        heapifyDown(0); // Restore heap order by pushing down the root
        return min; // Return the original root element
    }

    // Inserts a new element into the heap
    public void insert(T item) {
        heap.addLast(item); // Add to the end
        heapifyUp(heap.size() - 1); // Restore heap order upward
    }

    // Clears all elements from the heap
    public void clear() {
        heap.clear();
    }

    // Moves an element up to restore the min-heap property
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = parentOf(index - 1); // Calculate parent index
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent); // Swap if child is smaller than parent
                index = parent; // Continue moving upward
            } else {
                break; // Stop if order is correct
            }
        }
    }

    // Alternative upward traversal (not always used)
    private void traverseUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T current = heap.get(index);
            T parent = heap.get(parentIndex);

            if (current.compareTo(parent) < 0) {
                heap.set(index, parent);
                heap.set(parentIndex, current);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    // Moves an element down to restore the min-heap property
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = leftChildOf(index + 1); // Get left child index
            int right = rightChildOf(index + 1); // Get right child index
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0)
                smallest = left;

            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0)
                smallest = right;

            if (smallest != index) {
                swap(index, smallest); // Swap with the smaller child
                index = smallest; // Move down the tree
            } else {
                break; // Stop if the heap property is satisfied
            }
        }
    }

    // Calculates the index of the left child
    private int leftChildOf(int index) {
        return 2 * index;
    }

    // Calculates the index of the right child
    private int rightChildOf(int index) {
        return (2 * index) + 1;
    }

    // Calculates the index of the parent
    private int parentOf(int index) {
        return index / 2;
    }

    // Swaps two elements by index
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}