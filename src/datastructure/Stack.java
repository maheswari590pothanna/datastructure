package datastructure;

import java.util.Scanner;

public class Stack<T> {
    Node<T> top;
    int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void display() {
        Node<T> curr = top;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
    public void push(T element){
        Node<T> temp=new Node<>(element);
        temp.next = top;
        top = temp;
        size++;
    }
    public T pop() {
        if (top == null) {
            throw new RuntimeException("Stack Underflow: Cannot pop from an empty stack");
        }
        T popData = top.data;
        top = top.next;
        return popData;
    }
    public T peek()  {
        if (top == null) {
            throw new RuntimeException("Stack Underflow: Cannot peek from an empty stack");
        }
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;

    }
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.display();
    }
}

