package uniquindio.estructuras.listas.clases;

import uniquindio.estructuras.listas.exceptions.IndiceInvalidoException;
import uniquindio.estructuras.listas.exceptions.ValorNoEncontradoException;

import javax.swing.*;
import java.util.Iterator;

public class ListaSimple<T> implements Iterable<T> {
    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    private int size;

    public ListaSimple(){
        nodoPrimero = nodoUltimo = null;
        size = 0;
    }

    public void agregarNodoInicio(T valorNodo){
        Nodo<T> nuevoNodo = new Nodo<>(valorNodo);
        if (estaVacia())
            nodoPrimero = nodoUltimo = nuevoNodo;
        else{
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevoNodo;
        }
        ++size;
    }

    public void agregarNodo(T valorNodo){
        Nodo<T> nuevoNodo = new Nodo<>(valorNodo);
        if (estaVacia())
            nodoPrimero = nodoUltimo = nuevoNodo;
        else {
            nodoUltimo.setSiguienteNodo(nuevoNodo);
            nodoUltimo = nuevoNodo;
        }
        ++size;
    }

    public T obtenerValorNodo(int indice){
        Nodo<T> nodoTemporal = null;
        int contador = 0;

        try {
            if(validarIndice(indice)){
                nodoTemporal = nodoPrimero;
                while(contador<indice){
                    nodoTemporal = nodoTemporal.getSiguienteNodo();
                    contador++;
                }
            }
            if(nodoTemporal!=null)
                return nodoTemporal.getValorNodo();
            else
                return null;

        } catch (IndiceInvalidoException e) {
            JOptionPane.showMessageDialog(null,"Introduzca un indice válido");
            return null;
        }
    }


    private boolean validarIndice(int indice) throws IndiceInvalidoException {
        if(indice >= 0 && indice<size)
            return true;
        throw new IndiceInvalidoException();
    }

    public boolean estaVacia() {
        return nodoPrimero == null && nodoUltimo == null;
    }
    public void eliminar(T dato) throws ValorNoEncontradoException {
        if (estaVacia())
            return;
        if (nodoPrimero.getValorNodo().equals(dato)) {
            nodoPrimero = nodoPrimero.getSiguienteNodo();
            size--;
            return;
        }

        boolean encontrado = false;
        Nodo<T> anterior = null;
        Nodo<T> siguiente = null;
        Nodo<T> actual = nodoPrimero;

        while (actual != null){
            if(actual.getValorNodo().equals(dato)){
                encontrado = true;
                break;
            }
            anterior = actual;
            actual = actual.getSiguienteNodo();
        }
        if (encontrado){
            siguiente = actual.getSiguienteNodo();
            if(siguiente==null){
                assert anterior != null : "Se exedieron los parametros";
                anterior.setSiguienteNodo(null);
                nodoUltimo = anterior;
            }else{
                assert anterior != null;
                anterior.setSiguienteNodo(siguiente);
            }
            size--;
            return;
        }
        throw new ValorNoEncontradoException();
    }
    public void eliminarPrimero() {
        if( !estaVacia() ) {
            nodoPrimero = nodoPrimero.getSiguienteNodo();
            size--;
        }

        throw new RuntimeException("Lista vacía");
    }

    public void imprimirLista(){
        for(Nodo<T> i = nodoPrimero;i!=null;i=i.getSiguienteNodo()){
            System.out.println("\n"+i.getValorNodo()+"\t");
        }
    }

    private Nodo<T> obtenerNodo(int indice) {

        if(indice>=0 && indice<size) {

            Nodo<T> nodo = nodoPrimero;

            for (int i = 0; i < indice; i++) {
                nodo = nodo.getSiguienteNodo();
            }

            return nodo;
        }

        return null;
    }

    public void modificarNodo(int indice, T nuevo) throws IndiceInvalidoException {

        if( validarIndice(indice) ) {
            Nodo<T> nodo = obtenerNodo(indice);
            nodo.setValorNodo(nuevo);
        }

    }

    public int obtenerPosicionNodo(T dato) {

        int i = 0;

        for( Nodo<T> aux = nodoPrimero ; aux!=null ; aux = aux.getSiguienteNodo() ) {
            if( aux.getValorNodo().equals(dato) ) {
                return i;
            }
            i++;
        }

        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorListaSimple(nodoPrimero);
    }

    public Nodo<T> getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(Nodo<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public Nodo<T> getNodoUltimo() {
        return nodoUltimo;
    }

    public void setNodoUltimo(Nodo<T> nodoUltimo) {
        this.nodoUltimo = nodoUltimo;
    }

    public int getSize() {
        return size;
    }

    public class IteradorListaSimple implements Iterator<T>{
        private Nodo<T> nodo;
        private int posicion;

        public IteradorListaSimple(Nodo<T> nodo){
            this.nodo = nodo;
            this.posicion = 0;
        }

        @Override
        public boolean hasNext() {
            return nodo != null;
        }

        @Override
        public T next() {
            T valor = nodo.getValorNodo();
            nodo = nodo.getSiguienteNodo();
            ++posicion;
            return valor;
        }
        public int getPosicion(){
            return posicion;
        }
    }
}
