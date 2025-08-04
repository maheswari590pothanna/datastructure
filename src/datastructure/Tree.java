package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<T extends Comparable<T>>  {

    public void inOrder(Node<T> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void preOrder(Node<T> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node<T> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public int heightOfTree(Node<T> root) {
        if (root == null)
            return 0;
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        return Math.max(lh, rh) + 1;
    }

    public void printKDist(Node<T> root, int k) {
        if (root != null) {
            if (k == 0) {
                System.out.print(root.data + " ");
            } else {
                printKDist(root.left, k - 1);
                printKDist(root.right, k - 1);
            }
        }
    }

    public void levelOrder(Node<T> root) {
        Queue<Node<T>> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                Node<T> curr = queue.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            System.out.println();
        }
    }

    public int sizeOfTree(Node<T> root) {
        if (root == null)
            return 0;
        return sizeOfTree(root.left) + sizeOfTree(root.right) + 1;
    }

    public T max(Node<T> root) {
        if (root == null)
            return null;

        T leftMax = max(root.left);
        T rightMax = max(root.right);
        T max = root.data;

        if (leftMax != null && leftMax.compareTo(max) > 0)
            max = leftMax;
        if (rightMax != null && rightMax.compareTo(max) > 0)
            max = rightMax;

        return max;
    }

    // Main method to test
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        Node<Integer> root = new Node<>(10);
        root.left = new Node<>(20);
        root.right = new Node<>(30);
        root.left.left = new Node<>(40);
        root.left.right = new Node<>(50);
        root.right.left = new Node<>(60);
        root.right.right = new Node<>(70);
        root.right.left.left = new Node<>(80);
        root.right.left.right = new Node<>(90);

        System.out.println("Inorder:");
        tree.inOrder(root);
        System.out.println("\nPreorder:");
        tree.preOrder(root);
        System.out.println("\nPostorder:");
        tree.postOrder(root);
        System.out.println("\nHeight of tree: " + tree.heightOfTree(root));

        System.out.println("Nodes at distance 3:");
        tree.printKDist(root, 3);
        System.out.println("\nLevel Order:");
        tree.levelOrder(root);
        System.out.println("Size of tree: " + tree.sizeOfTree(root));
        System.out.println("Maximum value in tree: " + tree.max(root));
    }
}
