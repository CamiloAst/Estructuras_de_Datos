package uniquindio.estructuras.biblioteca.model;

public class Estudiante {

    private String nombre;
    private String telefono;
    private String cedula;
    private String correo;
    private Prestamo prestamo;





    public Estudiante(String nombre, String telefono, String cedula, String correo) {
        super();
        this.nombre = nombre;
        this.telefono = telefono;
        this.cedula = cedula;
        this.correo = correo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }




    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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


    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", telefono=" + telefono + ", cedula=" + cedula + ", correo=" + correo
                + ", prestamo=" + prestamo +  "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estudiante other = (Estudiante) obj;
        if (cedula == null) {
            if (other.cedula != null)
                return false;
        } else if (!cedula.equals(other.cedula))
            return false;
        return true;
    }


}
