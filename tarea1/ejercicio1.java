public class ejercicio1 {
    public static void main(String[] args) {
        int may = 0 ;
        int contador = 0;
       int[] vector = {-2,1,-3,4,-1,2,1,-5,4};
       for (int i =0 ; i<vector.length;i++){
            for (int j = vector.length-1 ;j>i;j-- ){
                contador =sumar(vector, i, j) ;
                if(contador>may){
                    may = contador;
                }
            }
       }
       System.out.println(may);
    }
    public static int sumar(int[] v, int inicio,int fin){
        int c = 0;
        for (int i =inicio; i<fin; i++){
            c=c+v[i];
        }
        return c; 
    }
    
}