package lab.modelo;

public class Prisionero {
    private String nombre;
    private String apellido;
    private Boolean estado;
    private String codigo;

    public Prisionero(String nombre, String apellido, Boolean estado, String codigo) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.codigo = codigo;
    }
    public Prisionero() {
        super();
    }
    public Prisionero(String nombre, String apellido, Boolean estado) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }
    public Prisionero(String nombre, String apellido) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Prisionero(String nombre) {
        super();
        this.nombre = nombre;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
