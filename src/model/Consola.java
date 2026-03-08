package model;

public class Consola extends Producto{
    private final String marca;

    public Consola(int id, String titulo, double precioBase, boolean disponible, int unidades, String marca){
        super(id, titulo, precioBase, disponible, unidades);
        this.marca=marca;
    }

    public String getMarca(){
        return marca;
    }

    @Override
    public String toString(){
         return "Consola {" +
                "\n  ID: " + getId() +
                "\n  Título: " + getTitulo() +
                "\n  Precio: $" + getPrecioBase() +
                "\n  Marca: " + marca +
                "\n  Unidades: " + getUnidades() +
                "\n  Disponible: " + estaDisponible() +
                "\n}";
    }

}
