import java.util.EmptyStackException;

public class MyStack<E> {
    private MyArrayList<E> list; // Используем MyArrayList для хранения элементов стека

    // Конструктор: создаём новый пустой стек на основе MyArrayList
    public MyStack() {
        list = new MyArrayList<>();
    }

    // Добавление элемента в стек (на вершину)
    public void push(E element) {
        list.add(element); // Добавляем элемент в конец списка — это верх стека
    }

    // Удаление и возврат верхнего элемента стека
    public E pop() {
        if (list.isEmpty()) {
            throw new EmptyStackException(); // Если стек пуст, выбрасываем исключение
        }
        return list.remove(list.size() - 1); // Удаляем и возвращаем последний элемент
    }

    // Просмотр верхнего элемента стека без удаления
    public E peek() {
        if (list.isEmpty()) {
            throw new EmptyStackException(); // Если стек пуст, выбрасываем исключение
        }
        return list.get(list.size() - 1); // Возвращаем последний элемент без удаления
    }
}
