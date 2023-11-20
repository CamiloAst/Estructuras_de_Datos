package proyecto.model;

import proyecto.exceptions.TaskAlreadyExistException;
import proyecto.utils.ShowMessage;
import proyecto.utils.TaskQueue;

import java.util.Objects;

import static proyecto.controllers.AppController.INSTANCE;

public class Actividad {

    private String nombre;
    private String descripcion;
    private Boolean isObligatoria;
    private int tiempoDuracion = 0;
    private int tiempoMinimo = 0;
    private TaskQueue<Tarea> listaTareas = new TaskQueue<>();

    public Actividad(String nombre, String descripcion, Boolean isObligatoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.isObligatoria = isObligatoria;
    }
    public Actividad(String nombre){
        super();
        this.nombre = nombre;
        isObligatoria = false;
    }

    public Tarea buscarTareaPorNombre(String nombreTarea){
        for (Tarea tarea : listaTareas) {
            if(tarea.getNombre().equals(nombreTarea)){
                return tarea;
            }
        }
        return null;
    }
    public void crearTarea(String nombre, String descripcion, Boolean isObligatoria,int tiempoDuracion){
        try {
            Tarea tarea = new Tarea(nombre, descripcion, isObligatoria,tiempoDuracion);
            listaTareas.add(tarea);
        } catch (TaskAlreadyExistException e) {
            ShowMessage.mostrarMensaje("Error", "Error al crear tarea", "La tarea ya existe");
        }
        calcularTiempos();
    }
    public void crearTarea(Tarea tarea){
        try {
            listaTareas.add(tarea);
        } catch (TaskAlreadyExistException e) {
            ShowMessage.mostrarMensaje("Error", "Error al crear tarea", "La tarea ya existe");
        }
        calcularTiempos();
    }
    public void completarTarea(String nombreTarea){
        Tarea tarea = buscarTareaPorNombre(nombreTarea);
        if(tarea != null)
            tarea.setComplete();
        calcularTiempos();
    }

    public void eliminarTarea(Tarea tarea){
        listaTareas.remove(listaTareas.searchIndex(tarea));
        calcularTiempos();
    }

    public int obtenerTiempoTotal(){
        int tiempoTotal = 0;
        for (Tarea tarea : listaTareas) {
            tiempoTotal += tarea.getTiempoDuracion();
        }
        return tiempoTotal;
    }
    public int obtenerTiempoMin(){
        int tiempoTotal = 0;
        for (Tarea tarea : listaTareas) {
            if(!tarea.getObigatoria())
                tiempoTotal += tarea.getTiempoDuracion();
        }
        return tiempoTotal;
    }

    private void calcularTiempos(){
        tiempoDuracion = obtenerTiempoTotal();
        tiempoMinimo = obtenerTiempoMin();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Boolean getIsObligatoria() {
        return isObligatoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNoObligatoria() {
        isObligatoria = false;
    }

    public void setObligatoria() {
        isObligatoria = true;
    }

    public TaskQueue<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(TaskQueue<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public int getTiempoDuracion() {
        return tiempoDuracion;
    }

    public int getTiempoMinimo() {
        return tiempoMinimo;
    }

    public void setObligatoria(Boolean obligatoria) {
        isObligatoria = obligatoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actividad actividad = (Actividad) o;
        return Objects.equals(nombre, actividad.nombre) && Objects.equals(descripcion, actividad.descripcion) && Objects.equals(isObligatoria, actividad.isObligatoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, isObligatoria);
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", isObligatoria=" + isObligatoria +
                '}';
    }

}
