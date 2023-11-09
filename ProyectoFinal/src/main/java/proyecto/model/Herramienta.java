package proyecto.model;

import java.util.ArrayList;

public class Herramienta {



    private String nombre;
    private static ArrayList<Usuario> listaUsiarios = new ArrayList<>();

    private ArrayList<Tarea> listaTareas = new ArrayList<>();

    public Herramienta(String nombre) {
        super();
        this.nombre = nombre;

        inicializarDatos();
    }

    public Herramienta(){
        super();
    }

    public static boolean existeUsuario(String nombreUsuario) {
        for (Usuario usuario : listaUsiarios) {
            if(usuario.getNombreUsuario().equals(usuario)){
                return true;
            }
        }
        return false;
    }

    private void inicializarDatos() {

        Usuario usuario1 = new Usuario(TipoUsuario.ADMINISTRADOR,"admin","admin");
        usuario1.setNombreUsuario("Miguel");
        usuario1.setContrasenia("Guarin");
        usuario1.setTipoUsuario(TipoUsuario.ADMINISTRADOR);

        listaUsiarios.add(usuario1);

        Usuario usuario2 = new Usuario(TipoUsuario.REGULAR,"vendedor","vendedor");
        usuario2.setNombreUsuario("Juan Esteban");
        usuario2.setContrasenia("Velez");
        usuario2.setTipoUsuario(TipoUsuario.REGULAR);

        listaUsiarios.add(usuario2);
    }

}
