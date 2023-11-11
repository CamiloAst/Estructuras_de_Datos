package proyecto.exceptions;

public class UserDoesntExistException extends Exception {
    public UserDoesntExistException() {
        super("El usuario no existe");
    }
}
