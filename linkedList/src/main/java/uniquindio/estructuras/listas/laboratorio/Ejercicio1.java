package uniquindio.estructuras.listas.laboratorio;

import uniquindio.estructuras.listas.clases.ListaSimple;

public class Ejercicio1 {
    public static void main(String[] args) {
        ListaSimple<Integer> listaNumeros = new ListaSimple<Integer>();
        ListaSimple<Integer> resultado = new ListaSimple<Integer>();

        listaNumeros.agregarNodo(1);
        listaNumeros.agregarNodo(2);
        listaNumeros.agregarNodo(3);
        listaNumeros.agregarNodo(4);
        listaNumeros.agregarNodo(5);
        listaNumeros.agregarNodo(6);
        listaNumeros.agregarNodo(7);
        listaNumeros.agregarNodo(8);
        listaNumeros.agregarNodo(9);
        listaNumeros.agregarNodo(11);

        resultado = obtenerPosicionesImpares(listaNumeros);
        System.out.println("Los números de la posiciones impares de la lista enlazada son los siguientes");
        resultado.imprimirLista();
    }

    private static ListaSimple<Integer> obtenerPosicionesImpares(ListaSimple<Integer> listaNumeros) {
        ListaSimple<Integer> resultado = new ListaSimple<Integer>();
        for (int i = 1; i < listaNumeros.getSize(); i+=2) {
            resultado.agregarNodo(listaNumeros.obtenerValorNodo(i));
        }
        return resultado;
    }
}

