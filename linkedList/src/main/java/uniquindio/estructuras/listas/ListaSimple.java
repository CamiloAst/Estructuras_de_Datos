package uniquindio.estructuras.listas;

import uniquindio.estructuras.listas.exceptions.IndiceInvalidoException;
import uniquindio.estructuras.listas.exceptions.ValorNoEncontradoException;

import javax.swing.*;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

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

    public void agregarNodoFinal(T valorNodo){
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

    private boolean estaVacia() {
        return nodoPrimero == null && nodoUltimo == null;
    }

    public void imprimirLista(){
        Nodo<T> aux = nodoPrimero;

        while(aux!=null){
            System.out.println(aux.getValorNodo()+"\t");
            aux = aux.getSiguienteNodo();
        }
        System.out.println("\n");
    }

    public void eliminarDato(T dato) throws ValorNoEncontradoException {
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

    public void setSize(int size) {
        this.size = size;
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
