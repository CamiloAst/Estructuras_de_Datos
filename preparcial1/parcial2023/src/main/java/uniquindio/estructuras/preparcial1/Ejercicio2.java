package uniquindio.estructuras.preparcial1;

import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[][] matriz = {
                {1,3,5,7},
                {2,4,6,8}
        };
        String cad = "";
        int[][] matrizT = transponerMatriz(matriz);
//        System.out.println(Arrays.deepToString(matrizT));
        for (int[] fila: matrizT) {
            for (int elemento:fila) {
                cad += (elemento + "\t");
            }
            cad += ("\n");
        }
        System.out.println(cad);
    }

    private static int[][] transponerMatriz(int[][] matriz) {
        int[][] matrizT = new int[matriz[0].length][matriz.length];
        return hallarTranspuesta(matriz, matrizT,0,0);
    }

    private static int[][] hallarTranspuesta(int[][] matriz, int[][] matrizT, int i, int j) {
        if(i >= matriz.length-1 && j >= matriz[0].length-1){
            return matrizT;
        }
        matrizT[j][i] = matriz[i][j];
        if(j>=matriz[0].length-1){
            hallarTranspuesta(matriz,matrizT,i+1,0);
        }
        else{
            hallarTranspuesta(matriz,matrizT,i,j+1);

        }

        return matrizT;
    }
}
