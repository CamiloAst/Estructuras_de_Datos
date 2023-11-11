package proyecto.exceptions;

public class ActivityAlreadyExistException extends Exception{

        public ActivityAlreadyExistException(){
            super("La actividad ya existe");
        }
}
