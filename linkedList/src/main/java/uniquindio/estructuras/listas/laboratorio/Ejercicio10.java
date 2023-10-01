package uniquindio.estructuras.listas.laboratorio;

import uniquindio.estructuras.listas.clases.ListaSimple;

public class Ejercicio10 {
    public static void main(String[] args) {
        ListaSimple<Integer> lista1 = new ListaSimple<Integer>();
        ListaSimple<Integer> lista2 = new ListaSimple<Integer>();

        lista1.agregarNodo(1);
        lista1.agregarNodo(2);
        lista1.agregarNodo(3);

        lista2.agregarNodo(4);
        lista2.agregarNodo(5);
        lista2.agregarNodo(6);

        ListaSimple<Integer> resultado = concatenarListasSimples(lista1,lista2);

        resultado.imprimirLista();
    }

    private static ListaSimple<Integer> concatenarListasSimples(ListaSimple<Integer> lista1, ListaSimple<Integer> lista2) {
        ListaSimple<Integer> resultado = new ListaSimple<Integer>();
//        for (int i = 0; i < lista1.getSize(); i++) {
//            resultado.agregarNodo(lista1.obtenerValorNodo(i));
//        }
//        for (int i = 0; i < lista2.getSize(); i++) {
//            resultado.agregarNodo(lista2.obtenerValorNodo(i));
//        }
        lista1.getNodoUltimo().setSiguienteNodo(lista2.getNodoPrimero());
        resultado = lista1;
        return resultado;
    }
}
