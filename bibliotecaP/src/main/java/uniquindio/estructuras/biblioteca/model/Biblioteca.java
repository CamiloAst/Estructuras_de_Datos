package uniquindio.estructuras.biblioteca.model;
import uniquindio.estructuras.biblioteca.comparadores.CompararLibro;
import java.util.*;

public class Biblioteca {

    private String nombre;
    private HashSet<Estudiante> estudiantes;
    private TreeSet<Libro> libros;
    private TreeSet<Bibliotecario> bibliotecarios;
    private static HashMap<String, Prestamo> prestamos;

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

    public void crearBibliotecario(String nombre, String correo, String cedula, String direccion, double salario) {
        Bibliotecario nuevoBibliotecario = new Bibliotecario(nombre, correo, cedula, direccion, salario );
        bibliotecarios.add((Bibliotecario) nuevoBibliotecario);
    }


    public void actualizarBibliotecario(String nombre, String correo, String cedula, String direccion, double salario) {
        Iterator<Bibliotecario> iterator = bibliotecarios.iterator();
        while (iterator.hasNext()) {
            Bibliotecario bibliotecario = iterator.next();
            if (bibliotecario.getNombre().equals(nombre)) {
                bibliotecario.setCorreo(correo);
                bibliotecario.setCedula(cedula);
                bibliotecario.setDireccion(direccion);
                bibliotecario.setSalario(salario);
                break;
            }
        }
    }

    public void eliminarBibliotecario(String cedula) {
        Iterator<Bibliotecario> iterator = bibliotecarios.iterator();
        while (iterator.hasNext()) {
            Bibliotecario bibliotecario = iterator.next();
            if (bibliotecario.getCedula().equals(cedula)) {
                bibliotecarios.remove(bibliotecario);
                break;
            }
        }
    }

    public Bibliotecario obtenerBibliotecario(String cedula) {
        Iterator<Bibliotecario> iterator = bibliotecarios.iterator();
        while (iterator.hasNext()) {
            Bibliotecario bibliotecario = iterator.next();
            if (bibliotecario.getCedula().equals(cedula)) {
                return bibliotecario;
            }
        }
        return null;
    }
    public void crearEstudiante(String nombre, String correo, String cedula, String telefono){
        Estudiante nuevoEstudiante = new Estudiante(nombre, correo, cedula, telefono);
        estudiantes.add((Estudiante) nuevoEstudiante);
    }
    public void actualizarEstudiante(String nombre, String correo, String cedula, String telefono) {
        Iterator<Estudiante> iterator = estudiantes.iterator();
        while (iterator.hasNext()) {
            Estudiante estudiante = iterator.next();
            if (estudiante.getNombre().equals(nombre)) {
                estudiante.setCorreo(correo);
                estudiante.setCedula(cedula);
                estudiante.setTelefono(telefono);
                break;
            }
        }
    }

    public void eliminarEstudiante(String cedula) {
        Iterator<Estudiante> iterator = estudiantes.iterator();
        while (iterator.hasNext()) {
            Estudiante estudiante = iterator.next();
            if (estudiante.getCedula().equals(cedula)) {
                estudiantes.remove(estudiante);
                break;
            }
        }
    }

    public Estudiante obtenerEstudiante(String cedula) {
        Iterator<Estudiante> iterator = estudiantes.iterator();
        while (iterator.hasNext()) {
            Estudiante estudiante = iterator.next();
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

    public static void crearPrestamo(String codigo, Estudiante estudiante, Bibliotecario bibliotecario, Date fechaPrestamo, Date fechaDevolucion, Map<String, DetallePrestamo> detallePrestamo) {
        Prestamo nuevoPrestamo = new Prestamo(codigo, estudiante, bibliotecario, fechaPrestamo, fechaDevolucion, detallePrestamo);
        prestamos.put(codigo, nuevoPrestamo);
    }

    public void actualizarPrestamo(String codigo, Estudiante estudiante, Bibliotecario bibliotecario, Date fechaPrestamo, Date fechaDevolucion, Map<String, DetallePrestamo> detallePrestamo) {
        Prestamo prestamo = prestamos.get(codigo);
        prestamo.setEstudiante(estudiante);
        prestamo.setBibliotecario(bibliotecario);
        prestamo.setFechaPrestamo(fechaPrestamo);
        prestamo.setFechaDevolucion(fechaDevolucion);
        prestamo.setDetallePrestamo(detallePrestamo);
    }

    public static void eliminarPrestamo(String codigo) {
        prestamos.remove(codigo);
    }

    public Prestamo obtenerPrestamo(String codigo) {
        return prestamos.get(codigo);
    }







}
