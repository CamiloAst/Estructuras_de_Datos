package uniquindio.estructuras.biblioteca.exceptions;

import javax.swing.*;

public class UsuarioNoEncontradoException extends Throwable {
    public UsuarioNoEncontradoException(String usuarioNoEncontrado) {
        super(usuarioNoEncontrado);
        JOptionPane.showMessageDialog(null, usuarioNoEncontrado);
    }
}
