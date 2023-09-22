package uniquindio.estructuras.biblioteca.comparadores;

import uniquindio.estructuras.biblioteca.model.Libro;

import java.util.Comparator;

public class CompararLibro implements Comparator<Libro> {
    @Override
    public int compare(Libro o1, Libro o2) {
        int comp = o1.getAutor().getNombre().compareTo(o2.getAutor().getNombre());

        if (comp == 0)
            return o1.getTitulo().compareTo(o2.getTitulo());
        else
            return comp;
    }




}
