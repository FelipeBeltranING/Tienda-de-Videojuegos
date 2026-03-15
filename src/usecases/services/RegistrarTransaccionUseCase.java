package usecases.services;

import entities.*;
import usecases.ports.IdGeneratorRepository;

public class RegistrarTransaccionUseCase {

    private final TransaccionRepository transaccionRepository;
    private final IdGeneratorRepository idGeneratorRepository;

    public RegistrarTransaccionUseCase(TransaccionRepository transaccionRepository, IdGeneratorRepository idGeneratorRepository){
        this.transaccionRepository = transaccionRepository;
        this.idGeneratorRepository = idGeneratorRepository;
    }

    public Transaccion ejecutar( Cliente cliente, Producto producto, DetalleTransaccion detalleTransaccion) {
        Transaccion transaccion = new Transaccion(idGeneratorRepository.nextId('T'),cliente, producto,detalleTransaccion);
        TransaccionRepository.save(transaccion);
        return transaccion;
    }
}
