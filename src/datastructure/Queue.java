package datastructure;

import java.util.NoSuchElementException;

public class Queue<T> {
    Node<T> front;
    Node<T> rear;
    int size;

    Queue() {
        this.front = null;
        this.rear = null;
        size = 0;
    }

    public LinkedList<T> linkedList = new LinkedList<>();

    void enqueue(T element) {
        linkedList.addLast(element);
    }

    public T deQueue() {
        return linkedList.removeFirst();
    }

    public T peek() {
        return linkedList.peekFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int size() {
        return linkedList.size();
    }

    public void printQueue() {
        linkedList.printLinkedlist();
    }
}

