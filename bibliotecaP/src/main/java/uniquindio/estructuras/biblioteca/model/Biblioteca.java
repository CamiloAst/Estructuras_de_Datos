package uniquindio.estructuras.biblioteca.model;
import uniquindio.estructuras.biblioteca.comparadores.CompararLibro;
import java.util.*;

public class Biblioteca {

    private String nombre;
    private HashSet<Estudiante> estudiantes;
    private TreeSet<Libro> libros;
    private TreeSet<Bibliotecario> bibliotecarios;
    private HashMap<String, Prestamo> prestamos;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new HashSet<Estudiante>();
        this.libros = new TreeSet<Libro>(new CompararLibro());
        this.bibliotecarios = new TreeSet<Bibliotecario>();
        this.prestamos = new HashMap<String, Prestamo>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashSet<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(HashSet<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public TreeSet<Libro> getLibros() {
        return libros;
    }

    public void setLibros(TreeSet<Libro> libros) {
        this.libros = libros;
    }

    public TreeSet<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(TreeSet<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public HashMap<String, Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(HashMap<String, Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Biblioteca that = (Biblioteca) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(estudiantes, that.estudiantes) && Objects.equals(libros, that.libros) && Objects.equals(bibliotecarios, that.bibliotecarios) && Objects.equals(prestamos, that.prestamos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, estudiantes, libros, bibliotecarios, prestamos);
    }
}
