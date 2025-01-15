import java.util.Scanner;
public class main {
    
    static class SimpleListNode {
        int data;
        SimpleListNode next;

        SimpleListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
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

        public boolean find(int data) {
            SimpleListNode current = head;
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
                return true;
            }

            SimpleListNode current = head;
            while (current.next != null && current.next.data != data) {
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

        public int numeroAutomorfico() {
            SimpleListNode current = head;
            int cont = 0;
            
            while (current != null) {
                int a = current.data;
                int cuadrado = a * a;
                
                if (esAutomorfico(a, cuadrado)) {
                    System.out.println("El numero " + a + " es automorfico");
                    cont++;
                }
                
                current = current.next;
            }
            return cont;
        }

        public boolean esAutomorfico(int numero, int cuadrado) {
            String numeroStr = String.valueOf(numero);
            String cuadradoStr = String.valueOf(cuadrado);
            
            return cuadradoStr.endsWith(numeroStr);
        }

            
    

    }
    public static void main(String[] args) {
        SimpleLinkedList simpleList = new SimpleLinkedList();
        Scanner sc= new Scanner(System.in);
        System.out.println("ingrese los valores de la lista que sea mayorigual a 0");
        System.out.println("ingrese -1 para terminar la lista");
        int a =1;
        while(a!=-1){
            a=sc.nextInt();
            if(a!=-1){
                
                simpleList.add(a);
            }
            
            
        }
        simpleList.display();
        System.out.println("le numeroAutomorfico son: "+simpleList.numeroAutomorfico());
        
        
        sc.close();
    }
    
}
