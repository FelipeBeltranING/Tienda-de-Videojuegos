package entities;

public class Videojuego extends Producto{
    private final String plataforma;
    private final String genero;

     public Videojuego(int id, String titulo, double precioBase, boolean disponible, int unidades,String plataforma, String genero) {
        super(id, titulo, precioBase, disponible, unidades);
        this.plataforma = plataforma;
        this.genero = genero;
    }

    String getPlataforma(){
        return plataforma;
    }
    String getGenero() {return genero;}

    @Override
    public String toString() {
        return "Videojuego {" +
                "\n  ID: " + getId() +
                "\n  Título: " + getTitulo() +
                "\n  Precio: $" + getPrecioBase() +
                "\n  Plataforma: " + plataforma +
                "\n  Género " + genero +
                "\n  Unidades: " + getUnidades() +
                "\n  Disponible: " + estaDisponible() +
                "\n}";
    }
}
