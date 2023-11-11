package proyecto.exceptions;

public class UserAlreadyExistException extends Exception{

    public UserAlreadyExistException(){
        super("El usuario ya existe");
    }
}
