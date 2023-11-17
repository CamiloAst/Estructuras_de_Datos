package proyecto.controllers;

import proyecto.model.Actividad;
import proyecto.model.Herramienta;
import proyecto.model.Proceso;
import proyecto.model.Usuario;

public enum AppController {
    INSTANCE;
    private final Herramienta herramienta;

    AppController() {
        herramienta = new Herramienta("ADAN");
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }
    public void setProcesoActual(Proceso proceso){
        herramienta.setProcesoActual(proceso);
    }
    public void setActividadActual(Actividad actividad){
        herramienta.setActividadActual(actividad);
    }
    public Proceso getProcesoActual(){
        return herramienta.getProcesoActual();
    }
    public Actividad getActividadActual(){
        return herramienta.getActividadActual();
    }

}
