import java.util.NoSuchElementException;

public class MyQueue<E> {
    private MyLinkedList<E> list; // Ссылка на MyLinkedList для хранения элементов очереди

    // Конструктор, инициализирующий пустую очередь
    public MyQueue() {
        list = new MyLinkedList<>(); // Создаем пустой MyLinkedList для хранения элементов очереди
    }

    // Добавление элемента в конец очереди
    public void enqueue(E element) {
        list.add(element); // Добавляем элемент в конец списка, так как это очередь
    }

    // Удаление элемента из начала очереди
    public E dequeue() {
        if (list.isEmpty()) {
            throw new NoSuchElementException(); // Если очередь пуста, выбрасываем исключение
        }
        return list.remove(0); // Удаляем и возвращаем первый элемент из очереди
    }

    // Возврат первого элемента очереди без его удаления
    public E peek() {
        if (list.isEmpty()) {
            throw new NoSuchElementException(); // Если очередь пуста, выбрасываем исключение
        }
        return list.get(0); // Возвращаем первый элемент без удаления
    }

    // Проверка, пуста ли очередь
    public boolean isEmpty() {
        return list.isEmpty(); // Если список пуст, значит очередь пуста
    }

    // Получение размера очереди
    public int size() {
        return list.size(); // Возвращаем количество элементов в очереди
    }
}
