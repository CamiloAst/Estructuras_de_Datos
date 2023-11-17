package proyecto.model;

import proyecto.exceptions.ProcessAlreadyExist;
import proyecto.exceptions.UserAlreadyExistException;
import proyecto.exceptions.UserDoesntExistException;
import proyecto.utils.ShowMessage;

import java.util.ArrayList;

public class Herramienta {

    private String nombre;
    private final ArrayList<Usuario> userList = new ArrayList<>();

    private final ArrayList<Proceso> processList = new ArrayList<>();


    public Herramienta(String nombre) {
        super();
        this.nombre = nombre;

        inicializarDatos();
    }

    public Herramienta(){
        super();
        inicializarDatos();
    }


    public boolean userExist(String nombreUsuario) {
        for (Usuario usuario : userList) {
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                return true;
            }
        }
        return false;
    }

    public Usuario searchUser(String nombreUsuario) throws UserDoesntExistException {
        for (Usuario usuario : userList) {
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                return usuario;
            }
        }
        throw new UserDoesntExistException();
    }
    public void addUser(Usuario usuario) throws UserAlreadyExistException {
        if(!userExist(usuario.getNombreUsuario())){
            userList.add(usuario);
        }else
            throw new UserAlreadyExistException();
    }
    public void createUser(String nombreUsuario, String contrasenia, TipoUsuario tipoUsuario){
        try {
            addUser(new Usuario(tipoUsuario, nombreUsuario, contrasenia));
        } catch (UserAlreadyExistException e) {
            ShowMessage.mostrarMensaje("Error", "Error al crear usuario", "El usuario ya existe");
        }
    }
    public boolean delete(Usuario usuario){
        return userList.remove(usuario);
    }

    public boolean deleteUser(String nombre) throws UserDoesntExistException {
        if(userExist(nombre))
            return delete(searchUser(nombre));
        else
            throw new UserDoesntExistException();
    }

    public void addProcess(Proceso proceso){
        if(!processList.contains(proceso))
            processList.add(proceso);
        else
            try{
                throw new ProcessAlreadyExist();
            } catch (Exception e) {
                ShowMessage.mostrarMensaje("Error", "Error al agregar proceso", "El proceso ya existe");
            }
    }
    public Proceso searchProcess(String nombre){
        for (Proceso proceso : processList) {
            if(proceso.getNombre().equals(nombre)){
                return proceso;
            }
        }
        return null;
    }
    public void createProcess(String nombre, String id, int tiempoDuracionMin, int tiempoDuracionMax){
        addProcess(new Proceso(nombre, id, tiempoDuracionMin, tiempoDuracionMax));
    }
    public void delete(Proceso proceso){
        processList.remove(proceso);
    }

    public void deleteProcess(String nombre){
        for (Proceso proceso : processList) {
            if(proceso.getNombre().equals(nombre)){
                delete(proceso);
                return;
            }
        }
    }
    public boolean isAdmin(String name){
        for (Usuario usuario : userList) {
            if(usuario.getNombreUsuario().equals(name)){
                return usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR);
            }
        }
        return false;
    }
    private void inicializarDatos() {

        Usuario usuario1 = new Usuario();
        usuario1.setNombreUsuario("Miguel");
        usuario1.setContrasenia("Guarin");
        usuario1.setTipoUsuario(TipoUsuario.ADMINISTRADOR);

        userList.add(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setNombreUsuario("Juan ");
        usuario2.setContrasenia("Velez");
        usuario2.setTipoUsuario(TipoUsuario.REGULAR);

        userList.add(usuario2);
    }

    public boolean verificarPermisos(String nombreUsuario){
        for (Usuario usuario : userList) {
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                return usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR);
            }
        }
        return false;
    }
    public ArrayList<Proceso> getListaProcesos() {
        return processList;
    }
    public ArrayList<Usuario> getListaUsiarios() {
        return userList;
    }


    public void updatePassword(String nombreUsuario, String nuevaContrasenia) throws UserDoesntExistException {
        if(userExist(nombreUsuario)){
            searchUser(nombreUsuario).setContrasenia(nuevaContrasenia);
        }else
            throw new UserDoesntExistException();
    }
}
