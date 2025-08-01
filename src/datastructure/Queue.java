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
    void enqueue(T element) {
        Node<T> temp = new Node<>(element);
        size++;
        if (isEmpty()) {
            this.front = temp;
            this.rear = temp;
        } else {
            rear.next = temp;
            rear = rear.next;
        }
    }
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public int size() {
        return size;
    }
    public void printQueue() {
        Node<T> curr = front;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public  T deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        } else {
            Node<T> temp = front;
            front = front.next;
            temp.next = null;
            size--;
            return temp.data;
        }
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");
        System.out.println(q.deQueue());
        q.printQueue();

    }
}

