package uniquindio.estructuras.recursividad.practicaClase1;

public class Ejercicio3 {
    public static void main(String[] args) {
        int[][] arreglo1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        if (sonIguales(arreglo1, 0, 0)) {
            System.out.println("La matriz es simetrica");
        } else {
            System.out.println("La matriz no es simetrica");
        }

    }

    private static boolean sonIguales(int[][] arreglo1, int i, int j) {
        if (i == arreglo1.length) {
            return true;
        }

        if (j == arreglo1[0].length) {
            return sonIguales(arreglo1, i + 1, 0);
        } else {
            return arreglo1[i][j] == arreglo1[j][i] && sonIguales(arreglo1, i, j + 1);
        }
    }
}