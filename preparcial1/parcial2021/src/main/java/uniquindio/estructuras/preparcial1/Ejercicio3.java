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
        numeros.add(4);
        numeros.add(3);
        int n = encontrarIndice(numeros);
        System.out.println(n);
    }

    public static int encontrarIndice(List<Integer> numeros){
        int num = compararNumeros(numeros, 0);
        if(num==0 || numeros.get(num) == num)
            return 0;
        return (numeros.get(num)>num ? 1 : -1);
    }
    private static int compararNumeros(@NotNull List<Integer> numeros, int num) {
        try{
            if (numeros.get(num + 1) == null) {
                throw new IndexOutOfBoundsException();
            }
            return compararNumeros(numeros, ++num);
        } catch (IndexOutOfBoundsException e) {
            return num;
        }

    }

}
