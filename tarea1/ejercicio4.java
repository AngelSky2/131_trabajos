public class ejercicio4 {

    public static void main(String[] args) {
        int[][] matrizA = {
            {1, 2},
            {3, 4}
        };
        int[][] matrizB = {
            {2, 0},
            {1, 2}
        };
        int[][] resultado = multiplicarMatrices(matrizA, matrizB);
        System.out.println("Producto de las matrices:");
        for (int[] fila : resultado) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB) {
        int n = matrizA.length;
        int[][] resultado = new int[n][n];
        for (int i = 0; i < n; i++) {            
            for (int j = 0; j < n; j++) {        
                for (int k = 0; k < n; k++) {  
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        return resultado;
    }
}