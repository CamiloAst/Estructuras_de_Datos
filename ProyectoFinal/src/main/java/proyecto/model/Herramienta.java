package proyecto.model;

import proyecto.exceptions.ActivityAlreadyExistException;
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
    public void createProcess(String nombre, String id){
        addProcess(new Proceso(nombre, id));
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
        usuario2.setNombreUsuario("Juan");
        usuario2.setContrasenia("Velez");
        usuario2.setTipoUsuario(TipoUsuario.REGULAR);

        userList.add(usuario2);

        //---------------------------------

        Tarea tarea1 = new Tarea("tarea 1", "descripcion tarea 1", true, 20);
        Tarea tarea2 = new Tarea("tarea 2", "descripcion tarea 2", false, 20);
        Tarea tarea3 = new Tarea("tarea 3", "descripcion tarea 3", true, 20);
        Tarea tarea4 = new Tarea("tarea 4", "descripcion tarea 4", false, 20);
        Tarea tarea5 = new Tarea("tarea 5", "descripcion tarea 5", true, 20);
        Tarea tarea6 = new Tarea("tarea 6", "descripcion tarea 6", false, 20);
        Tarea tarea7 = new Tarea("tarea 7", "descripcion tarea 7", true, 20);
        Tarea tarea8 = new Tarea("tarea 8", "descripcion tarea 8", false, 20);
        Tarea tarea9 = new Tarea("tarea 9", "descripcion tarea 9", true, 20);



        //-------------------------------------
        Actividad actividad1 = new Actividad("actividad 1", "descripcion actividad 1", true);
        Actividad actividad2 = new Actividad("actividad 2", "descripcion actividad 2", true);
        Actividad actividad3 = new Actividad("actividad 3", "descripcion actividad 3", true);

        try {
            actividad1.crearTarea(tarea1);
            actividad1.crearTarea(tarea2);
            actividad1.crearTarea(tarea3);
            actividad2.crearTarea(tarea4);
            actividad2.crearTarea(tarea5);
            actividad2.crearTarea(tarea6);
            actividad3.crearTarea(tarea7);
            actividad3.crearTarea(tarea8);
            actividad3.crearTarea(tarea9);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //-----------------------------------------
        Proceso proceso1 = new Proceso("proceso 1", processList.size()+"");
        processList.add(proceso1);
        Proceso proceso2 = new Proceso("proceso 2", processList.size()+"");
        processList.add(proceso2);
        try {
            proceso1.agregarActividad(actividad2);
            proceso1.agregarActividad(actividad1);
            proceso2.agregarActividad(actividad3);
        } catch (ActivityAlreadyExistException e) {
            throw new RuntimeException(e);
        }
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
