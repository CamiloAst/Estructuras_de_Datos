package proyecto.model;
import javafx.scene.control.Alert;
import proyecto.exceptions.ActivityAlreadyExistException;
import proyecto.exceptions.ActivityDontExist;
import proyecto.utils.ActivityList;
import proyecto.utils.ShowMessage;

import java.util.LinkedList;
import java.util.Objects;

public class Proceso {

    private String nombre;

    private String id;

    private int tiempoDuracionMin;

    private int tiempoDuracionMax;

    private ActivityList<Actividad> listaActividades;


    public Proceso(String nombre, String id, int tiempoDuracionMin, int tiempoDuracionMax) {
        this.nombre = nombre;
        this.id = id;
        this.tiempoDuracionMin = tiempoDuracionMin;
        this.tiempoDuracionMax = tiempoDuracionMax;
        listaActividades = new ActivityList<>();
    }
    public Proceso(String nombre, String id) {
        super();
        this.nombre = nombre;
        this.id = id;
    }


    //----------------------------------------------------------------------------------------
    // Metodos Lista Actividades
    public void agregarActividad(Actividad actividad) throws ActivityAlreadyExistException {
        if(!listaActividades.contains(actividad)){
            listaActividades.add(actividad);
        }else {
            try {
                throw new ActivityAlreadyExistException();
            } catch (ActivityAlreadyExistException e) {
                ShowMessage.mostrarMensaje("Error", "Error al agregar actividad", "La actividad ya existe");
            }
        }
    }

    public void agregarActividad(Actividad actividad, String nombreActividadAnterior){
        if(!listaActividades.contains(actividad)){
            try {
                listaActividades.add(actividad, buscarActividadPorNombre(nombreActividadAnterior));
            } catch (ActivityDontExist e) {
                ShowMessage.mostrarMensaje("Error", "Error al agregar actividad", "La actividad anterior no existe");
            } catch (ActivityAlreadyExistException e) {
                ShowMessage.mostrarMensaje("Error", "Error al agregar actividad", "La actividad ya existe");
            }
        }else {
            try {
                throw new ActivityAlreadyExistException();
            } catch (ActivityAlreadyExistException e) {
                ShowMessage.mostrarMensaje("Error", "Error al agregar actividad", "La actividad ya existe");
            }
        }
    }

    private Actividad buscarActividadPorNombre(String nombreActividadAnterior) {
        for (Actividad actividad : listaActividades) {
            if(actividad.getNombre().equals(nombreActividadAnterior)){
                return actividad;
            }
        }
        return null;
    }


    //----------------------------------------------------------------------------------------
    // Getters y Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTiempoDuracionMin(int tiempoDuracionMin) {
        this.tiempoDuracionMin = tiempoDuracionMin;
    }

    public void setTiempoDuracionMax(int tiempoDuracionMax) {
        this.tiempoDuracionMax = tiempoDuracionMax;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public int getTiempoDuracionMin() {
        return tiempoDuracionMin;
    }

    public int getTiempoDuracionMax() {
        return tiempoDuracionMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proceso proceso = (Proceso) o;
        return tiempoDuracionMin == proceso.tiempoDuracionMin && tiempoDuracionMax == proceso.tiempoDuracionMax && Objects.equals(nombre, proceso.nombre) && Objects.equals(id, proceso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, id, tiempoDuracionMin, tiempoDuracionMax);
    }

    @Override
    public String toString() {
        return "Proceso{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", tiempoDuracionMin=" + tiempoDuracionMin +
                ", tiempoDuracionMax=" + tiempoDuracionMax +
                '}';
    }
}
