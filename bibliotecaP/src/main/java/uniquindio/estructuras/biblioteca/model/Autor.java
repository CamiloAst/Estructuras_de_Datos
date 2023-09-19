package uniquindio.estructuras.biblioteca.model;

public class Autor {


    private String nombre;
    private String apellidos;
    private String identificacion;


    public Autor(String nombre, String apellidos,String identificacion) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
        return result;
    }



    public String getIdentificacion() {
        return identificacion;
    }


    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }


    public String getApellidos() {
        return apellidos;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    @Override
    public String toString() {
        return "Autor [nombre=" + nombre + ", apellidos=" + apellidos + ", identificacion=" + identificacion + "]";
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Autor other = (Autor) obj;
        if (identificacion == null) {
            if (other.identificacion != null)
                return false;
        } else if (!identificacion.equals(other.identificacion))
            return false;
        return true;
    }


}
