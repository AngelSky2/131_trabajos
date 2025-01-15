import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class clase {

    // Clase para representar una lista simple con números enteros
    static class SimpleListNode {
        int data;
        SimpleListNode next;

        SimpleListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Clase para la lista simple (nodos)
    static class SimpleLinkedList {
        private SimpleListNode head;

        public SimpleLinkedList() {
            this.head = null;
        }

        public void add(int data) {
            SimpleListNode newNode = new SimpleListNode(data);
            if (head == null) {
                head = newNode;
            } else {
                SimpleListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void display() {
            SimpleListNode current = head;
            if (current == null) {
                System.out.println("La lista está vacía.");
                return;
            }

            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("NULL");
        }
    }

    // Clase para manejar una lista de listas
    static class ListOfLists {
        private List<SimpleLinkedList> listOfLists;

        public ListOfLists() {
            listOfLists = new ArrayList<>();
        }

        // Método para agregar una nueva lista a la lista de listas
        public void addList(SimpleLinkedList newList) {
            listOfLists.add(newList);
        }

        // Método para mostrar todas las listas dentro de la lista de listas
        public void displayAllLists() {
            for (int i = 0; i < listOfLists.size(); i++) {
                System.out.print("Lista " + (i + 1) + ": ");
                listOfLists.get(i).display();
            }
        }

        // Método para agregar un elemento a una lista específica
        public void addElementToList(int listIndex, int element) {
            if (listIndex >= 0 && listIndex < listOfLists.size()) {
                listOfLists.get(listIndex).add(element);
            } else {
                System.out.println("Índice de lista no válido.");
            }
        }

        // Método para obtener el tamaño de la lista de listas
        public int size() {
            return listOfLists.size();
        }
    }

    // Método principal con menú interactivo
    public static void main(String[] args) {
        ListOfLists listOfLists = new ListOfLists();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            printMenu();
            System.out.print("Selecciona una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\n>>> Crear una nueva lista simple <<<");
                    SimpleLinkedList newList = new SimpleLinkedList();
                    listOfLists.addList(newList);
                    System.out.println("Nueva lista agregada.");
                    break;

                case 2:
                    System.out.println("\n>>> Agregar un elemento a una lista existente <<<");
                    System.out.print("Ingrese el número de la lista a la que desea agregar el elemento: ");
                    int listIndex = scanner.nextInt() - 1;
                    System.out.print("Ingrese el número a agregar a la lista: ");
                    int elementToAdd = scanner.nextInt();
                    listOfLists.addElementToList(listIndex, elementToAdd);
                    break;

                case 3:
                    System.out.println("\n>>> Mostrar todas las listas y sus elementos <<<");
                    listOfLists.displayAllLists();
                    break;

                case 4:
                    System.out.println("\n>>> Contar el número de listas en la lista de listas <<<");
                    System.out.println("Hay " + listOfLists.size() + " listas en la lista.");
                    break;

                case 5:
                    System.out.println("\n>>> Salir <<<");
                    break;
                case 6:
                    System.out.println();
                default:
                    System.out.println("\n[!] Opción no válida. Intenta de nuevo.");
            }
        } while (option != 5);

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("\n============================");
        System.out.println("        MENÚ DE OPCIONES      ");
        System.out.println("============================");
        System.out.println("1. Crear una nueva lista simple");
        System.out.println("2. Agregar un elemento a una lista existente");
        System.out.println("3. Mostrar todas las listas y sus elementos");
        System.out.println("4. Contar el número de listas");
        System.out.println("5. Salir");
        System.out.println("============================");
    }
}
