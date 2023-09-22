package uniquindio.estructuras.biblioteca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Prestamo implements Serializable {
    private String codigo;
    private Estudiante estudiante;
    private Bibliotecario bibliotecario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Map<String, DetallePrestamo> detallePrestamo;

    public Prestamo(String codigo, Estudiante estudiante, Bibliotecario bibliotecario, Date fechaPrestamo, Date fechaDevolucion, Map<String, DetallePrestamo> detallePrestamo) {
        this.codigo = codigo;
        this.estudiante = estudiante;
        this.bibliotecario = bibliotecario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.detallePrestamo = detallePrestamo;
    }

    public Prestamo() {
        super();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Map<String, DetallePrestamo> getDetallePrestamo() {
        return detallePrestamo;
    }

    public void setDetallePrestamo(Map<String, DetallePrestamo> detallePrestamo) {
        this.detallePrestamo = detallePrestamo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(codigo, prestamo.codigo) && Objects.equals(estudiante, prestamo.estudiante) && Objects.equals(bibliotecario, prestamo.bibliotecario) && Objects.equals(fechaPrestamo, prestamo.fechaPrestamo) && Objects.equals(fechaDevolucion, prestamo.fechaDevolucion) && Objects.equals(detallePrestamo, prestamo.detallePrestamo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, estudiante, bibliotecario, fechaPrestamo, fechaDevolucion, detallePrestamo);
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "codigo='" + codigo + '\'' +
                ", estudiante=" + estudiante +
                ", bibliotecario=" + bibliotecario +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                ", detallePrestamo=" + detallePrestamo +
                '}';
    }
}
