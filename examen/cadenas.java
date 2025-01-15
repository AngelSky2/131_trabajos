import java.util.Scanner;

public class Main {
    //========================
    //========================
    // LISTA SIMPLE CIRCULAR
    //========================
    //========================

    // Clase interna para nodo de lista circular
    static class CircularListNode {
        String data;
        CircularListNode next;

        CircularListNode(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Clase para lista circular
    static class CircularLinkedList {
        private CircularListNode head;

        public CircularLinkedList() {
            this.head = null;
        }

        public void adiPrincipio(String data) {
            CircularListNode newNode = new CircularListNode(data);
            if (head == null) {
                head = newNode;
                head.next = head;  // El único nodo apunta a sí mismo
            } else {
                CircularListNode current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = newNode;
                newNode.next = head;
                head = newNode;  // Actualizamos la cabeza a la nueva posición
            }
        }

        public void adiFinal(String data) {
            CircularListNode newNode = new CircularListNode(data);
            if (head == null) {
                head = newNode;
                head.next = head;  // El único nodo apunta a sí mismo
            } else {
                CircularListNode current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = newNode;
                newNode.next = head;
            }
        }

        public CircularListNode eliPrincipio() {
            if (head == null) return null;

            CircularListNode removedNode = head;
            if (head.next == head) {  // Solo hay un nodo
                head = null;
            } else {
                CircularListNode current = head;
                while (current.next != head) {
                    current = current.next;
                }
                head = head.next;  // Movemos la cabeza al siguiente nodo
                current.next = head;  // El último nodo apunta al nuevo primer nodo
            }
            removedNode.next = null;  // Desvinculamos el nodo eliminado
            return removedNode;
        }

        public CircularListNode eliFinal() {
            if (head == null) return null;

            CircularListNode current = head;
            if (head.next == head) {  // Solo hay un nodo
                CircularListNode removedNode = head;
                head = null;
                return removedNode;
            }

            // Encontramos el penúltimo nodo
            while (current.next.next != head) {
                current = current.next;
            }

            CircularListNode removedNode = current.next;
            current.next = head;  // El penúltimo nodo apunta a la cabeza
            removedNode.next = null;  // Desvinculamos el nodo eliminado
            return removedNode;
        }

        public void add(String data) {  // Añade datos a la lista
            CircularListNode newNode = new CircularListNode(data);
            if (head == null) {
                head = newNode;
                head.next = head;
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

        public boolean remove(String data) {  // Remueve un dato de la lista
            if (head == null) return false;

            CircularListNode current = head;
            CircularListNode prev = null;

            do {
                if (current.data.equals(data)) {
                    if (current == head && current.next == head) {
                        head = null;
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

        public int size() {  // Cuenta los nodos
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

        public void listarnombre(String a, String b) {
            int count = 0;
            CircularListNode current = head;
            do {
                String nombre = current.data;
                if (nombre.contains(a) && !nombre.contains(b)) {
                    count++;
                }
                current = current.next;
            } while (current != head);
            System.out.println("Nombres con " + a + " y sin " + b + ": " + count);
        }
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombres (ingrese -1 para terminar):");

        String a;
        while (true) {
            a = sc.nextLine();
            if (a.equals("-1")) {
                break;
            } else {
                list.add(a);
            }
        }

        list.display();
        list.listarnombre("a", "o");

        sc.close();
    }
}
