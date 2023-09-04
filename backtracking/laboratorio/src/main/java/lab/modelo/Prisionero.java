package lab.modelo;

public class Prisionero {
    private String nombre;
    private String apellido;
    private String estado;
    private String codigo;

    public Prisionero(String nombre, String apellido, String estado, String codigo) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
