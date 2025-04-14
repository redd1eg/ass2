import java.util.NoSuchElementException;

// MyMinHeap - реализация минимальной кучи на основе MyArrayList
public class MyMinHeap<E extends Comparable<E>> {
    private MyArrayList<E> heap; // Массив для хранения элементов кучи

    // Конструктор, инициализирующий пустую кучу
    public MyMinHeap() {
        heap = new MyArrayList<>(); // Используем MyArrayList для хранения элементов кучи
    }

    // Добавление элемента в кучу
    public void add(E element) {
        heap.add(element); // Добавляем элемент в конец списка
        heapifyUp(heap.size() - 1); // Восстанавливаем порядок кучи, начиная с последнего элемента
    }

    // Удаление и возврат минимального элемента (корня) из кучи
    public E poll() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException(); // Если куча пуста, выбрасываем исключение
        }
        E root = heap.get(0); // Корень кучи (минимальный элемент)
        E last = heap.remove(heap.size() - 1); // Удаляем последний элемент из кучи
        if (!heap.isEmpty()) {
            heap.set(0, last); // Перемещаем последний элемент в корень
            heapifyDown(0); // Восстанавливаем порядок кучи, начиная с корня
        }
        return root; // Возвращаем минимальный элемент
    }

    // Возврат минимального элемента (корня) без удаления
    public E peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException(); // Если куча пуста, выбрасываем исключение
        }
        return heap.get(0); // Возвращаем корень кучи
    }

    // Восстановление порядка кучи вверх (перемещаем элемент вверх, если он меньше своего родителя)
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2; // Индекс родительского элемента
            // Если текущий элемент меньше родителя, меняем их местами
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) {
                break; // Если элемент на своем месте, выходим
            }
            swap(index, parent); // Меняем местами текущий элемент с родительским
            index = parent; // Переходим к родительскому элементу
        }
    }

    // Восстановление порядка кучи вниз (перемещаем элемент вниз, если он больше одного из своих детей)
    private void heapifyDown(int index) {
        int leftChild, rightChild, smallest;
        while (true) {
            leftChild = 2 * index + 1; // Индекс левого ребенка
            rightChild = 2 * index + 2; // Индекс правого ребенка
            smallest = index; // Начинаем с текущего элемента

            // Если левый ребенок меньше текущего элемента, выбираем его
            if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChild;
            }
            // Если правый ребенок меньше текущего элемента или левого ребенка, выбираем его
            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChild;
            }
            if (smallest == index) {
                break; // Если элементы на месте, выходим из цикла
            }
            swap(index, smallest); // Меняем местами текущий элемент с наименьшим из детей
            index = smallest; // Переходим к выбранному ребенку
        }
    }

    // Метод для обмена двух элементов в куче
    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp); // Меняем местами элементы на позициях i и j
    }

    // Проверка, пуста ли куча
    public boolean isEmpty() {
        return heap.isEmpty(); // Если список пуст, значит куча пуста
    }

    // Получение размера кучи
    public int size() {
        return heap.size(); // Возвращаем количество элементов в куче
    }
}
