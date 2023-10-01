package uniquindio.estructuras.listas.laboratorio;

import uniquindio.estructuras.listas.clases.ListaSimple;
import java.util.Objects;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        ListaSimple<Integer> listaNumeros = new ListaSimple<Integer>();
        int valor;
        Scanner scanner = new Scanner(System.in);
        listaNumeros.agregarNodo(1);
        listaNumeros.agregarNodo(2);
        listaNumeros.agregarNodo(3);
        listaNumeros.agregarNodo(4);
        listaNumeros.agregarNodo(5);
        listaNumeros.agregarNodo(5);
        listaNumeros.agregarNodo(5);
        listaNumeros.agregarNodo(5);
        listaNumeros.agregarNodo(9);
        listaNumeros.agregarNodo(11);

        System.out.println("Ingrese el valor a buscar");
        valor = scanner.nextInt();

        int num = contarNumeroRepeticiones(listaNumeros,valor);

        System.out.println("El número de repeticiones del valor "+valor+" es: "+num);
    }

    private static int contarNumeroRepeticiones(ListaSimple<Integer> listaNumeros, int valor) {
        int num = 0;
        for (int i = 0; i < listaNumeros.getSize(); i++) {
            if(Objects.equals(listaNumeros.obtenerValorNodo(i), valor))
                num++;
        }
        return num;
    }
}
