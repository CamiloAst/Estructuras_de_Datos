package proyecto.exceptions;

public class IncompleteDataException extends Exception{
    public IncompleteDataException(){
        super("Datos incompletos");
    }
}
