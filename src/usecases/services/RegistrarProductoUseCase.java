package usecases.services;

import entities.Consola;
import entities.Videojuego;
import usecases.ports.IdGeneratorRepository;

public class RegistrarProductoUseCase {

    private final ProductoRepository productoRepository;
    private final IdGeneratorRepository idGeneratorRepository;

    public RegistrarProductoUseCase(ProductoRepository productoRepository, IdGeneratorRepository idGeneratorRepository){
        this.productoRepository = productoRepository;
        this.idGeneratorRepository = idGeneratorRepository;
    }

    public Consola ejecutar( String titulo, double precioBase, boolean disponible, int unidades, String marca) {
        Consola consola = new Consola(idGeneratorRepository.nextId('C'),titulo, precioBase, disponible,unidades, marca);
        ProductoRepository.save(consola);
        return consola;
    }

    public Videojuego ejecutar( String titulo, double precioBase, boolean disponible, int unidades,String plataforma, String genero) {
        Videojuego videojuego = new Videojuego(idGeneratorRepository.nextId('V'), titulo,precioBase, disponible, unidades,plataforma, genero);
        ProductoRepository.save(videojuego);
        return videojuego;
    }
}
