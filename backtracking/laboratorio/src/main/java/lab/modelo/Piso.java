package lab.modelo;

import java.util.List;

public class Piso {
    private int cantidadCeldas;
    private int cantidadPasillos;
    private int cantidadPrisioneros;
    private int cantidadCeldasOcupadas;
    private int cantidadCeldasLibres;
    private Pasillo[][] mapa;
    private List<Prisionero> prisioneros;

    public Piso(int cantidadCeldas, int cantidadPasillos, int cantidadPrisioneros, int cantidadCeldasOcupadas,
            int cantidadCeldasLibres) {
        super();
        this.cantidadCeldas = cantidadCeldas;
        this.cantidadPasillos = cantidadPasillos;
        this.cantidadPrisioneros = cantidadPrisioneros;
        this.cantidadCeldasOcupadas = cantidadCeldasOcupadas;
        this.cantidadCeldasLibres = cantidadCeldasLibres;
    }

    public int getCantidadCeldas() {
        return cantidadCeldas;
    }

    public void setCantidadCeldas(int cantidadCeldas) {
        this.cantidadCeldas = cantidadCeldas;
    }

    public int getCantidadPasillos() {
        return cantidadPasillos;
    }

    public void setCantidadPasillos(int cantidadPasillos) {
        this.cantidadPasillos = cantidadPasillos;
    }

    public int getCantidadPrisioneros() {
        return cantidadPrisioneros;
    }

    public void setCantidadPrisioneros(int cantidadPrisioneros) {
        this.cantidadPrisioneros = cantidadPrisioneros;
    }

    public int getCantidadCeldasOcupadas() {
        return cantidadCeldasOcupadas;
    }

    public void setCantidadCeldasOcupadas(int cantidadCeldasOcupadas) {
        this.cantidadCeldasOcupadas = cantidadCeldasOcupadas;
    }

    public int getCantidadCeldasLibres() {
        return cantidadCeldasLibres;
    }

    public void setCantidadCeldasLibres(int cantidadCeldasLibres) {
        this.cantidadCeldasLibres = cantidadCeldasLibres;
    }

    public Pasillo[][] getMapa() {
        return mapa;
    }

    public void setMapa(Pasillo[][] mapa) {
        this.mapa = mapa;
    }

    public List<Prisionero> getPrisioneros() {
        return prisioneros;
    }
    public void setPrisioneros(List<Prisionero> prisioneros) {
        this.prisioneros = prisioneros;
    }
    public void añadirPrisionero(Prisionero prisionero) {
        this.prisioneros.add(prisionero);
    }
    public void eliminarPrisionero(Prisionero prisionero) {
        this.prisioneros.remove(prisionero);
    }
}
