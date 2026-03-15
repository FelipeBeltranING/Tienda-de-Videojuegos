package usecases.ports;

import java.util.List;
import entities.Producto;

public interface ProductoRepository {
    void save(Producto producto);
    Producto findById(int id);
    List<Producto> findAll();
}
