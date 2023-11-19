package proyecto.model;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

public class Usuario {

    private TipoUsuario tipoUsuario;
    private String nombreUsuario;

    private String contrasenia;

    private TipoNotificacion tipoNotificacion;


    public Usuario(TipoUsuario tipoUsuario, String nombreUsuario, String contrasenia) {
        this.tipoUsuario = tipoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }
    public Usuario(){
        super();
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setTipoNotificacion(TipoNotificacion tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return tipoUsuario == usuario.tipoUsuario && Objects.equals(nombreUsuario, usuario.nombreUsuario) && Objects.equals(contrasenia, usuario.contrasenia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoUsuario, nombreUsuario, contrasenia);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "tipoUsuario=" + tipoUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }


}
enum TipoNotificacion{
    CORREO, APLICACION
}
