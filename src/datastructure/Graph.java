package datastructure;
class Graph {
    int vertices;
    Node[] adjList; // array of linked list nodes
    Graph(int v) {
        vertices = v;
        adjList = new Node[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = null;
        }
    }
    void addEdge(int src, int dest) {
        Node newNode = new Node(dest);
        newNode.next = adjList[src];
        adjList[src] = newNode;
        newNode = new Node(src);
        newNode.next = adjList[dest];
        adjList[dest] = newNode;
    }


    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        int[] stack = new int[vertices];
        int top = -1;

        stack[++top] = start;

        System.out.print("DFS: ");
        while (top != -1) {
            int current = stack[top--];

            if (!visited[current]) {
                System.out.print(current + " ");
                visited[current] = true;
            }

            Node temp = adjList[current];
            while (temp != null) {
                if (!visited[temp.data]) {
                    stack[++top] = temp.data;
                }
                temp = temp.next;
            }
        }
        System.out.println();
    }
    void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        int[] queue = new int[vertices];
        int front = 0, rear = 0;

        queue[rear++] = start;
        visited[start] = true;

        System.out.print("BFS: ");
        while (front < rear) {
            int current = queue[front++];
            System.out.print(current + " ");

            Node temp = adjList[current];
            while (temp != null) {
                if (!visited[temp.data]) {
                    queue[rear++] = temp.data;
                    visited[temp.data] = true;
                }
                temp = temp.next;
            }
        }
        System.out.println();
    }
    void printGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            Node temp = adjList[i];
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
        public static void main(String[] args) {
            Graph g = new Graph(7);
            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 3);
            g.addEdge(1, 4);
            g.addEdge(2, 5);
            g.addEdge(2, 6);

            g.printGraph();
            g.dfs(0);
            g.bfs(0);
        }
    }
