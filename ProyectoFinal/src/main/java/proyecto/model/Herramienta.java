package proyecto.model;

import javafx.scene.control.Alert;
import proyecto.exceptions.ProcessAlreadyExist;
import proyecto.exceptions.UserAlreadyExistException;
import proyecto.exceptions.UserDoesntExistException;
import proyecto.utils.ShowMessage;

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
        if(!listaProcesos.contains(proceso))
            listaProcesos.add(proceso);
        else
            try{
                throw new ProcessAlreadyExist();
            } catch (Exception e) {
                ShowMessage.mostrarMensaje("Error", "Error al agregar proceso", "El proceso ya existe");
            }
    }
    public boolean eliminarProceso(Proceso proceso){
        return listaProcesos.remove(proceso);
    }

    public boolean eliminarProcesoNombre(String nombre){
        for (Proceso proceso : listaProcesos) {
            if(proceso.getNombre().equals(nombre)){
                return eliminarProceso(proceso);
            }
        }
        return false;
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



    public ArrayList<Usuario> getListaUsiarios() {
        return listaUsiarios;
    }
}
