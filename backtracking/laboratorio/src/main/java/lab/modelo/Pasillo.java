package lab.modelo;

public class Pasillo {
    private boolean recorrido = false;
    private boolean salida = false;

    public Pasillo() {
        super();
    }

    public boolean isRecorrido() {
        return recorrido;
    }

    public void setRecorrido(boolean recorrido) {
        this.recorrido = recorrido;
    }

    public boolean isSalida() {
        return salida;
    }

    public void setSalida(boolean salida) {
        this.salida = salida;
    }
}
