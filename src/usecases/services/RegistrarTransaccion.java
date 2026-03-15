package usecases.services;

import entities.*;
import infraestructure.services.IdGenerator;

public class RegistrarTransaccion {

    private final TransaccionRepository transaccionRepository;
    private final IdGenerator idGenerator;

    public void transaccionRepository(TransaccionRepository transaccionRepository, IdGenerator idGenerator){
        this.transaccionRepository = transaccionRepository;
        this.idGenerator = idGenerator;
    }

    public Transaccion ejecutar( Cliente cliente, Producto producto, DetalleTransaccion detalleTransaccion) {
        Transaccion transaccion = new Transaccion(idGenerator.nextId('T'),cliente, producto,detalleTransaccion,);
        TransaccionRepository.save(transaccion);
        return transaccion;
    }
}
