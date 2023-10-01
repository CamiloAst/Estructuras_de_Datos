package uniquindio.estructuras.listas.laboratorio;

import uniquindio.estructuras.listas.clases.ListaSimple;

public class Ejercicio4 {
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

        resultado = obtenerNumerosImpares(listaNumeros);
        System.out.println("Los números impares de la lista son");
        resultado.imprimirLista();
    }

    private static ListaSimple<Integer> obtenerNumerosImpares(ListaSimple<Integer> listaNumeros) {
        ListaSimple<Integer> resultado = new ListaSimple<Integer>();
        for (int i = 0; i < listaNumeros.getSize(); i++) {
            if(listaNumeros.obtenerValorNodo(i)%2!=0)
                resultado.agregarNodo(listaNumeros.obtenerValorNodo(i));
        }
        return resultado;
    }
}
