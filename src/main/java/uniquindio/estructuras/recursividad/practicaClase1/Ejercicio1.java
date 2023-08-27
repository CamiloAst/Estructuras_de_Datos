package uniquindio.estructuras.recursividad.practicaClase1;

public class Ejercicio1 {
    public static void main(String[] args) {
        int [] arreglo = {0,1,0,0,2,3,4,5,6,7,8,9,10,0};

        System.out.println("El numero de ceros en el arreglo es: " + contarCeros(arreglo));
    }

    private static int contarCeros(int[] arreglo) {
        if (arreglo.length == 0) {
            return 0;
        }
        int[] arregloR = new int[arreglo.length - 1];
        System.arraycopy(arreglo, 1, arregloR, 0, arregloR.length);
        return (arreglo[0] == 0 ? 1 : 0) + contarCeros(arregloR);
    }
}
