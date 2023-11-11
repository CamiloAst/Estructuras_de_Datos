package proyecto.model;
import java.util.LinkedList;
import java.util.Objects;

public class Proceso {

    private String nombre;

    private String id;

    private int tiempoDuracionMin;

    private int tiempoDuracionMax;

    private LinkedList<Actividad> listaActividades = new LinkedList<>();


    public Proceso(String nombre, String id, int tiempoDuracionMin, int tiempoDuracionMax) {
        this.nombre = nombre;
        this.id = id;
        this.tiempoDuracionMin = tiempoDuracionMin;
        this.tiempoDuracionMax = tiempoDuracionMax;
    }
    public Proceso(String nombre, String id) {
        super();
        this.nombre = nombre;
        this.id = id;
    }
    //----------------------------------------------------------------------------------------
    // Metodos Lista Actividades
    public void eliminarActividad(Actividad actividad){
        listaActividades.remove(actividad);
    }
    public void agregarActividad(Actividad actividad){
        listaActividades.add(actividad);
    }
    public void agregarActividad(Actividad actividad, int index){
        listaActividades.add(index, actividad);
    }
    public void eliminarActividad(int index){
        listaActividades.remove(index);
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
