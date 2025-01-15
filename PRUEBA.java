
import java.util.Scanner;

public class PRUEBA {

    // Clase interna para nodo de lista simple
    static class SimpleListNode {
        String data;
        SimpleListNode next;

        SimpleListNode(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Clase interna para nodo de lista circular
    static class CircularListNode {
        String data;
        CircularListNode next;

        CircularListNode(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Clase interna para nodo de lista doble
    static class DoubleListNode {
        String data;
        DoubleListNode next;
        DoubleListNode prev;

        DoubleListNode(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Clase para lista simple
    static class SimpleLinkedList {
        private SimpleListNode head;

        public SimpleLinkedList() {
            this.head = null;
        }

        public void add(String data) {
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

        public boolean find(String data) {
            SimpleListNode current = head;
            while (current != null) {
                if (current.data.equals(data)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        public boolean remove(String data) {
            if (head == null) return false;

            if (head.data.equals(data)) {
                head = head.next;
                return true;
            }

            SimpleListNode current = head;
            while (current.next != null && !current.next.data.equals(data)) {
                current = current.next;
            }

            if (current.next == null) return false;

            current.next = current.next.next;
            return true;
        }

        public int size() {
            int count = 0;
            SimpleListNode current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
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

    // Clase para lista circular
    static class CircularLinkedList {
        private CircularListNode head;

        public CircularLinkedList() {
            this.head = null;
        }

        public void add(String data) {
            CircularListNode newNode = new CircularListNode(data);
            if (head == null) {
                head = newNode;
                head.next = head;  // La lista circular apunta a sí misma
            } else {
                CircularListNode current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = newNode;
                newNode.next = head;
            }
        }

        public boolean find(String data) {
            if (head == null) return false;

            CircularListNode current = head;
            do {
                if (current.data.equals(data)) return true;
                current = current.next;
            } while (current != head);

            return false;
        }

        public boolean remove(String data) {
            if (head == null) return false;

            CircularListNode current = head;
            CircularListNode prev = null;

            do {
                if (current.data.equals(data)) {
                    if (current == head && current.next == head) {
                        head = null;  // Sólo un nodo en la lista
                    } else if (current == head) {
                        CircularListNode last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = current.next;
                    }
                    return true;
                }
                prev = current;
                current = current.next;
            } while (current != head);

            return false;
        }

        public int size() {
            if (head == null) return 0;

            int count = 0;
            CircularListNode current = head;
            do {
                count++;
                current = current.next;
            } while (current != head);

            return count;
        }

        public void display() {
            if (head == null) {
                System.out.println("La lista está vacía.");
                return;
            }

            CircularListNode current = head;
            do {
                System.out.print(current.data + " -> ");
                current = current.next;
            } while (current != head);
            System.out.println("(Inicio)");
        }
    }

    // Clase para lista doble
    static class DoubleLinkedList {
        private DoubleListNode head;

        public DoubleLinkedList() {
            this.head = null;
        }

        public void add(String data) {
            DoubleListNode newNode = new DoubleListNode(data);
            if (head == null) {
                head = newNode;
            } else {
                DoubleListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
                newNode.prev = current;
            }
        }

        public boolean find(String data) {
            DoubleListNode current = head;
            while (current != null) {
                if (current.data.equals(data)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        public boolean remove(String data) {
            if (head == null) return false;

            if (head.data.equals(data)) {
                head = head.next;
                if (head != null) head.prev = null;
                return true;
            }

            DoubleListNode current = head;
            while (current != null && !current.data.equals(data)) {
                current = current.next;
            }

            if (current == null) return false;

            if (current.next != null) current.next.prev = current.prev;
            if (current.prev != null) current.prev.next = current.next;

            return true;
        }

        public int size() {
            int count = 0;
            DoubleListNode current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }

        public void display() {
            DoubleListNode current = head;
            if (current == null) {
                System.out.println("La lista está vacía.");
                return;
            }

            while (current != null) {
                System.out.print(current.data + " <-> ");
                current = current.next;
            }
            System.out.println("NULL");
        }
    }

    // Método principal con menú interactivo
    public static void main(String[] args) {
        SimpleLinkedList simpleList = new SimpleLinkedList();
        CircularLinkedList circularList = new CircularLinkedList();
        DoubleLinkedList doubleList = new DoubleLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelecciona el tipo de lista:");
            System.out.println("1. Lista Simple");
            System.out.println("2. Lista Circular");
            System.out.println("3. Lista Doble");
            System.out.println("4. Salir");
            int listType = scanner.nextInt();

            if (listType == 4) break;

            while (true) {
                printMenu();
                System.out.print("Selecciona una opción: ");
                int option = scanner.nextInt();

                if (option == 6) break;

                switch (option) {
                    case 1:
                        System.out.println("\n>>> Agregar un nodo <<<");
                        System.out.print("Ingresa un nombre para agregar: ");
                        String dataToAdd = scanner.next();
                        if (listType == 1) simpleList.add(dataToAdd);
                        else if (listType == 2) circularList.add(dataToAdd);
                        else doubleList.add(dataToAdd);
                        System.out.println("Dato agregado correctamente.");
                        break;
                    case 2:
                        System.out.println("\n>>> Mostrar los nodos de la lista <<<");
                        if (listType == 1) simpleList.display();
                        else if (listType == 2) circularList.display();
                        else doubleList.display();
                        break;
                    case 3:
                        System.out.println("\n>>> Buscar un nombre <<<");
                        System.out.print("Ingresa el nombre a buscar: ");
                        String dataToFind = scanner.next();
                        if ((listType == 1 && simpleList.find(dataToFind)) || (listType == 2 && circularList.find(dataToFind)) || (listType == 3 && doubleList.find(dataToFind))) {
                            System.out.println("El nombre " + dataToFind + " está en la lista.");
                        } else {
                            System.out.println("El nombre " + dataToFind + " no está en la lista.");
                        }
                        break;
                    case 4:
                        System.out.println("\n>>> Eliminar un nodo <<<");
                        System.out.print("Ingresa el nombre a eliminar: ");
                        String dataToRemove = scanner.next();
                        if ((listType == 1 && simpleList.remove(dataToRemove)) || (listType == 2 && circularList.remove(dataToRemove)) || (listType == 3 && doubleList.remove(dataToRemove))) {
                            System.out.println("El nombre " + dataToRemove + " fue eliminado.");
                        } else {
                            System.out.println("El nombre " + dataToRemove + " no se encontró en la lista.");
                        }
                        break;
                    case 5:
                        System.out.println("\n>>> Contar los nodos en la lista <<<");
                        if (listType == 1) {
                            System.out.println("La lista contiene " + simpleList.size() + " nodos.");
                        } else if (listType == 2) {
                            System.out.println("La lista contiene " + circularList.size() + " nodos.");
                        } else {
                            System.out.println("La lista contiene " + doubleList.size() + " nodos.");
                        }
                        break;
                    default:
                        System.out.println("\n[!] Opción no válida. Intenta de nuevo.");
                }
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("\n============================");
        System.out.println("        MENÚ DE OPCIONES      ");
        System.out.println("============================");
        System.out.println("1. Agregar un nodo a la lista");
        System.out.println("2. Mostrar todos los nodos de la lista");
        System.out.println("3. Buscar un dato en la lista");
        System.out.println("4. Eliminar un nodo de la lista");
        System.out.println("5. Contar los nodos en la lista");
        System.out.println("6. Cambiar tipo de lista");
        System.out.println("============================");
    }
}