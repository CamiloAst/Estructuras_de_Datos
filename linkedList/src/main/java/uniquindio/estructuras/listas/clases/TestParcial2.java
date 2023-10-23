package uniquindio.estructuras.listas.clases;

public class TestParcial2 {
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

        listaNumeros.imprimirLista();

        System.out.println("Lista Invertida\n\n");
        invertirLista(listaNumeros,null);

        listaNumeros.imprimirLista();
    }

    public static Nodo<Integer> invertirLista(ListaSimple<Integer> lista, Nodo nodoAnterior){
        if(lista.estaVacia() || lista.getNodoPrimero().getSiguienteNodo()==null){
            return lista.getNodoPrimero();
        }
        nodoAnterior = lista.getNodoPrimero();
        lista.setNodoPrimero(nodoAnterior.getSiguienteNodo());
        Nodo<Integer> nodoActual = invertirLista(lista,nodoAnterior.getSiguienteNodo());
        nodoActual.setSiguienteNodo(nodoAnterior);
        nodoAnterior.setSiguienteNodo(null);
        return nodoAnterior;
    }

}
