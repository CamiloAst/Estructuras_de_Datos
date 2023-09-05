package lab.modelo;

public class Celda extends Pasillo{
    private int numero;
    private boolean ocupada;
    private Prisionero prisionero;
    private boolean check = false;

    public Celda(int numero, boolean ocupada, Prisionero prisionero) {
        super();
        this.numero = numero;
        this.ocupada = ocupada;
        this.prisionero = prisionero;
    }
    public Celda(int numero, boolean ocupada) {
        super();
        this.numero = numero;
        this.ocupada = ocupada;
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

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

    @Override
    public String toString() {
        return "celda" + numero;
    }
}
