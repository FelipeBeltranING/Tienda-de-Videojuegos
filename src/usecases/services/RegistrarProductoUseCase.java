package usecases.services;

import entities.Consola;
import entities.Videojuego;
import infraestructure.services.IdGenerator;

public class RegistrarProductoUseCase {

    private final ProductoRepository productoRepository;
    private final IdGenerator idGenerator;

    public void RegistrarProducto(ProductoRepository productoRepository, IdGenerator idGenerator){
        this.productoRepository = productoRepository;
        this.idGenerator = idGenerator;
    }

    public Consola ejecutar( String titulo, double precioBase, boolean disponible, int unidades, String marca) {
        Consola consola = new Libro(idGenerator.nextId('C'),titulo, precioBase, disponible,unidades, marca);
        ProductoRepository.save(consola);
        return consola;
    }

    public Videojuego ejecutar( String titulo, double precioBase, boolean disponible, int unidades,String plataforma, String genero) {
        Videojuego videojuego = new Videojuego(idGenerator.nextId('V'), titulo,precioBase, disponible, unidades,plataforma, genero);
        ProductoRepository.save(videojuego);
        return videojuego;
    }
}
