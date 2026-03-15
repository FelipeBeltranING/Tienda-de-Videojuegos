package usecases.services;

import entities.Cliente;

public class RegistrarCliente {

    private final ClienteRepository clienteRepository;
    private final IdGenerator idGenerator;

    public RegistrarUsuarioUseCase(ClienteRepository clienteRepository, IdGenerator idGenerator) {
        this.clienteRepository = clienteRepository;
        this.idGenerator = idGenerator;
    }

    public Cliente ejecutar(String nombre, String email) {
        Cliente cliente = new Cliente(idGenerator.nextId('U'), nombre, email);
        clienteRepository.save(cliente);
        return cliente;
    }

}
