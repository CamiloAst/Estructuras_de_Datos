package uniquindio.estructuras.biblioteca.model;

public class DetallePrestamo {

    private int cantidad;
    private String codigo;
    private Libro libro;
    private final int subTotal;

    public DetallePrestamo(int cantidad, String codigo,Libro libro, int subTotal) {
        super();
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.subTotal = subTotal;
        this.libro = libro;
    }
    public DetallePrestamo(){
        super();
        this.subTotal = 1000;
    }
    public Libro getLibro() {
        return libro;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "DetallePrestamo [cantidad=" + cantidad + ", subTotal=" + subTotal + ", codigo=" + codigo
                + ", libro=" + libro;
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
        DetallePrestamo other = (DetallePrestamo) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }


}
