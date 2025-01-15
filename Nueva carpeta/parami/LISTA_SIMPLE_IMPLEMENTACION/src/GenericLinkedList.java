import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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

    // Clase interna para nodo de lista doble
    static class DoubleListNode {
        int data;
        DoubleListNode next;
        DoubleListNode prev;

        DoubleListNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Clase interna para nodo de lista doblemente circular
    static class DoubleCircularListNode {
        int data;
        DoubleCircularListNode next;
        DoubleCircularListNode prev;

        DoubleCircularListNode(int data) {
            this.data = data;
            this.next = this; // Apunta al mismo nodo, creando el ciclo
            this.prev = this; // Apunta al mismo nodo, creando el ciclo
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
        public void Niven(){
            int sum=0;
            SimpleListNode current = head;
             while (current != null) {
                int num=current.data;
                sum=0;
                while(num>0){
                    sum+=num%10;
                    num=num/10;
                }
                if (current.data%sum==0){
                    System.out.println("Es un numero niven "+current.data);
                }
                current = current.next;
            }
        }
        public void Kaprekar(){
            int cuadrado=0,c=0,sum=0;
            SimpleListNode current = head;
            while (current != null) {
                cuadrado=current.data*current.data;
                int nn=cuadrado;
                c=0;
                while(nn>0){
                    c++;
                    nn=nn/10;
                }
                if (c%2==0){
                    //int p=Integer.parseInt((Math.pow(10,c/2))+"");
                    int p=(int)(Math.pow(10, c/2));
                    sum=cuadrado%p+cuadrado/p;
                    if (sum==current.data){
                        System.out.println("Es un numero Kaprekar "+current.data);
                    }
                }
                current = current.next;
            }
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
        public void Niven(){
            int sum=0;
            CircularListNode current = head;
             do {
                int num=current.data;
                sum=0;
                while(num>0){
                    sum+=num%10;
                    num=num/10;
                }
                if (current.data%sum==0){
                    System.out.println("Es un numero niven "+current.data);
                }
                current = current.next;
             }while (current != head);
        }
        public void Kaprekar(){
            int cuadrado=0,c=0,sum=0;
            CircularListNode current = head;
            do {
                cuadrado=current.data*current.data;
                int nn=cuadrado;
                c=0;
                while(nn>0){
                    c++;
                    nn=nn/10;
                }
                if (c%2==0){
                    //int p=Integer.parseInt((Math.pow(10,c/2))+"");
                    int p=(int)(Math.pow(10, c/2));
                    sum=cuadrado%p+cuadrado/p;
                    if (sum==current.data){
                        System.out.println("Es un numero Kaprekar "+current.data);
                    }
                }
                current = current.next;
            }while (current != head);
        }
        
    }

    // Clase para lista doble
    static class DoubleLinkedList {
        private DoubleListNode head;
        private DoubleListNode tail;

        public DoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

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
        public void Niven(){
            int sum=0;
            DoubleListNode current = head;
             while (current != null) {
                int num=current.data;
                sum=0;
                while(num>0){
                    sum+=num%10;
                    num=num/10;
                }
                if (current.data%sum==0){
                    System.out.println("Es un numero niven "+current.data);
                }
                current = current.next;
            }
        }
        public void Kaprekar(){
            int cuadrado=0,c=0,sum=0;
            DoubleListNode current = head;
            while (current != null) {
                cuadrado=current.data*current.data;
                int nn=cuadrado;
                c=0;
                while(nn>0){
                    c++;
                    nn=nn/10;
                }
                if (c%2==0){
                    int p=(int)(Math.pow(10, c/2));
                    int pp=Integer.parseInt((Math.pow(10,c/2))+"");
                    sum=cuadrado%p+cuadrado/p;
                    if (sum==current.data){
                        System.out.println("Es un numero Kaprekar "+current.data);
                    }
                }
                current = current.next;
            }
        }
    }

    // Clase para lista doblemente circular
    static class DoubleCircularLinkedList {
        private DoubleCircularListNode head;

        public DoubleCircularLinkedList() {
            this.head = null;
        }

        public void add(int data) {
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
        public void Niven(){
            int sum=0;
            DoubleCircularListNode current = head;
             do {
                int num=current.data;
                sum=0;
                while(num>0){
                    sum+=num%10;
                    num=num/10;
                }
                if (current.data%sum==0){
                    System.out.println("Es un numero niven "+current.data);
                }
                current = current.next;
             }while (current != head);
        }
        public void Kaprekar(){
            int cuadrado=0,c=0,sum=0;
            DoubleCircularListNode current = head;
            do {
                cuadrado=current.data*current.data;
                int nn=cuadrado;
                c=0;
                while(nn>0){
                    c++;
                    nn=nn/10;
                }
                if (c%2==0){
                    //int p=Integer.parseInt((Math.pow(10,c/2))+"");
                    int p=(int)(Math.pow(10, c/2));
                    sum=cuadrado%p+cuadrado/p;
                    if (sum==current.data){
                        System.out.println("Es un numero Kaprekar "+current.data);
                    }
                }
                current = current.next;
            }while (current != head);
        }
    }

    // Método principal con menú interactivo
    public static void main(String[] args) {
        SimpleLinkedList simpleList = new SimpleLinkedList();
        CircularLinkedList circularList = new CircularLinkedList();
        DoubleLinkedList doubleList = new DoubleLinkedList();
        DoubleCircularLinkedList doubleCircularList = new DoubleCircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelecciona el tipo de lista:");
            System.out.println("1. Lista Simple");
            System.out.println("2. Lista Circular");
            System.out.println("3. Lista Doble");
            System.out.println("4. Lista Doblemente Circular");
            System.out.println("5. Salir");
            int listType = scanner.nextInt();

            if (listType == 5) break;

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
                        else if (listType == 2) circularList.add(dataToAdd);
                        else if (listType == 3) doubleList.add(dataToAdd);
                        else doubleCircularList.add(dataToAdd);
                        System.out.println("Dato agregado correctamente.");
                        break;
                    case 2:
                        System.out.println("\n>>> Mostrar los nodos de la lista <<<");
                        if (listType == 1) simpleList.display();
                        else if (listType == 2) circularList.display();
                        else if (listType == 3) doubleList.display();
                        else doubleCircularList.display();
                        break;
                    case 3:
                        System.out.println("\n>>> Buscar un dato <<<");
                        System.out.print("Ingresa el dato a buscar: ");
                        int dataToFind = scanner.nextInt();
                        if ((listType == 1 && simpleList.find(dataToFind)) || (listType == 2 && circularList.find(dataToFind)) || (listType == 3 && doubleList.find(dataToFind)) || (listType == 4 && doubleCircularList.find(dataToFind))) {
                            System.out.println("El dato " + dataToFind + " está en la lista.");
                        } else {
                            System.out.println("El dato " + dataToFind + " no está en la lista.");
                        }
                        break;
                    case 4:
                        System.out.println("\n>>> Eliminar un nodo <<<");
                        System.out.print("Ingresa el dato a eliminar: ");
                        int dataToRemove = scanner.nextInt();
                        if ((listType == 1 && simpleList.remove(dataToRemove)) || (listType == 2 && circularList.remove(dataToRemove)) || (listType == 3 && doubleList.remove(dataToRemove)) || (listType == 4 && doubleCircularList.remove(dataToRemove))) {
                            System.out.println("El dato " + dataToRemove + " fue eliminado.");
                        } else {
                            System.out.println("El dato " + dataToRemove + " no se encontró en la lista.");
                        }
                        break;
                    case 5:
                        System.out.println("\n>>> Contar los nodos en la lista <<<");
                        System.out.println("¿Deseas cargar los números desde un archivo? (S/N): ");
                        char cargarArchivo = scanner.next().charAt(0);  // Lee si el usuario quiere cargar el archivo

                        if (cargarArchivo == 'S' || cargarArchivo == 's') {
                            // Preguntar por el archivo a cargar
                            System.out.print("Ingresa el nombre del archivo (ejemplo: numeros.txt): ");
                            String filename = scanner.next();

                            // Cargar los datos desde el archivo dependiendo del tipo de lista
                            if (listType == 1) {
                                loadFromFile(filename, simpleList);
                            } else if (listType == 2) {
                                loadFromFile(filename, circularList);
                            } else if (listType == 3) {
                                loadFromFile(filename, doubleList);
                            } else {
                                loadFromFile(filename, doubleCircularList);
                            }
                        }
                        break;
                    case 7:
                        System.out.print("Numero Niven ");
                        if (listType == 1) {
                                simpleList.Niven();
                            } else if (listType == 2) {
                                circularList.Niven();
                            } else if (listType == 3) {
                                doubleList.Niven();
                            } else {
                                doubleCircularList.Niven();
                            }
                        break;
                    case 8:
                        System.out.print("Numero Kaprekar ");
                        if (listType == 1) {
                                simpleList.Kaprekar();
                            } else if (listType == 2) {
                                circularList.Kaprekar();
                            } else if (listType == 3) {
                                doubleList.Kaprekar();
                            } else {
                                doubleCircularList.Kaprekar();
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
        System.out.println("5. Cargar numero desde un archivo de texto");
        System.out.println("6. Cambiar tipo de lista");
        System.out.println("7. Numero Niven");
        System.out.println("8. Numero Kaprekar");
        System.out.println("============================");
    }
    // Método para cargar datos desde un archivo
public static void loadFromFile(String filename, SimpleLinkedList simpleList) {
    try {
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNext()) {
            int data = fileScanner.nextInt();
            simpleList.add(data);
        }
        fileScanner.close();
        System.out.println("Datos cargados correctamente en la lista simple.");
    } catch (FileNotFoundException e) {
        System.out.println("Archivo no encontrado. Asegúrate de que el archivo existe.");
    }
}

public static void loadFromFile(String filename, CircularLinkedList circularList) {
    try {
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNext()) {
            int data = fileScanner.nextInt();
            circularList.add(data);
        }
        fileScanner.close();
        System.out.println("Datos cargados correctamente en la lista circular.");
    } catch (FileNotFoundException e) {
        System.out.println("Archivo no encontrado. Asegúrate de que el archivo existe.");
    }
}

public static void loadFromFile(String filename, DoubleLinkedList doubleList) {
    try {
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNext()) {
            int data = fileScanner.nextInt();
            doubleList.add(data);
        }
        fileScanner.close();
        System.out.println("Datos cargados correctamente en la lista doble.");
    } catch (FileNotFoundException e) {
        System.out.println("Archivo no encontrado. Asegúrate de que el archivo existe.");
    }
}

public static void loadFromFile(String filename, DoubleCircularLinkedList doubleCircularList) {
    try {
        Scanner fileScanner = new Scanner(new File(filename));
        while (fileScanner.hasNext()) {
            int data = fileScanner.nextInt();
            doubleCircularList.add(data);
        }
        fileScanner.close();
        System.out.println("Datos cargados correctamente en la lista doble circular.");
    } catch (FileNotFoundException e) {
        System.out.println("Archivo no encontrado. Asegúrate de que el archivo existe.");
    }
}
}