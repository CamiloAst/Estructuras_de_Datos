package uniquindio.estructuras.biblioteca.model;
import uniquindio.estructuras.biblioteca.comparadores.CompararLibro;
import uniquindio.estructuras.biblioteca.exceptions.CodigoNoEncontradoException;
import uniquindio.estructuras.biblioteca.exceptions.UsuarioNoEncontradoException;

import java.util.*;

public class Biblioteca {

    private String nombre;
    private HashSet<Estudiante> estudiantes;
    private TreeSet<Libro> libros;
    private TreeSet<Bibliotecario> bibliotecarios;
    private HashMap<String, Prestamo> prestamos;
    private User user;
    private Autor autor = new Autor("Desconocido", "Desconocido", "1");
    private Autor autor1 = new Autor("Mario", "Mendoza", "2");
    private Autor autor2 = new Autor("Fiódor", "Dostoyevski","3");


    HashMap<String, DetallePrestamo> detallePrestamo = new HashMap<String, DetallePrestamo>();



    public Biblioteca(String nombre) {

        this.nombre = nombre;
        this.estudiantes = new HashSet<Estudiante>();
        this.libros = new TreeSet<Libro>(new CompararLibro());
        this.bibliotecarios = new TreeSet<Bibliotecario>();
        this.prestamos = new HashMap<String, Prestamo>();
        crearEstudiante("Juan","correo","123","318");
        crearEstudiante("Pedro","correo","321","321");
        crearEstudiante("Maria","correo","456","456");
        crearEstudiante("Luis","correo","654","654");
        crearEstudiante("Ana","correo","789","789");
        crearBibliotecario("Pepe","López","321","casa2",1234567);
        crearBibliotecario("Juan","Perez","123","casa1",1234567);
        crearBibliotecario("Maria","Gomez","456","casa3",1234567);
        crearBibliotecario("Luis","Gonzalez","654","casa4",1234567);
        crearBibliotecario("Ana","Rodriguez","789","casa5",1234567);
        crearLibro(new Libro("El principito",autor,"norma","12","disponible",10000,"español",1,1,"1"));
        crearLibro(new Libro("Satanas",autor1,"norma","12","disponible",10000,"español",1,1,"2"));
        crearLibro(new Libro("Crimen y castigo", autor2,"norma","12","disponible",10000,"español",1,1,"3"));
        DetallePrestamo detallePrestamo1 = new DetallePrestamo(1, "1",obtenerLibro(autor),10000);
        DetallePrestamo detallePrestamo2 = new DetallePrestamo(2, "2",obtenerLibro(autor1),10000);
        DetallePrestamo detallePrestamo3 = new DetallePrestamo(3, "3",obtenerLibro(autor2),10000);
        detallePrestamo.put("1", detallePrestamo1);
        detallePrestamo.put("2", detallePrestamo2);
        detallePrestamo.put("3", detallePrestamo3);
        crearPrestamo("1",obtenerEstudiante("789"),"12/12/12","12/12/12",detallePrestamo);
        crearPrestamo("2",obtenerEstudiante("321"),"12/12/12","12/12/12",detallePrestamo);
        crearPrestamo("3",obtenerEstudiante("456"),"12/12/12","12/12/12",detallePrestamo);

        this.user = new User();

    }

    private void crearLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro obtenerLibro(Autor autor) {
        Iterator<Libro> iterator = libros.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getAutor().compareTo(autor)==0) {
                return libro;
            }
        }
        return null;
    }

    public User getAdminController() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Bibliotecario obtenerBibliotecario(String cedula) throws UsuarioNoEncontradoException {
        Iterator<Bibliotecario> iterator = bibliotecarios.iterator();
        while (iterator.hasNext()) {
            Bibliotecario bibliotecario = iterator.next();
            if (bibliotecario.getCedula().equals(cedula)) {
                return bibliotecario;
            }
        }
        throw new UsuarioNoEncontradoException("Usuario no encontrado");
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

    public void crearPrestamo(String codigo, Estudiante estudiante, String fechaPrestamo, String fechaDevolucion, HashMap<String, DetallePrestamo> detallePrestamo) {
        Prestamo nuevoPrestamo = new Prestamo(codigo, estudiante, fechaPrestamo, fechaDevolucion, detallePrestamo);
        prestamos.put(codigo, nuevoPrestamo);
    }

    public void actualizarPrestamo(String codigo, Estudiante estudiante, Bibliotecario bibliotecario, String fechaPrestamo, String fechaDevolucion, HashMap<String, DetallePrestamo> detallePrestamo) {
        Prestamo prestamo = prestamos.get(codigo);
        prestamo.setEstudiante(estudiante);
        prestamo.setFechaPrestamo(fechaPrestamo);
        prestamo.setFechaDevolucion(fechaDevolucion);
        prestamo.setDetallePrestamo(detallePrestamo);
    }

    public void eliminarPrestamo(String codigo)throws CodigoNoEncontradoException {
        prestamos.remove(codigo);
    }

    public Prestamo obtenerPrestamo(String codigo) {
        return prestamos.get(codigo);
    }


    public void consultarLibro(String autor, String titulo) {
        Iterator<Libro> iterator = libros.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getAutor().equals(autor) || libro.getTitulo().equals(titulo)) {
                System.out.println(libro);
            }
        }
    }

    public void actualizarPrestamo(String codigo, Prestamo prestamo) {
        prestamos.get(codigo).setEstudiante(prestamo.getEstudiante());
    }
}
