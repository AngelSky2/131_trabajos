import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();
        int numeroMaximo = obtenerMaximo(numero);
        int numeroMinimo = obtenerMinimo(numero);
        System.out.println("Número máximo: " + numeroMaximo);
        System.out.println("Número mínimo: " + numeroMinimo);
    }

    public static int obtenerMaximo(int numero) {
        return reorganizarDigitos(numero, true);
    }

    public static int obtenerMinimo(int numero) {
        return reorganizarDigitos(numero, false);
    }
    public static int reorganizarDigitos(int numero, boolean descendente) {
        String numeroStr = Integer.toString(numero);
        for (int i = 0; i < numeroStr.length() - 1; i++) {
            for (int j = i + 1; j < numeroStr.length(); j++) {
                char a = numeroStr.charAt(i);
                char b = numeroStr.charAt(j);
                if ((descendente && a < b) || (!descendente && a > b)) {
                    numeroStr = swap(numeroStr, i, j);
                }
            }
        }
        return Integer.parseInt(numeroStr);
    }

    
    public static String swap(String str, int i, int j) {
    if (i == j) {
        return str;
    }
    return str.substring(0, i) + str.charAt(j) +
           str.substring(i + 1, j) + str.charAt(i) +
           str.substring(j + 1);
}
}