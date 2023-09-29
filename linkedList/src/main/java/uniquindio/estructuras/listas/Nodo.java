package uniquindio.estructuras.listas;

public class Nodo<T> {
    private Nodo<T> siguienteNodo;
    private T valorNodo;
    private int posicion;

    public Nodo(T valorNodo, Nodo<T> siguienteNodo,int posicion){
        super();
        this.valorNodo = valorNodo;
        this.siguienteNodo = siguienteNodo;
        this.posicion = posicion;
    }
    public Nodo(T valorNodo){
        this.valorNodo = valorNodo;
    }

    public Nodo<T> getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo<T> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public T getValorNodo() {
        return valorNodo;
    }

    public void setValorNodo(T valorNodo) {
        this.valorNodo = valorNodo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
