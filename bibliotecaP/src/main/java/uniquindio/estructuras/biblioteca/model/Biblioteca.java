package uniquindio.estructuras.biblioteca.model;

import java.util.Arrays;
import java.util.Objects;

public class Biblioteca {

    private String nombre;
    private Libro [] libroLista;
    private Prestamo [] prestamoLista;
    private Bibliotecario bibliotecario;

    public Biblioteca(String nombre, Libro[] libroLista, Prestamo[] prestamoLista, Bibliotecario bibliotecario) {
        this.nombre = nombre;
        this.libroLista = libroLista;
        this.prestamoLista = prestamoLista;
        this.bibliotecario = bibliotecario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Libro[] getLibroLista() {
        return libroLista;
    }

    public void setLibroLista(Libro[] libroLista) {
        this.libroLista = libroLista;
    }

    public Prestamo[] getPrestamoLista() {
        return prestamoLista;
    }

    public void setPrestamoLista(Prestamo[] prestamoLista) {
        this.prestamoLista = prestamoLista;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Biblioteca that = (Biblioteca) o;
        return Objects.equals(nombre, that.nombre) && Arrays.equals(libroLista, that.libroLista) && Arrays.equals(prestamoLista, that.prestamoLista) && Objects.equals(bibliotecario, that.bibliotecario);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nombre, bibliotecario);
        result = 31 * result + Arrays.hashCode(libroLista);
        result = 31 * result + Arrays.hashCode(prestamoLista);
        return result;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", libroLista=" + Arrays.toString(libroLista) +
                ", prestamoLista=" + Arrays.toString(prestamoLista) +
                ", bibliotecario=" + bibliotecario +
                '}';
    }
}
