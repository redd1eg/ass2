# Project Name: Data Structures

This is a sample project that implements various data structures in Java, such as **arrays**, **linked lists**, **queues**, **stacks**, and **min-heaps**. The project includes implementations of **MyArrayList**, **MyLinkedList**, **MyStack**, **MyQueue**, and **MyMinHeap**.

## Project Structure

- **src** - Java source code files
    - **MyArrayList.java** — Array-based list implementation
    - **MyLinkedList.java** — Linked list implementation
    - **MyStack.java** — Stack implementation using MyArrayList
    - **MyQueue.java** — Queue implementation using MyLinkedList
    - **MyMinHeap.java** — Min-heap implementation
- **README.md** — Project description
- **.gitignore** — Files to be ignored by git

## How to Use

### Example of MyArrayList usage:

```java
MyArrayList<Integer> list = new MyArrayList<>();
list.add(10);
list.add(20);
System.out.println(list.get(0)); // Prints 10
