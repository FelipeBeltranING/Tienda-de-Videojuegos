package usecases.ports;

import java.util.List;
import entities.Cliente;

public interface ClienteRepository {
    public interface ProductoRepository {
    void save(Cliente transaccion);
    Cliente findById(int id);
    List<Cliente> findAll();
}
}