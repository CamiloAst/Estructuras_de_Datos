package uniquindio.estructuras.biblioteca.model;

import java.util.Objects;

public class Bibliotecario {

    private String nombre;
    private String correo;
    private String cedula;
    private String direccion;
    private double salario;

    public Bibliotecario(String nombre, String correo, String cedula, String direccion, double salario) {
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.direccion = direccion;
        this.salario = salario;
    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bibliotecario that = (Bibliotecario) o;
        return Double.compare(salario, that.salario) == 0 && Objects.equals(nombre, that.nombre) && Objects.equals(correo, that.correo) && Objects.equals(cedula, that.cedula) && Objects.equals(direccion, that.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, correo, cedula, direccion, salario);
    }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", salario=" + salario +
                '}';
    }
}
