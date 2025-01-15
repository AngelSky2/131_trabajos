import java.util.Scanner;

public class Main {
    //========================
	//========================
	// LISTA DOBLE SIMPLE
	//========================
	//========================
    static class DoubleListNode {
        int data;
        DoubleListNode next;
        DoubleListNode prev;

        public DoubleListNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static class DoubleLinkedList {
        // Atributos
        private DoubleListNode head;
        private DoubleListNode tail;

        // Constructor
        public DoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        // Métodos
        public void add(int data) {
            DoubleListNode newNode = new DoubleListNode(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        public void adiPrincipio(int data) {
            DoubleListNode newNode = new DoubleListNode(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        public void adiFinal(int data) {
            add(data);
        }

        public DoubleListNode eliPrincipio() {
            if (head == null) return null;

            DoubleListNode removedNode = head;
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            removedNode.next = null;
            return removedNode;
        }

        public DoubleListNode eliFinal() {
            if (tail == null) return null;

            DoubleListNode removedNode = tail;
            if (tail.prev == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            removedNode.prev = null;
            return removedNode;
        }

        public boolean find(int data) {
            DoubleListNode current = head;
            while (current != null) {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        public boolean remove(int data) {
            if (head == null) return false;

            if (head.data == data) {
                head = head.next;
                if (head != null) head.prev = null;
                return true;
            }

            DoubleListNode current = head;
            while (current != null && current.data != data) {
                current = current.next;
            }

            if (current == null) return false;

            if (current.next != null) current.next.prev = current.prev;
            if (current.prev != null) current.prev.next = current.next;

            if (current == tail) {
                tail = current.prev;
            }

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

        public void Niven() {
            DoubleListNode current = head;
            while (current != null) {
                int num = current.data, sum = 0;
                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }
                if (current.data % sum == 0) {
                    System.out.println("Es un número Niven " + current.data);
                }
                current = current.next;
            }
        }

        public void Kaprekar() {
            DoubleListNode current = head;
            while (current != null) {
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
            }
        }
        public void sumardigitosxd(){
            DoubleListNode current = head;
            
            while (current != null) {
                DoubleLinkedList listmay = new DoubleLinkedList();
                DoubleLinkedList listmen = new DoubleLinkedList();
                int may=1,men=0;
                int a= current.data;
                while(a>0){
                    int desc= a%10;
                    if(desc>5){
                        may*=desc;
                        listmay.add(desc);
                    }
                    else{
                        men+=desc;
                        listmen.add(desc);
                    }
                    a=a/10;
                }
                listmay.display();
                System.out.println("producto de digitos mayores que 5: "+may);
                listmen.display();
                System.out.println("suma de digitos menores o iguales que 5: "+men);
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("resultado: "+(may+men));
                current = current.next;
            }
        }
    }
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombres (ingrese -1 para terminar):");

        int a;
        while (true) {
            a = sc.nextInt();
            if (a==-1) {
                break;
            } else {
                list.add(a);
            }
        }

        list.display();
        list.sumardigitosxd();

        sc.close();
    }
}
