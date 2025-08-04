package datastructure;

public class Node<T> {
    T data;
    Node<T> next;
    Node<T> left,right;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.left = this.right=null;
    }
}

