package uniquindio.estructuras.biblioteca.exceptions;

import javax.swing.*;

public class CampoVacioException extends Throwable {
    public CampoVacioException(String cadena) {
        super(cadena);
        JOptionPane.showMessageDialog(null, cadena, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
