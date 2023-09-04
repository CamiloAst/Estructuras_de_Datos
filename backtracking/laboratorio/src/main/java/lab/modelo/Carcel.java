package lab.modelo;

import java.util.List;

public class Carcel {
    private List<Pasillo> pasillos;
    private List<Celda> celdas;
    private List<Prisionero> prisioneros;

    public Carcel(List<Pasillo> pasillos, List<Celda> celdas, List<Prisionero> prisioneros) {
        super();
        this.pasillos = pasillos;
        this.celdas = celdas;
        this.prisioneros = prisioneros;
    }

    public List<Pasillo> getPasillos() {
        return pasillos;
    }

    public void setPasillos(List<Pasillo> pasillos) {
        this.pasillos = pasillos;
    }

    public List<Celda> getCeldas() {
        return celdas;
    }

    public void setCeldas(List<Celda> celdas) {
        this.celdas = celdas;
    }

    public List<Prisionero> getPrisioneros() {
        return prisioneros;
    }

    public void setPrisioneros(List<Prisionero> prisioneros) {
        this.prisioneros = prisioneros;
    }
}
