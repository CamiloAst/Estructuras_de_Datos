package proyecto.controllers;

import proyecto.model.Actividad;
import proyecto.model.Herramienta;
import proyecto.model.Proceso;
import proyecto.model.Usuario;

public enum AppController {
    INSTANCE();
    private final Herramienta herramienta;
    private Usuario usuario;
    private Proceso proceso;
    private Actividad actividad;

    AppController() {
        this.actividad = null;
        this.proceso = null;
        this.usuario = null;
        herramienta = new Herramienta("ADAN");
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }
    public void setProcesoActual(Proceso proceso){
        this.proceso = proceso;
    }
    public Proceso getProcesoActual(){
        return proceso;
    }
    public void setActividadActual(Actividad actividad){
        this.actividad = actividad;
    }
    public Actividad getActividadActual(){
        return actividad;
    }
    public void setUsuarioActual(Usuario usuario){
        this.usuario = usuario;
    }
    public Usuario getUsuarioActual(){
        return usuario;
    }


}
