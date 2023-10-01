package uniquindio.estructuras.listas.laboratorio;

import uniquindio.estructuras.listas.clases.ListaSimple;
import uniquindio.estructuras.listas.exceptions.ValorNoEncontradoException;

public class Ejercicio3 {
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
        listaNumeros.agregarNodo(10);

        try {
            eliminarNumerosPares(listaNumeros);
        } catch (ValorNoEncontradoException e) {
            throw new RuntimeException(e);
        }
        listaNumeros.imprimirLista();
    }

    private static void eliminarNumerosPares(ListaSimple<Integer> listaNumeros) throws ValorNoEncontradoException {
        for (int i = 0; i < listaNumeros.getSize(); i++) {
            if(listaNumeros.obtenerValorNodo(i)%2==0)
                listaNumeros.eliminar(listaNumeros.obtenerValorNodo(i));
        }

    }
}
