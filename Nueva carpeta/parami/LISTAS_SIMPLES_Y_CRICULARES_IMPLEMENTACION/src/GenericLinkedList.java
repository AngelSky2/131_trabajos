import java.util.Scanner;
import java.util.Random;

public class GenericLinkedList {

    // Clase interna para nodo de lista simple
    static class SimpleListNode {
        int data;
        SimpleListNode next;

        SimpleListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Clase interna para nodo de lista circular
    static class CircularListNode {
        int data;
        CircularListNode next;

        CircularListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Clase para lista simple
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
        public int countMultiples(int number){
            int count=0;
            SimpleListNode current=head;
            while(current!=null){
                if(current.data%number==0)count++;
                current=current.next;
            }
            return count;
        }
        public int countAbundante(){
            int count=0;
            SimpleListNode current=head;
            while(current!=null){
                int c=1,d=0;
                while(c<=current.data/2){
                    if (current.data%c==0)d=d+c;
                    c++;
                }
                if (d>current.data)count++;
                current=current.next;
            }
            return count;
        }
        public int countDefectivo(){
            int count=0;
            SimpleListNode current=head;
            while(current!=null){
                int c=1,d=0;
                while(c<=current.data/2){
                    if (current.data%c==0)d=d+c;
                    c++;
                }
                if (d<current.data)count++;
                current=current.next;
            }
            return count;
        }
    }

    // Clase para lista circular
    static class CircularLinkedList {
        private CircularListNode head;

        public CircularLinkedList() {
            this.head = null;
        }

        public void add(int data) {
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

        public boolean find(int data) {
            if (head == null) return false;

            CircularListNode current = head;
            do {
                if (current.data == data) return true;
                current = current.next;
            } while (current != head);

            return false;
        }

        public boolean remove(int data) {
            if (head == null) return false;

            CircularListNode current = head;
            CircularListNode prev = null;

            do {
                if (current.data == data) {
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
        public int countMultiples(int number){
            int count=0;
            CircularListNode current=head;
            do{
                if (current.data%number==0)count++;
                current=current.next;
            }while(current!=head);
            return count;
        }
        public int countAbundante(){
            int count=0;
            CircularListNode current=head;
            do{
                int c=1,d=0;
                while(c<=current.data/2){
                    if (current.data%c==0)d=d+c;
                    c++;
                }
                if (d>current.data)count++;
                current=current.next;
            }while(current!=head);
            return count;
        }
        public int countDefectivo(){
            int count=0;
            CircularListNode current=head;
            do{
                int c=1,d=0;
                while(c<=current.data/2){
                    if (current.data%c==0)d=d+c;
                    c++;
                }
                if (d<current.data)count++;
                current=current.next;
            }while(current!=head);
            return count;
        }
    }

    // Método principal con menú interactivo
    public static void main(String[] args) {
        SimpleLinkedList simpleList = new SimpleLinkedList();
        CircularLinkedList circularList = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);
        Random random=new Random();
        while (true) {
            System.out.println("\nSelecciona el tipo de lista:");
            System.out.println("1. Lista Simple");
            System.out.println("2. Lista Circular");
            System.out.println("3. Salir");
            int listType = scanner.nextInt();

            if (listType == 3) break;

            while (true) {
                printMenu();
                System.out.print("Selecciona una opción: ");
                int option = scanner.nextInt();


                if (option == 6) break;

                switch (option) {
                    case 1:
                        System.out.println("\n>>> Agregar un nodo <<<");
                        System.out.print("Ingresa un dato para agregar: ");
                        int dataToAdd = scanner.nextInt();
                        if (listType == 1) simpleList.add(dataToAdd);
                        else circularList.add(dataToAdd);
                        System.out.println("Dato agregado correctamente.");
                        break;
                    case 2:
                        System.out.println("\n>>> Mostrar los nodos de la lista <<<");
                        if (listType == 1) simpleList.display();
                        else circularList.display();
                        break;
                    case 3:
                        System.out.println("\n>>> Buscar un dato <<<");
                        System.out.print("Ingresa el dato a buscar: ");
                        int dataToFind = scanner.nextInt();
                        if ((listType == 1 && simpleList.find(dataToFind)) || (listType == 2 && circularList.find(dataToFind))) {
                            System.out.println("El dato " + dataToFind + " está en la lista.");
                        } else {
                            System.out.println("El dato " + dataToFind + " no está en la lista.");
                        }
                        break;
                    case 4:
                        System.out.println("\n>>> Eliminar un nodo <<<");
                        System.out.print("Ingresa el dato a eliminar: ");
                        int dataToRemove = scanner.nextInt();
                        if ((listType == 1 && simpleList.remove(dataToRemove)) || (listType == 2 && circularList.remove(dataToRemove))) {
                            System.out.println("El dato " + dataToRemove + " fue eliminado.");
                        } else {
                            System.out.println("El dato " + dataToRemove + " no se encontró en la lista.");
                        }
                        break;
                    case 5:
                        System.out.println("\n>>> Contar los nodos en la lista <<<");
                        if (listType == 1) {
                            System.out.println("La lista contiene " + simpleList.size() + " nodos.");
                        } else {
                            System.out.println("La lista contiene " + circularList.size() + " nodos.");
                        }
                        break;
                    case 7:
                        System.out.println("\n>>> Llenar la lista con 15 números aleatorios <<<");
                        for (int i = 0; i < 5; i++) {
                            int randomNumber = random.nextInt(15); // Genera un número aleatorio entre 0 y 99
                            if (listType == 1) simpleList.add(randomNumber);
                            else circularList.add(randomNumber);
                        }

                        break;
                    case 8:
                        System.out.println("\n>>> Contar múltiplos de un número <<<");
                        System.out.print("Ingresa el número para buscar múltiplos: ");
                        int number = scanner.nextInt();
                        int multiplesCount;
                        if (listType == 1) {
                            multiplesCount = simpleList.countMultiples(number);
                        } else {
                            multiplesCount = circularList.countMultiples(number);
                        }
                        System.out.println("Cantidad de múltiplos de " + number + ": " + multiplesCount);
                        break;
                    case 9:
                        System.out.println("\n>>> Cantidad de numeros abundantes y defectivos <<<");
                        int abundante;
                        int defectivo;
                        if (listType == 1) {
                            abundante = simpleList.countAbundante();
                            defectivo=simpleList.countDefectivo();
                        } else {
                            abundante = circularList.countAbundante();
                            defectivo=circularList.countDefectivo();
                        }
                        System.out.println("Cantidad de abundantes de " + abundante + "y defectivos " + defectivo);
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
        System.out.println("7. Generar numeros aletorios");
        System.out.println("8. Multiples por teclado");
        System.out.println("9. Numeros abundantes y defectivos");
        System.out.println("============================");
    }
}