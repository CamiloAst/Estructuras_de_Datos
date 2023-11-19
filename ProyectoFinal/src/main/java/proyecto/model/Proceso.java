package proyecto.model;
import proyecto.exceptions.ActivityAlreadyExistException;
import proyecto.exceptions.ActivityDontExistException;
import proyecto.utils.ActivityList;
import proyecto.utils.ShowMessage;

import java.util.Objects;

public class Proceso {

    private String nombre;

    private String id;

    private int tiempoDuracionMin;

    private int tiempoDuracionMax;

    private ActivityList<Actividad> listaActividades;


    public Proceso(String nombre, String id) {
        super();
        this.nombre = nombre;
        this.id = id;
        listaActividades = new ActivityList<>();
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
        calcularTiempos();
    }

    public void agregarActividad(Actividad actividad, String nombreActividadAnterior){
        if(!listaActividades.contains(actividad)){
            try {
                listaActividades.add(actividad, buscarActividadPorNombre(nombreActividadAnterior));
            } catch (ActivityDontExistException e) {
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
        calcularTiempos();
    }

    public Actividad buscarActividadPorNombre(String nombreActividadAnterior) {
        for (Actividad actividad : listaActividades) {
            if(actividad.getNombre().equals(nombreActividadAnterior)){
                return actividad;
            }
        }
        return null;
    }
    public void eliminarActividad(Actividad actividad) throws ActivityDontExistException {
        listaActividades.remove(actividad);
        calcularTiempos();
    }

    public void eliminarActividad(String nombreActividad) throws ActivityDontExistException {
        listaActividades.remove(buscarActividadPorNombre(nombreActividad));
        calcularTiempos();
    }

    public int calcularTiempoMin(){
        int tiempoTotal = 0;
        for (Actividad actividad : listaActividades) {
            tiempoTotal += actividad.obtenerTiempoMin();
        }
        return tiempoTotal;
    }
    public int calcularTiempoTotal(){
        int tiempoTotal = 0;
        for (Actividad actividad : listaActividades) {
            tiempoTotal += actividad.obtenerTiempoTotal();
        }
        return tiempoTotal;
    }

    public void actualizarActividad(String nombre, String descripcion) {
        Actividad actividad = buscarActividadPorNombre(nombre);
        if(actividad != null){
            actividad.setDescripcion(descripcion);
        }
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

    public ActivityList<Actividad> getListaActividades() {
        return listaActividades;
    }

    public void calcularTiempos(){
        tiempoDuracionMin = calcularTiempoMin();
        tiempoDuracionMax = calcularTiempoTotal();
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
