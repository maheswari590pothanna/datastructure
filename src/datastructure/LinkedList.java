package datastructure;

public class LinkedList<T> {
    Node<T> head;

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
        } else {
            temp.next = head;
        }
        head = temp;
    }

    public void addLast(T data) {
        Node<T> temp = new Node<>(data);
        if (head == null) {
            head = temp;
            return;
        }
        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
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

    public void printLinkedlist(Node<T> head) {
        Node<T> curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public void removeFirst() {
        if (head == null) {
            head = null;
        } else if (head.next == null) {
            head = null;
        } else if (head.next != null) {
            Node<T> curr = head;
            head = head.next;
            curr.next = null;
        }
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
