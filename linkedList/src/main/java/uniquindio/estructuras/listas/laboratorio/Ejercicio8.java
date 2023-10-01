package uniquindio.estructuras.listas.laboratorio;

import uniquindio.estructuras.listas.clases.ListaDoble;

public class Ejercicio8 {
    public static void main(String[] args) {
        ListaDoble<Persona> listaPersonas = new ListaDoble<Persona>();

        listaPersonas.agregarfinal(new Persona("Juan","1234","dir1"));
        listaPersonas.agregarfinal(new Persona("Maria","12345","dir2"));
        listaPersonas.agregarfinal(new Persona("Jose","123456", "dir3"));
        listaPersonas.agregarfinal(new Persona("Roberto","1234567","dir4"));
        listaPersonas.agregarfinal(new Persona("Pablo","12345678","dir5"));
        listaPersonas.agregarfinal(new Persona("Luis","123456789","dir6"));

        ListaDoble<Persona> resultado = obtenerPersonasConCedulaPar(listaPersonas);

        resultado.imprimirLista();
    }

    private static ListaDoble<Persona> obtenerPersonasConCedulaPar(ListaDoble<Persona> listaPersonas) {
        ListaDoble<Persona> resultado = new ListaDoble<Persona>();
        for (int i = 0; i< listaPersonas.getTamanio();i++) {
            Persona persona = listaPersonas.obtenerValorNodo(i);
            if(persona.getCedula().length() %2 == 0)
                resultado.agregarfinal(persona);
        }
        return resultado;
    }


}
