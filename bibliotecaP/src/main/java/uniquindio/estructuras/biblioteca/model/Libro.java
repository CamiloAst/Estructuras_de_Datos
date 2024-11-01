package uniquindio.estructuras.biblioteca.model;

public class Libro extends TextoLiterario{

    private String isbn;
    private Autor autor;



    public Libro(String titulo,Autor autor, String editorial, String codigo,String estado, int unidadesDisponibles,
                 String idioma, int numeroPaginas, int anio, String isbn) {
        super();
        this.isbn = isbn;
        this.autor = autor;
        this.setTitulo(titulo);
        this.setEditorial(editorial);
        this.setCodigo(codigo);
        this.setEstado(estado);
        this.setUnidadesDisponibles(unidadesDisponibles);
        this.setIdioma(idioma);
        this.setNumeroPaginas(numeroPaginas);
        this.setAnio(anio);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }


    @Override
    public String toString() {
        return "autor=" + autor + ", Isbn()=" + getIsbn()
                + ", Titulo()=" + getTitulo() + ", Editorial()=" + getEditorial() + ", Estado()=" + getEstado()
                + ", UnidadesDisponibles()=" + getUnidadesDisponibles() + ", Codigo()=" + getCodigo() + ", Idioma()=" + getIdioma() + ", NumeroPaginas()="
                + getNumeroPaginas() + ", Anio=" + getAnio() + "]";
    }



}
