package uniquindio.estructuras.recursividad.practicaClase1;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[][] arreglo = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println("La suma de los elementos de la matriz es: " + sumarElementos(arreglo,0,0));
    }

    private static int sumarElementos(int[][] arreglo,int i,int j) {
        if (i == arreglo.length) {
            return 0;
        }

        if (j == arreglo[0].length){
            return 0 + sumarElementos(arreglo,i+1,0);
        }else{
            return arreglo[i][j] + sumarElementos(arreglo,i,j+1);
        }

    }
}
