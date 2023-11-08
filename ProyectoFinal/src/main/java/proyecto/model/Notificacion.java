package proyecto.model;

public class Notificacion {

    private MedioNotifiacion medioNotifiacion;

    public Notificacion(MedioNotifiacion medioNotifiacion) {
        this.medioNotifiacion = medioNotifiacion;
    }
    public MedioNotifiacion getMedioNotifiacion() {
        return medioNotifiacion;
    }

    public void setMedioNotifiacion(MedioNotifiacion medioNotifiacion) {
        this.medioNotifiacion = medioNotifiacion;
    }
    @Override
    public String toString() {
        return "Notificacion{" +
                "medioNotifiacion=" + medioNotifiacion +
                '}';
    }
}
