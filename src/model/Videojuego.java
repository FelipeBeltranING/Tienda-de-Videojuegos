package model;

public class Videojuego extends Producto{
    private final String plataforma;

     public Videojuego(int id, String titulo, double precioBase, boolean disponible, int unidades,String plataforma) {
        super(id, titulo, precioBase, disponible, unidades);
        this.plataforma = plataforma;
    }

    String getPlataforma(){
        return plataforma;
    }

    @Override
    public String toString() {
        return "Videojuego {" +
                "\n  ID: " + getId() +
                "\n  Título: " + getTitulo() +
                "\n  Precio: $" + getPrecioBase() +
                "\n  Plataforma: " + plataforma +
                "\n  Unidades: " + getUnidades() +
                "\n  Disponible: " + estaDisponible() +
                "\n}";
    }
}
