package uniquindio.estructuras.preparcial1;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(0);
        int n = compararNumeros(numeros);
        System.out.println(n);
    }

    private static int compararNumeros(List<Integer> numeros) {
        return (numeros.get(numeros.size() - 1) > numeros.size() ? -1 : 1);
    }

}
