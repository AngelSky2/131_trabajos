import java.util.*;

public class PracticaArbolesGrafos {

    // Clase Nodo para Árbol Binario
    static class Node {
        int data, height;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = this.right = null;
        }
    }

    // Clase Árbol Binario de Búsqueda (BST)
    static class BinarySearchTree {
        Node root;

        // Inserción en el árbol binario
        public void insert(int data) {
            root = insertRec(root, data);
        }

        private Node insertRec(Node root, int data) {
            if (root == null) {
                return new Node(data);
            }
            if (data < root.data) {
                root.left = insertRec(root.left, data);
            } else if (data > root.data) {
                root.right = insertRec(root.right, data);
            }
            return root;
        }

        // Eliminación en el árbol binario
        public void delete(int data) {
            root = deleteRec(root, data);
        }

        private Node deleteRec(Node root, int key) {
            if (root == null) return null;

            if (key < root.data) {
                root.left = deleteRec(root.left, key);
            } else if (key > root.data) {
                root.right = deleteRec(root.right, key);
            } else {
                if (root.left == null) return root.right;
                else if (root.right == null) return root.left;

                root.data = findMin(root.right);
                root.right = deleteRec(root.right, root.data);
            }
            return root;
        }

        private int findMin(Node root) {
            while (root.left != null) {
                root = root.left;
            }
            return root.data;
        }

        // Recorridos
        public void inorder() {
            inorderRec(root);
            System.out.println();
        }

        private void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.data + " ");
                inorderRec(root.right);
            }
        }

        public boolean search(int data) {
            return searchRec(root, data);
        }

        private boolean searchRec(Node root, int data) {
            if (root == null) return false;
            if (data == root.data) return true;
            return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
        }
        private void printTreeRec(Node node, String indent, boolean isLeft) {
            if (node != null) {
                System.out.println(indent + (isLeft ? "|-- " : "`-- ") + node.data);
                printTreeRec(node.left, indent + (isLeft ? "|   " : "    "), true);
                printTreeRec(node.right, indent + (isLeft ? "|   " : "    "), false);
            }
        }
        public void printTree() {
            System.out.println("Árbol Binario:");
            printTreeRec(root, "", true);
        }
    }

    // Clase Árbol AVL
    static class AVLTree {
        Node root;

        public void insert(int data) {
            root = insertRec(root, data);
        }

        private Node insertRec(Node node, int data) {
            if (node == null) return new Node(data);

            if (data < node.data) {
                node.left = insertRec(node.left, data);
            } else if (data > node.data) {
                node.right = insertRec(node.right, data);
            } else {
                return node;
            }

            node.height = 1 + Math.max(height(node.left), height(node.right));
            return balance(node);
        }

        private int height(Node node) {
            return node == null ? 0 : node.height;
        }

        private int balanceFactor(Node node) {
            return node == null ? 0 : height(node.left) - height(node.right);
        }

        private Node balance(Node node) {
            int balance = balanceFactor(node);

            if (balance > 1 && balanceFactor(node.left) >= 0) {
                return rotateRight(node);
            }
            if (balance > 1 && balanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
            if (balance < -1 && balanceFactor(node.right) <= 0) {
                return rotateLeft(node);
            }
            if (balance < -1 && balanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
            return node;
        }

        private Node rotateRight(Node y) {
            Node x = y.left;
            Node T = x.right;

            x.right = y;
            y.left = T;

            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;

            return x;
        }

        private Node rotateLeft(Node x) {
            Node y = x.right;
            Node T = y.left;

            y.left = x;
            x.right = T;

            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            return y;
        }

        public void inorder() {
            inorderRec(root);
            System.out.println();
        }

        private void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.data + " ");
                inorderRec(root.right);
            }
        }
    }

    // Clase Grafo
    static class Graph {
        Map<String, List<String>> adjList;

        public Graph() {
            adjList = new HashMap<>();
        }

        public void addEdge(String u, String v, boolean isDirected) {
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(v);

            if (!isDirected) {
                adjList.putIfAbsent(v, new ArrayList<>());
                adjList.get(v).add(u);
            }
        }

        public void printAdjList() {
            for (String vertex : adjList.keySet()) {
                System.out.println(vertex + " -> " + adjList.get(vertex));
            }
        }
    }

    public static void main(String[] args) {
        // Ejercicio 1
        System.out.println("Ejercicio 1:");
        BinarySearchTree bst1 = new BinarySearchTree();
        int[] values1 = {20, 15, 25, 10, 5, 30};
        for (int val : values1) bst1.insert(val);
        System.out.println("Inorden:");
        bst1.inorder();
        System.out.println("¿El valor 15 existe?: " + bst1.search(15));
        bst1.printTree();

        // Ejercicio 2
        System.out.println("Ejercicio 2:");
        BinarySearchTree bst2 = new BinarySearchTree();
        int[] values2 = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values2) bst2.insert(val);
        System.out.println("Inorden antes de eliminar:");
        bst2.inorder();
        bst2.delete(30);
        System.out.println("Inorden después de eliminar:");
        bst2.inorder();
        bst2.printTree();

        // Ejercicio 3
        System.out.println("\nEjercicio 3:");
        Graph graph1 = new Graph();
        graph1.addEdge("A", "B", false);
        graph1.addEdge("A", "C", false);
        graph1.addEdge("B", "D", false);
        graph1.addEdge("C", "E", false);
        graph1.printAdjList();

        // Ejercicio 4
        System.out.println("\nEjercicio 4:");
        Graph graph2 = new Graph();
        graph2.addEdge("A", "B", true);
        graph2.addEdge("B", "C", true);
        graph2.addEdge("C", "D", true);
        graph2.addEdge("D", "A", true);
        graph2.printAdjList();

        // Ejercicio Comodín
        System.out.println("\nEjercicio Comodín:");
        AVLTree avlTree = new AVLTree();
        int[] values3 = {10, 20, 30, 40, 50, 25};
        for (int val : values3) avlTree.insert(val);
        avlTree.inorder();
    }
}