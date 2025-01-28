import java.io.*;
import java.util.*;

public class tarea3 {

    public static void main(String[] args) throws IOException {
        System.out.println("=== Ejercicio 1: Números Primos Gemelos ===");
        exercise1("numeros.txt");

        System.out.println("\n=== Ejercicio 2: Secuencia de Caracteres y Frecuencia ===");
        exercise2("nombres.txt", "Ana", 'a');

        System.out.println("\n=== Ejercicio 3: Números de Harshad ===");
        exercise3("numeros.txt");

        System.out.println("\n=== Ejercicio 4: Análisis de Cadenas ===");
        exercise4("cadenas.txt", "Hola");

        System.out.println("\n=== Ejercicio Comodín: Palabras Palíndromas ===");
        exerciseWildcard("palabras.txt");
    }

    // Ejercicio 1: Primos Gemelos
    public static void exercise1(String fileName) throws IOException {
        Stack<Integer> stack = loadNumbersToStack(fileName);
        int twinPrimeCount = 0;

        List<Integer> primes = new ArrayList<>(stack);
        Collections.reverse(primes); // Procesar de abajo hacia arriba

        for (int i = 0; i < primes.size() - 1; i++) {
            if (isPrime(primes.get(i)) && isPrime(primes.get(i + 1)) &&
                Math.abs(primes.get(i) - primes.get(i + 1)) == 2) {
                twinPrimeCount++;
            }
        }

        System.out.println("Cantidad de pares de números primos gemelos en la pila: " + twinPrimeCount);
    }

    // Ejercicio 2: Secuencia de Caracteres y Frecuencia
    public static void exercise2(String fileName, String sequence, char character) throws IOException {
        Stack<String> stack = loadStringsToStack(fileName);
        int sequenceCount = 0;
        int charFrequency = 0;

        for (String name : stack) {
            if (name.contains(sequence)) sequenceCount++;
            for (char c : name.toCharArray()) {
                if (c == character) charFrequency++;
            }
        }

        System.out.println("La secuencia \"" + sequence + "\" aparece " + sequenceCount + " veces en la pila.");
        System.out.println("La frecuencia del carácter '" + character + "' en los nombres es: " + charFrequency);
    }

    // Ejercicio 3: Números de Harshad
    public static void exercise3(String fileName) throws IOException {
        Queue<Integer> queue = loadNumbersToQueue(fileName);
        int harshadCount = 0;

        for (int number : queue) {
            if (isHarshad(number)) harshadCount++;
        }

        System.out.println("Cantidad de números de Harshad en la cola: " + harshadCount);
    }

    // Ejercicio 4: Análisis de Cadenas
    public static void exercise4(String fileName, String wordToSearch) throws IOException {
        Queue<String> queue = loadStringsToQueue(fileName);
        
        int countWord = 0;
        int totalLength = 0;
        String longestWord = "";
        String shortestWord = null;
    
        // Procesar las cadenas
        for (String sentence : queue) {
            // Limpiar signos de puntuación y dividir en palabras
            String[] words = sentence.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]", "").split("\\s+");
    
            for (String word : words) {
                // Contar la palabra específica
                if (word.equalsIgnoreCase(wordToSearch)) {
                    countWord++;
                }
    
                // Longitud total y determinar palabras más larga/corta
                totalLength += word.length();
                if (shortestWord == null || word.length() < shortestWord.length()) {
                    shortestWord = word;
                }
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
        }
    
        // Calcular la longitud media
        double averageLength = totalLength / (double) queue.size();
    
        // Mostrar resultados
        System.out.println("=== Ejercicio 4: Análisis de Cadenas ===");
        System.out.println("La palabra \"" + wordToSearch + "\" aparece " + countWord + " veces en las cadenas.");
        System.out.printf("La longitud media de las palabras es: %.2f\n", averageLength);
        System.out.println("La palabra más larga es: \"" + longestWord + "\"");
        System.out.println("La palabra más corta es: \"" + shortestWord + "\"");
    }

    // Ejercicio Comodín: Palabras Palíndromas
    public static void exerciseWildcard(String fileName) throws IOException {
        Stack<String> stack = loadStringsToStack(fileName);
        int palindromeCount = 0;
        int totalLength = 0;

        for (String word : stack) {
            if (isPalindrome(word)) palindromeCount++;
            totalLength += word.length();
        }

        System.out.println("Cantidad de palabras palíndromas en la pila: " + palindromeCount);
        System.out.println("Longitud total de todas las palabras en la pila: " + totalLength);
    }

    // Funciones auxiliares
    public static Stack<Integer> loadNumbersToStack(String fileName) throws IOException {
        Stack<Integer> stack = new Stack<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                stack.push(Integer.parseInt(line));
            }
        }
        return stack;
    }

    public static Queue<Integer> loadNumbersToQueue(String fileName) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                queue.add(Integer.parseInt(line));
            }
        }
        return queue;
    }

    public static Stack<String> loadStringsToStack(String fileName) throws IOException {
        Stack<String> stack = new Stack<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                stack.push(line.trim());
            }
        }
        return stack;
    }

    public static Queue<String> loadStringsToQueue(String fileName) throws IOException {
        Queue<String> queue = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                queue.add(line.trim());
            }
        }
        return queue;
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isHarshad(int number) {
        int sumOfDigits = String.valueOf(number).chars().map(Character::getNumericValue).sum();
        return number % sumOfDigits == 0;
    }

    public static boolean isPalindrome(String word) {
        String reverse = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(reverse);
    }
}