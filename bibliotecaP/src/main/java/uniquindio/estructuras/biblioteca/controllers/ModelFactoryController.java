package uniquindio.estructuras.biblioteca.controllers;

import uniquindio.estructuras.biblioteca.model.Biblioteca;
import uniquindio.estructuras.biblioteca.model.Bibliotecario;

public class ModelFactoryController {
    public Biblioteca biblioteca = null;
    public static ModelFactoryController instance;
    public Bibliotecario usuario = null;

    private ModelFactoryController() {
        biblioteca = new Biblioteca("Biblioteca de la UQ");
    }

    public static ModelFactoryController getInstance() {
        if (instance == null) {
            instance = new ModelFactoryController();
        }
        return instance;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public Bibliotecario getUsuario() {
        return usuario;
    }
    public void setUsuario(Bibliotecario usuario) {
        this.usuario = usuario;
    }
}
