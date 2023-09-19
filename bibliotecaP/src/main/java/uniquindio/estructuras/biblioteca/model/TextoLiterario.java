package uniquindio.estructuras.biblioteca.model;

public class TextoLiterario {

    private String titulo;
    private String editorial;
    private String codigo;
    private String estado;
    private int unidadesDisponibles;
    private String idioma;
    private int numeroPaginas;
    private int anio;
    private String fechaPublicacion;

    /**
     * @param titulo
     * @param editorial
     * @param estado
     * @param unidadesDisponibles
     * @param idioma
     * @param numeroPaginas
     * @param anio
     */

    public TextoLiterario(String titulo, String editorial, String codigo, String estado, int unidadesDisponibles, String idioma, int numeroPaginas, int anio) {
        super();
        this.titulo = titulo;
        this.editorial = editorial;
        this.codigo = codigo;
        this.estado = estado;
        this.unidadesDisponibles = unidadesDisponibles;
        this.idioma = idioma;
        this.numeroPaginas = numeroPaginas;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }
    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }


    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }


    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "TextoLiterario [titulo=" + titulo + ", editorial=" + editorial + ", estado=" + estado
                + ", unidadesDisponibles=" + unidadesDisponibles + ", idioma=" + idioma + ", numeroPaginas=" + numeroPaginas + ", anio=" + anio + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TextoLiterario other = (TextoLiterario) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }


}
