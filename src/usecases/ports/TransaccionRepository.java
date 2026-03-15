package usecases.ports;

import java.util.List;

import entities.Transaccion;

public interface TransaccionRepository {
    public interface ProductoRepository {
    void save(Transaccion transaccion);
    Transaccion findById(int id);
    List<Transaccion> findAll();
}
}
