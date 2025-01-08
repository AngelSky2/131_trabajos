package tarea1;

public class ejercicio3 {
    public static void main(String[] args) {
        int[] vector = {1,2,3};
        int suma=0;
        for(int i =0; i<vector.length; i++){
            for (int j=0; j<vector.length;j++){
                if(!(i==j)){
                    suma =vector[i]+vector[j];
                    System.out.println("("+vector[i]+","+vector[j]+")"+suma);
                }
            }
        }
        
    }
}