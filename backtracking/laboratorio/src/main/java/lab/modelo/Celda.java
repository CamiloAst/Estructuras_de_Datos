package lab.modelo;

public class Celda{
    private int numero;
    private boolean ocupada;
    private Prisionero prisionero;

    public Celda(int numero, boolean ocupada, Prisionero prisionero) {
        super();
        this.numero = numero;
        this.ocupada = ocupada;
        this.prisionero = prisionero;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public Prisionero getPrisionero() {
        return prisionero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setPrisionero(Prisionero prisionero) {
        this.prisionero = prisionero;
    }

    @Override
    public String toString() {
        return "Celda [numero=" + numero + ", ocupada=" + ocupada + ", prisionero=" + prisionero + "]";
    }
}
