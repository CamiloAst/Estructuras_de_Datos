package proyecto.exceptions;

public class ActivityDontExist extends Exception{
    public ActivityDontExist() {
        super("La actividad no existe");
    }
}
