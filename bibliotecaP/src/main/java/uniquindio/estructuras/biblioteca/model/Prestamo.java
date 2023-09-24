package uniquindio.estructuras.biblioteca.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Prestamo implements Serializable {
    private String codigo;
    private Estudiante estudiante;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private HashMap<String, DetallePrestamo> detallePrestamo;
    private double total;
    public Prestamo(String codigo, Estudiante estudiante, String fechaPrestamo, String fechaDevolucion, HashMap<String, DetallePrestamo> detallePrestamo) {
        this.codigo = codigo;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.detallePrestamo = detallePrestamo;
    }
    public Prestamo (String codigo, Estudiante estudiante, String fechaPrestamo, String fechaDevolucion){
        super();
        this.codigo = codigo;
        this.estudiante = estudiante;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo() {
        super();
    }

    public double getTotal() {
        total = sumaSubtotales();
        return total;
    }

    private double sumaSubtotales() {
        Iterator<DetallePrestamo> iterator = detallePrestamo.values().iterator();
        double suma = 0;
        while (iterator.hasNext()){
            DetallePrestamo detallePrestamo = iterator.next();
            suma += detallePrestamo.getSubTotal();
        }
        return suma;
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

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Map<String, DetallePrestamo> getDetallePrestamo() {
        return detallePrestamo;
    }

    public void setDetallePrestamo(HashMap<String, DetallePrestamo> detallePrestamo) {
        this.detallePrestamo = detallePrestamo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return Double.compare(total, prestamo.total) == 0 && Objects.equals(codigo, prestamo.codigo) && Objects.equals(estudiante, prestamo.estudiante) && Objects.equals(fechaPrestamo, prestamo.fechaPrestamo) && Objects.equals(fechaDevolucion, prestamo.fechaDevolucion) && Objects.equals(detallePrestamo, prestamo.detallePrestamo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, estudiante, fechaPrestamo, fechaDevolucion, detallePrestamo, total);
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "codigo='" + codigo + '\'' +
                ", estudiante=" + estudiante +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                ", detallePrestamo=" + detallePrestamo +
                '}';
    }
}
