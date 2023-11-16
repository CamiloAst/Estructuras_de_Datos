package proyecto.exceptions;

public class TaskAlreadyExistException extends Exception{
    public TaskAlreadyExistException() {
        super("La tarea ya existe");
    }
}
