package datastructure;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T e) {
        Node<T> temp = new Node<>(e);
        if (head == null) {
            head = temp;
        } else {
            Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = temp;
        }
    }

    public void addAll(T[] ele) {
        for (T e : ele) {
            add(e);
        }
    }

    public void addFirst(T e) {
        Node<T> temp = new Node<>(e);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T peekFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addAtIndex(int index, T data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node<T> current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void printLinkedlist() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public T removeFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        T val = head.data;
        head = head.next;
        if (head == null)
            tail = null;
        size--;
        return val;
    }

    public void removeLast() {
        if (head == null) {
            head = null;
        } else if (head.next == null) {
            head = null;
        } else if (head.next != null) {
            Node curr = head;
            while (curr.next.next != null) {
                curr = curr.next;
                curr.next = null;
            }
        }
    }
}
