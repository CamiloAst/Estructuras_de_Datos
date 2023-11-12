package proyecto.model;

import javafx.scene.control.Alert;
import proyecto.exceptions.UserAlreadyExistException;
import proyecto.exceptions.UserDoesntExistException;

import java.util.ArrayList;

public class Herramienta {

    private String nombre;
    private static ArrayList<Usuario> listaUsiarios = new ArrayList<>();

    private ArrayList<Proceso> listaProcesos = new ArrayList<>();

    public Herramienta(String nombre) {
        super();
        this.nombre = nombre;

        inicializarDatos();
    }

    public Herramienta(){
        super();
    }

    public boolean existeUsuario(String nombreUsuario) {
        for (Usuario usuario : listaUsiarios) {
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                return true;
            }
        }
        return false;
    }

    public Usuario buscarUsuario(String nombreUsuario) throws UserDoesntExistException {
        for (Usuario usuario : listaUsiarios) {
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                return usuario;
            }
        }
        throw new UserDoesntExistException();
    }
    public void agregarUsuario(Usuario usuario) throws UserAlreadyExistException {
        if(!existeUsuario(usuario.getNombreUsuario())){
            listaUsiarios.add(usuario);
        }else
            throw new UserAlreadyExistException();
    }
    public boolean eliminarUsuario(Usuario usuario){
        return listaUsiarios.remove(usuario);
    }

    public boolean eliminarUsuarioNombre(String nombre) throws UserDoesntExistException {
        return eliminarUsuario(buscarUsuario(nombre));
    }

    public void agregarProceso(Proceso proceso){
        listaProcesos.add(proceso);
    }
    public boolean eliminarProceso(Proceso proceso){
        return listaProcesos.remove(proceso);
    }

    private void inicializarDatos() {

        Usuario usuario1 = new Usuario();
        usuario1.setNombreUsuario("Miguel");
        usuario1.setContrasenia("Guarin");
        usuario1.setTipoUsuario(TipoUsuario.ADMINISTRADOR);

        listaUsiarios.add(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setNombreUsuario("Juan Esteban");
        usuario2.setContrasenia("Velez");
        usuario2.setTipoUsuario(TipoUsuario.REGULAR);

        listaUsiarios.add(usuario2);
    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    public ArrayList<Usuario> getListaUsiarios() {
        return listaUsiarios;
    }
}
