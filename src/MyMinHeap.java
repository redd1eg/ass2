import java.util.NoSuchElementException;

public class MyMinHeap<E extends Comparable<E>> {
    private MyArrayList<E> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void add(E element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public E poll() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException();
        }
        E root = heap.get(0);
        E last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return root;
    }

    public E peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException();
        }
        return heap.get(0);
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown(int index) {
        int leftChild, rightChild, smallest;
        while (true) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            smallest = index;

            if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChild;
            }
            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChild;
            }
            if (smallest == index) {
                break;
            }
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
}
