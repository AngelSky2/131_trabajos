public class GenericLinkedList {


    // Clase auxiliar para los nodos
    static class DoubleCircularListNode {
        //========================
        //========================
        // LISTA DOBLE CIRCULAR
        //========================
        //========================
        // Atributos
        int data;
        DoubleCircularListNode next;
        DoubleCircularListNode prev;

        // Constructor
        public DoubleCircularListNode(int data) {
            this.data = data;
            this.next = this;
            this.prev = this;
        }
    }

    static public class DoubleCircularLinkedList {
        // Atributos
        private DoubleCircularListNode head;

        // Constructor
        public DoubleCircularLinkedList() {
            this.head = null;
        }

        // Métodos
        public void add(int data) {
            adiFinal(data);
        }

        public void adiPrincipio(int data) {
            DoubleCircularListNode newNode = new DoubleCircularListNode(data);
            if (head == null) {
                head = newNode;
            } else {
                DoubleCircularListNode tail = head.prev;
                newNode.next = head;
                newNode.prev = tail;
                head.prev = newNode;
                tail.next = newNode;
                head = newNode;
            }
        }

        public void adiFinal(int data) {
            DoubleCircularListNode newNode = new DoubleCircularListNode(data);
            if (head == null) {
                head = newNode;
            } else {
                DoubleCircularListNode tail = head.prev;
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = head;
                head.prev = newNode;
            }
        }

        public DoubleCircularListNode eliPrincipio() {
            if (head == null) return null;

            DoubleCircularListNode removedNode = head;
            if (head.next == head) {
                head = null;
            } else {
                DoubleCircularListNode tail = head.prev;
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
            removedNode.next = null;
            removedNode.prev = null;
            return removedNode;
        }

        public DoubleCircularListNode eliFinal() {
            if (head == null) return null;

            DoubleCircularListNode tail = head.prev;
            if (tail == head) {
                head = null;
            } else {
                DoubleCircularListNode newTail = tail.prev;
                newTail.next = head;
                head.prev = newTail;
            }
            tail.next = null;
            tail.prev = null;
            return tail;
        }

        public boolean find(int data) {
            if (head == null) return false;

            DoubleCircularListNode current = head;
            do {
                if (current.data == data) return true;
                current = current.next;
            } while (current != head);

            return false;
        }

        public boolean remove(int data) {
            if (head == null) return false;

            DoubleCircularListNode current = head;
            do {
                if (current.data == data) {
                    if (current == head && current.next == head) {
                        head = null;
                    } else if (current == head) {
                        DoubleCircularListNode tail = head.prev;
                        head = head.next;
                        tail.next = head;
                        head.prev = tail;
                    } else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    return true;
                }
                current = current.next;
            } while (current != head);

            return false;
        }

        public int size() {
            if (head == null) return 0;

            int count = 0;
            DoubleCircularListNode current = head;
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

            DoubleCircularListNode current = head;
            do {
                System.out.print(current.data + " <-> ");
                current = current.next;
            } while (current != head);
            System.out.println("(Inicio)");
        }

        public void Niven() {
            DoubleCircularListNode current = head;
            do {
                int num = current.data, sum = 0;
                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }
                if (current.data % sum == 0) {
                    System.out.println("Es un número Niven " + current.data);
                }
                current = current.next;
            } while (current != head);
        }

        public void Kaprekar() {
            DoubleCircularListNode current = head;
            do {
                int cuadrado = current.data * current.data, c = 0, sum = 0, nn = cuadrado;
                while (nn > 0) {
                    c++;
                    nn /= 10;
                }
                if (c % 2 == 0) {
                    int p = (int) Math.pow(10, c / 2);
                    sum = cuadrado % p + cuadrado / p;
                    if (sum == current.data) {
                        System.out.println("Es un número Kaprekar " + current.data);
                    }
                }
                current = current.next;
            } while (current != head);
        }
    }

    // Aquí es donde colocamos el método principal
    public static void main(String[] args) {
        DoubleCircularLinkedList list = new DoubleCircularLinkedList();
        list.adiPrincipio(40);
        list.adiFinal(50);
        list.adiFinal(60);
        list.display();

        list.eliPrincipio();
        list.display();

        list.eliFinal();
        list.display();
    }
}
