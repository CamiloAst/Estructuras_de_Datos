package proyecto.model;

import proyecto.utils.TaskQueue;

import java.util.Objects;

public class Actividad {

    private String nombre;
    private String descripcion;
    private Boolean isObligatoria;
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

    public void setNoObligatoria(Boolean isObligatoria) {
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
