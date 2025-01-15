package tarea2;

import java.util.Scanner;

public class main {
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

	//========================
	//========================
	// LISTA SIMPLE CIRCULAR
	//========================
	//========================


	// Clase interna para nodo de lista circular
	static class CircularListNode {
		int data;
		CircularListNode next;

		CircularListNode(int data) {
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

		public void adiPrincipio(int data) {
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

		public void adiFinal(int data) {
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

		public void add(int data) {  // ANADE DATOS A LA LISTA
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

		public boolean remove(int data) { // REMUEVE UN DATO DE LA LISTA
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

		public int size() { // CUENTA LOS NODOS
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

		public int countMultiples(int number) {
			int count = 0;
			CircularListNode current = head;
			do {
				if (current.data % number == 0) count++;
				current = current.next;
			} while (current != head);
			return count;
		}

		public int countAbundante() {
			int count = 0;
			CircularListNode current = head;
			do {
				int c = 1, d = 0;
				while (c <= current.data / 2) {
					if (current.data % c == 0) d += c;
					c++;
				}
				if (d > current.data) count++;
				current = current.next;
			} while (current != head);
			return count;
		}

		public int countDefectivo() {
			int count = 0;
			CircularListNode current = head;
			do {
				int c = 1, d = 0;
				while (c <= current.data / 2) {
					if (current.data % c == 0) d += c;
					c++;
				}
				if (d < current.data) count++;
				current = current.next;
			} while (current != head);
			return count;
		}
    }    
    public static void main(String[] args) {
        System.out.println("====DATOS POR DEFECTO=======");
        CircularLinkedList simplecircular = new CircularLinkedList();
        simplecircular.adiPrincipio(1);
        simplecircular.adiFinal(9);
        simplecircular.adiFinal(7);
        simplecircular.adiFinal(9);
        simplecircular.adiFinal(1);
        simplecircular.display();
        DoubleCircularLinkedList doblecircular = new DoubleCircularLinkedList();
        doblecircular.adiPrincipio(10);
        doblecircular.adiFinal(16);
        doblecircular.adiFinal(7);
        doblecircular.adiFinal(9);
        doblecircular.adiFinal(1);
        doblecircular.display();
        int option;
        Scanner scanner = new Scanner(System.in);

        do {
            // Mostrar el menú principal
            printMenu();

            // Leer la opción del usuario
            System.out.print("\nElige una opción (1-5): ");
            option = scanner.nextInt();

            // Ejecutar la opción seleccionada
            switch (option) {
                case 1:
                    System.out.println("EJERCICIO 1");
                    unirListasOrdenas(simplecircular, doblecircular);
                    System.out.println("=============================================="); 
                    break;
                case 2:
                    System.out.println("EJERCICIO 2");
                    eliminaNodosPares(doblecircular);
                    System.out.println("==============================================");
                    break;
                case 3:
                    System.out.println("EJERCICIO 3");
                    simplecircular.display();
                    verificarPalindromo(simplecircular);
                    System.out.println("==============================================");
                    break;
                case 4:
                    System.out.println("EJERCICIO 4");
                    System.out.println("LISTA ORIGINAL");
                    simplecircular.display();
                    dividirLista(simplecircular);
                    System.out.println("==============================================");
                    break;
                case 5:
                    System.out.println("EJERCICIO 5");
                    System.out.println("LISTA ORIGINAL");
                    doblecircular.display();
                    rotarListaCircualr(doblecircular,scanner);
                    System.out.println("==============================================");
                    break;    
                case 6 :
                    System.out.println("\n>>> SALIR: Gracias por usar este programa. ¡Adiós! <<<");
                    break;
                default:
                    System.out.println("\n[!] Opción inválida. Por favor, elige nuevamente.");
            }
        } while (option != 6);

        scanner.close();
    }

    // Método para imprimir el menú principal
    public static void printMenu() {
        System.out.println("\n============================");
        System.out.println("   MENÚ TEMÁTICO PRINCIPAL   ");
        System.out.println("============================");
        System.out.println("1. Resolver: Encontrar números únicos");
        System.out.println("2. Resolver: Calcular intersección de arreglos");
        System.out.println("3. Explorar: Ejercicios avanzados");
        System.out.println("4. Información: Sobre este programa");
        System.out.println("5. Salir del programa");
        System.out.println("============================\n");
    
        
    }
    private static void rotarListaCircualr( DoubleCircularLinkedList doblecircular,Scanner scanner) {
        System.out.println("Total de rotaciones: ");
        
        int numero = scanner.nextInt();
        CircularLinkedList simplecircular = new CircularLinkedList();
        DoubleCircularListNode R = doblecircular.head;
        for (int i = 0; i < numero; i++) {
            R = R.next;
        }
        System.out.println(R.data);
        DoubleCircularListNode rota = R;
        do {
            simplecircular.add(R.data);
            R = R.next;
        }while(R != rota);
        simplecircular.display();
        
    }

    private static void dividirLista(CircularLinkedList simplecircular) {
        CircularListNode R = simplecircular.head;
        DoubleCircularLinkedList aux1 = new DoubleCircularLinkedList();
        DoubleCircularLinkedList aux2 = new DoubleCircularLinkedList();
        int nodos = simplecircular.size();
        for (int i = 0; i < nodos; i++) {
            if(nodos/2 > i) {
                aux1.add(R.data);
            }else {
                aux2.add(R.data);
            }
            R =R.next;
        }
        System.out.println("DESPUES DE DIVIDIR");
        aux1.display();
        aux2.display();


    }

    private static void verificarPalindromo(CircularLinkedList simplecircular) {
        int nodos = simplecircular.size();
        CircularListNode R = simplecircular.head;
        int[] vector = new int[nodos];
        int c = 0;
        do {
            vector[c] = R.data;
            R = R.next;
            c++;
        }while(R != simplecircular.head);
        int tamanovector = vector.length;
        int atras = tamanovector;
        int sw = 0;
        atras = atras - 1;
        for (int i = 0; i < tamanovector/2; i++) {
            if(vector[i] == vector[atras]){
                sw = 0;
            }else {
                sw = 1;
            }
            atras = atras - 1;
        }
        if(sw == 0) System.out.println("PALINDORMO");
        else System.out.println("NO PALINDROMO");
    }

    private static void eliminaNodosPares( DoubleCircularLinkedList doblecircular) {
        DoubleCircularListNode R = doblecircular.head;
        DoubleCircularLinkedList aux = new DoubleCircularLinkedList();
        do{
            if(R.data % 2 == 0) {

            }else {
                aux.add(R.data);
            }
            R = R.next;
        }while(R.next != doblecircular.head);
        aux.display();

    }

    private static void ordenarBurbuja(DoubleCircularLinkedList lista) {
        if (lista.head == null) return;
        boolean swapped;
        do {
            swapped = false;
            DoubleCircularListNode current = lista.head;
            DoubleCircularListNode nextNode = current.next;
            do {
                if (current.data > nextNode.data) {

                    int temp = current.data;
                    current.data = nextNode.data;
                    nextNode.data = temp;
                    swapped = true;
                }
                current = current.next;
                nextNode = current.next;
            } while (current != lista.head && nextNode != lista.head);

        } while (swapped); // REPITE MIESTRAS HAY CAMBUOSS
    }

    private static void unirListasOrdenas(CircularLinkedList simplecircular, DoubleCircularLinkedList doblecircular) {
        CircularListNode R = simplecircular.head;
        do {
            doblecircular.add(R.data);
            R = R.next;
        } while (R != simplecircular.head);

        System.out.println("Lista antes de ordenar:");
        doblecircular.display();
        ordenarBurbuja(doblecircular);
        System.out.println("Lista después de ordenar:");
        doblecircular.display();
    }
}
   

    
