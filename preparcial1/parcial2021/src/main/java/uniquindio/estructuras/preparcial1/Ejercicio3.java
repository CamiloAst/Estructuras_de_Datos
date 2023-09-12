package uniquindio.estructuras.preparcial1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(0);
        numeros.add(2);
        numeros.add(3);
        int n = compararNumeros(numeros);
        System.out.println(n);
    }

    private static int compararNumeros(@NotNull List<Integer> numeros) {
        if(numeros.size() <= 1)
            return numeros.get(0);
        else{
            numeros.remove(0);
            if(compararNumeros(numeros)==numeros.size())
                return 0;
            return (compararNumeros(numeros)>numeros.size() ? 1 : -1);
        }
    }

}
