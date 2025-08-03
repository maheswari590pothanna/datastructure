package searchingsorting;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    static void inOrder(Node root){
        if(root!=null) {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    static void postOrder(Node root){
        if(root!=null){
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.data+" ");
        }
        System.out.println();
    }
    // height of a binary tree
    static int heightOfTree(Node root){
        if(root==null)
            return 0;
        else{
            int lh=heightOfTree(root.left);
            int rh=heightOfTree(root.right);
            return Math.max(lh,rh)+1;
        }
    }
    // print the nodes at distance k
    static void printKDist(Node root,int k){
        if(root!=null){
            if(k==0){
                System.out.print(root.data+" ");
            }
            else{
                printKDist(root.left,k-1);
                printKDist(root.right,k-1);
            }
        }
    }
    // levelorder traversal
    static void levelOrder(Node root){
        Queue<Node> list = new LinkedList<Node>();
        if(root!=null){
            list.add(root);
            while(list.size()>0){
                 Node curr=list.poll();
                System.out.println(curr.data+" ");
                if(curr.left!=null)
                    list.add(curr.left);
                if(curr.right!=null)
                    list.add(curr.right);
            }
        }
    }
    static int sizeOfTree(Node root){
        if(root==null)
            return 0;
        else{
            return sizeOfTree(root.left)+sizeOfTree(root.right)+1;
        }
    }
    //maximum node in a given tree
    static int max(Node root){
        if(root==null)
            return Integer.MIN_VALUE;
        else{
            int leftmax=max(root.left);
            int rightmax=max(root.right);
            return Math.max(Math.max(leftmax,rightmax),root.data);
        }
    }

    public static void main(String[] args) {
        Node root=null;
        root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right.left=new Node(60);
        root.right.right=new Node(70);

        root.right.left.left=new Node(80);
        root.right.left.right=new Node(90);

        inOrder(root);
        System.out.println();
        System.out.println("preorder");
        preOrder(root);
        System.out.println();
        System.out.println("postorder");
        postOrder(root);
        System.out.println("height of the subtree");
        System.out.println(heightOfTree(root));
        printKDist(root,3);
        levelOrder(root);
        System.out.println("size of the subtree");
        System.out.println(sizeOfTree(root));
        System.out.println();
        System.out.println("maximum number of subtrees ");
        System.out.println(max(root));


    }
}
