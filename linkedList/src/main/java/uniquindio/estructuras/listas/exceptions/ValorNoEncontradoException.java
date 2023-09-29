package uniquindio.estructuras.listas.exceptions;

public class ValorNoEncontradoException extends Throwable {
    public ValorNoEncontradoException(){
        super("No se encontró el valor en la lista");
    }
}
