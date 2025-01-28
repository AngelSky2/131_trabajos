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

        public String getInorderNumber() {
            StringBuilder result = new StringBuilder();
            inorderToString(root, result);
            return result.toString();
        }

        private void inorderToString(Node root, StringBuilder result) {
            if (root != null) {
                inorderToString(root.left, result);
                result.append(root.data);
                inorderToString(root.right, result);
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

    // ----------------------- PROGRAMA PRINCIPAL -----------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();

        int mainOption;
        do {
            System.out.println("\n============================");
            System.out.println("   ESTRUCTURAS DE DATOS     ");
            System.out.println("============================");
            System.out.println("1. Operar con Árbol Binario");
            System.out.println("2. Salir");
            System.out.println("============================");

            System.out.print("Selecciona una opción: ");
            mainOption = scanner.nextInt();

            switch (mainOption) {
                case 1:
                    operateBinaryTree(binaryTree, scanner);
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (mainOption != 2);

        scanner.close();
    }

    // Menú para operar con Árbol Binario
    private static void operateBinaryTree(BinaryTree binaryTree, Scanner scanner) {
        int option;
        do {
            System.out.println("\n============================");
            System.out.println("      ÁRBOL BINARIO         ");
            System.out.println("============================");
            System.out.println("1. Agregar un número de celular y componer el nuevo número");
            System.out.println("2. Volver al menú principal");
            System.out.println("============================");

            System.out.print("Selecciona una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingresa un número de celular (entre 60000000 y 79999999): ");
                    long celular = scanner.nextLong();

                    if (celular >= 60000000L && celular <= 79999999L) {
                        // Descomponer el número celular en dígitos y agregar al árbol binario
                        Set<Integer> digits = new HashSet<>();
                        while (celular > 0) {
                            digits.add((int)(celular % 10));
                            celular /= 10;
                        }
                        for (int digit : digits) {
                            binaryTree.insert(digit);
                        }

                        // Realizar recorrido inorden y componer el nuevo número
                        String newNumber = binaryTree.getInorderNumber();
                        System.out.println("Número de celular descompuesto y recorrido inorden:");
                        System.out.println("Nuevo número compuesto: " + newNumber);
                    } else {
                        System.out.println("Número de celular fuera del rango permitido.");
                    }
                    break;
                case 2:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (option != 2);
    }
}
