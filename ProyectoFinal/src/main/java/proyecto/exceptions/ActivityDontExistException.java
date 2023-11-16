package proyecto.exceptions;

public class ActivityDontExistException extends Exception{
    public ActivityDontExistException() {
        super("La actividad no existe");
    }
}
