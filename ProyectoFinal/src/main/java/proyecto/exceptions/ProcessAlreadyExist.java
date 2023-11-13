package proyecto.exceptions;

public class ProcessAlreadyExist extends Exception {
    public ProcessAlreadyExist() {
        super("El proceso ya existe");
    }

}
