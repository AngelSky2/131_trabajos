import java.util.*;

public class arbolesAndgrafos {

    // ----------------------- CLASE PARA EL ÁRBOL BINARIO -----------------------
    static class BinaryTree {
        static class Node {
            int data;
            Node left, right;

            public Node(int item) {
                data = item;
                left = right = null;
            }
        }

        private Node root;

        public void insert(int data) {
            root = insertRec(root, data);
        }

        private Node insertRec(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }
            if (data < root.data)
                root.left = insertRec(root.left, data);
            else if (data > root.data)
                root.right = insertRec(root.right, data);
            return root;
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

        public void printTree() {
            System.out.println("Árbol Binario:");
            printTreeRec(root, "", true);
        }

        private void printTreeRec(Node node, String indent, boolean isLeft) {
            if (node != null) {
                System.out.println(indent + (isLeft ? "|-- " : "`-- ") + node.data);
                printTreeRec(node.left, indent + (isLeft ? "|   " : "    "), true);
                printTreeRec(node.right, indent + (isLeft ? "|   " : "    "), false);
            }
        }
    }

    // ----------------------- CLASE PARA EL GRAFO -----------------------
    static class Graph {
        private Map<Integer, List<Integer>> adjacencyList;

        public Graph() {
            adjacencyList = new HashMap<>();
        }

        public void addVertex(int vertex) {
            adjacencyList.putIfAbsent(vertex, new ArrayList<>());
        }

        public void addEdge(int source, int destination) {
            addVertex(source);
            addVertex(destination);
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        public void printGraph() {
            System.out.println("Grafo:");
            for (var entry : adjacencyList.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        public void dfs(int startVertex) {
            Set<Integer> visited = new HashSet<>();
            System.out.print("DFS desde el vértice " + startVertex + ": ");
            dfsRec(startVertex, visited);
            System.out.println();
        }

        private void dfsRec(int vertex, Set<Integer> visited) {
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.print(vertex + " ");
                for (int neighbor : adjacencyList.getOrDefault(vertex, new ArrayList<>())) {
                    dfsRec(neighbor, visited);
                }
            }
        }
    }

    // ----------------------- PROGRAMA PRINCIPAL -----------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        Graph graph = new Graph();

        int mainOption;
        do {
            System.out.println("\n============================");
            System.out.println("   ESTRUCTURAS DE DATOS     ");
            System.out.println("============================");
            System.out.println("1. Operar con Árbol Binario");
            System.out.println("2. Operar con Grafo");
            System.out.println("3. Salir");
            System.out.println("============================");

            System.out.print("Selecciona una opción: ");
            mainOption = scanner.nextInt();

            switch (mainOption) {
                case 1:
                    operateBinaryTree(binaryTree, scanner);
                    break;
                case 2:
                    operateGraph(graph, scanner);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (mainOption != 3);

        scanner.close();
    }

    // Menú para operar con Árbol Binario
    private static void operateBinaryTree(BinaryTree binaryTree, Scanner scanner) {
        int option;
        do {
            System.out.println("\n============================");
            System.out.println("      ÁRBOL BINARIO         ");
            System.out.println("============================");
            System.out.println("1. Insertar un nodo");
            System.out.println("2. Mostrar el árbol (Representación gráfica)");
            System.out.println("3. Recorrido en orden (inorden)");
            System.out.println("4. Volver al menú principal");
            System.out.println("============================");

            System.out.print("Selecciona una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingresa el valor para insertar: ");
                    int value = scanner.nextInt();
                    binaryTree.insert(value);
                    System.out.println("Valor " + value + " insertado.");
                    break;
                case 2:
                    binaryTree.printTree();
                    break;
                case 3:
                    System.out.println("Recorrido en orden (inorden): ");
                    binaryTree.inorder();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (option != 4);
    }

    // Menú para operar con Grafo
    private static void operateGraph(Graph graph, Scanner scanner) {
        int option;
        do {
            System.out.println("\n============================");
            System.out.println("           GRAFO            ");
            System.out.println("============================");
            System.out.println("1. Agregar vértice");
            System.out.println("2. Agregar arista");
            System.out.println("3. Mostrar grafo");
            System.out.println("4. Recorrido en profundidad (DFS)");
            System.out.println("5. Volver al menú principal");
            System.out.println("============================");

            System.out.print("Selecciona una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingresa el vértice a agregar: ");
                    int vertex = scanner.nextInt();
                    graph.addVertex(vertex);
                    System.out.println("Vértice " + vertex + " agregado.");
                    break;
                case 2:
                    System.out.print("Ingresa el vértice de origen: ");
                    int source = scanner.nextInt();
                    System.out.print("Ingresa el vértice de destino: ");
                    int destination = scanner.nextInt();
                    graph.addEdge(source, destination);
                    System.out.println("Arista agregada entre " + source + " y " + destination + ".");
                    break;
                case 3:
                    graph.printGraph();
                    break;
                case 4:
                    System.out.print("Ingresa el vértice inicial para DFS: ");
                    int startVertex = scanner.nextInt();
                    graph.dfs(startVertex);
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (option != 5);
    }
}