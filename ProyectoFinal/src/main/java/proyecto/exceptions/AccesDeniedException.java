package proyecto.exceptions;

public class AccesDeniedException extends Exception{
    public AccesDeniedException() {
        super("Usuario no cuenta con permisos suficientes para realizar esta acción");
    }
}
