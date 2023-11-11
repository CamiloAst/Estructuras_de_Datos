package proyecto.controllers;

import proyecto.model.Herramienta;

public enum AppController {
    INSTANCE;
    private final Herramienta herramienta;

    AppController() {
        herramienta = new Herramienta("ADAN");
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }
}
