import java.util.Scanner;
import java.util.Random;
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

	public static int generarNumeroAleatorio(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min; // Genera un número entre min y max (ambos inclusivos)
	}

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		Random random = new Random();
		//        list.add(6);
		//        list.add(28);
		//        list.add(12);
		//        list.add(15);

		System.out.println("Ejercicio 1: Llenar una lista con 20 números aleatorios entre 10 y 99.");
		list.display();

		for (int i = 0; i < 20; i++) {
			list.add(generarNumeroAleatorio(10, 99));
		}
		list.display();
		System.out.println("Ejercicio 2: Contar cuántos elementos pares e impares existe en la lista");
		int c = 0;


	}
}
