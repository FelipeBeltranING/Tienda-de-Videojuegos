package usecases.ports;

import java.util.List;
import entities.Cliente;

public interface ClienteRepository {
    void save(Cliente cliente);
    Cliente findById(int id);
    List<Cliente> findAll();
}