package datastructure;

import java.util.Scanner;

public class Stack<T> {
    Node<T> top;
    int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    LinkedList<T> linkedList = new LinkedList<>();

    public void display() {
        linkedList.printLinkedlist();
    }

    public void push(T element) {
        linkedList.addFirst(element);
    }

    public T pop() {
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
}

