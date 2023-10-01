package uniquindio.estructuras.listas.laboratorio;

import uniquindio.estructuras.listas.clases.ListaSimple;

public class Ejercicio2 {
    public static void main(String[] args) {
        ListaSimple<Persona> listaPersonas = new ListaSimple<Persona>();

        listaPersonas.agregarNodo(new Persona("Juan","1234","dir1"));
        listaPersonas.agregarNodo(new Persona("Maria","12345","dir2"));
        listaPersonas.agregarNodo(new Persona("Jose","123456", "dir3"));
        listaPersonas.agregarNodo(new Persona("Roberto","1234567","dir4"));
        listaPersonas.agregarNodo(new Persona("Pablo","12345678","dir5"));
        listaPersonas.agregarNodo(new Persona("Luis","123456789","dir6"));

        ListaSimple<Persona> resultado = obtenerPersonasConCedulaImpar(listaPersonas);

        System.out.println("Lisa de personas con cedula impar:");
        resultado.imprimirLista();
    }

    private static ListaSimple<Persona> obtenerPersonasConCedulaImpar(ListaSimple<Persona> listaPersonas) {
        ListaSimple<Persona> resultado = new ListaSimple<Persona>();
        for (int i = 0; i< listaPersonas.getSize();i++) {
            Persona persona = listaPersonas.obtenerValorNodo(i);
            if(persona.getCedula().length() %2 != 0)
                resultado.agregarNodo(persona);
        }
        return resultado;
    }


}
class Persona {
    private String nombre;
    private String cedula;
    private String direccion;

    public Persona(String cedula) {
        super();
        this.cedula = cedula;
    }

    public Persona(String nombre, String cedula, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
