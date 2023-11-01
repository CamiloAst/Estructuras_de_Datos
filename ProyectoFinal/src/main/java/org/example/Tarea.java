package org.example;

import java.util.Objects;

public class Tarea {

    private String descripcion;

    private Boolean isObigatoria;

    private int tiempoDuracion;

    public Tarea(String descripcion, Boolean isObigatoria, int tiempoDuracion) {
        this.descripcion = descripcion;
        this.isObigatoria = isObigatoria;
        this.tiempoDuracion = tiempoDuracion;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getObigatoria() {
        return isObigatoria;
    }

    public void setObigatoria(Boolean obigatoria) {
        isObigatoria = obigatoria;
    }

    public int getTiempoDuracion() {
        return tiempoDuracion;
    }

    public void setTiempoDuracion(int tiempoDuracion) {
        this.tiempoDuracion = tiempoDuracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return tiempoDuracion == tarea.tiempoDuracion && Objects.equals(descripcion, tarea.descripcion) && Objects.equals(isObigatoria, tarea.isObigatoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, isObigatoria, tiempoDuracion);
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "descripcion='" + descripcion + '\'' +
                ", isObigatoria=" + isObigatoria +
                ", tiempoDuracion=" + tiempoDuracion +
                '}';
    }

}
