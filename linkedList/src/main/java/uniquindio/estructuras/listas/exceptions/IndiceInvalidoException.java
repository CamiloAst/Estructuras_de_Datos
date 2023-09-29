package uniquindio.estructuras.listas.exceptions;

import javax.swing.*;

public class IndiceInvalidoException extends Throwable {
    public IndiceInvalidoException() {
        super("El indice no es valido para el tamaño de la lista");

    }
}
