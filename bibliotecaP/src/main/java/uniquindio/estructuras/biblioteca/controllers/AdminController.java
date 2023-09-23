package uniquindio.estructuras.biblioteca.controllers;

import uniquindio.estructuras.biblioteca.model.Biblioteca;

public class AdminController {

    static Biblioteca biblioteca = null;

    public static void iniciarDatos(){

        biblioteca.crearEstudiante("Gerente","Juan","Perez","123");
        biblioteca.crearBibliotecario("Pepe","López","321","casa2",1234567);
    }


}
