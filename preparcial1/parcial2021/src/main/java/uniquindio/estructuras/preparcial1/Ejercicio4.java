package uniquindio.estructuras.preparcial1;

public class Ejercicio4 {
    public static void main(String[] args) {
        int[] arreglo = {0, 1, 0, 0, 2, 0, 0, 3, 4, 5, 6, 7, 8, 9, 10, 0};

        int nC = hallarCantidadCeros(arreglo);
        System.out.println(nC);
    }

    private static int hallarCantidadCeros(int[] arreglo) {
        return contarCeros(arreglo,0,arreglo.length-1);
    }

    private static int contarCeros(int[] arreglo, int inicio, int end) {
        if(inicio == end){
            return (arreglo[inicio]==0 ? 1 : 0);
        }else {
            int mitad = (inicio + end)/2;
            int izquierda = contarCeros(arreglo, inicio, mitad);
            int derecha = contarCeros(arreglo,mitad+1,end);

            return izquierda+derecha;
        }
    }
}
