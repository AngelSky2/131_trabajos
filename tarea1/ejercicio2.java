package tarea1;
import java.util.Arrays;

public class OrdenarPorFrecuencia {
    public static void main(String[] args) {
        int[] vector = {4, 5, 6, 5, 4, 3, 5, 4};
        int[] vectorOrdenado = ordenarPorFrecuencia(vector);
        System.out.println( Arrays.toString(vectorOrdenado));
    }
    public static int[] ordenarPorFrecuencia(int[] vector) {  
        int max = Arrays.stream(vector).max().orElse(0);
        int[] frecuencias = new int[max + 1];
        for (int num : vector) {
            frecuencias[num]++;
        }
        for (int i = 0; i < vector.length; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (frecuencias[vector[i]] < frecuencias[vector[j]] ||
                    (frecuencias[vector[i]] == frecuencias[vector[j]] && vector[i] > vector[j])) {
                    int temp = vector[i];
                    vector[i] = vector[j];
                    vector[j] = temp;
                }
            }
        }
        return vector;
    }
}