package usecases.services;
import usecases.ports.IdGeneratorRepository;
import entities.Cliente;

public class RegistrarClienteUseCase {

    private final ClienteRepository clienteRepository;
    private final IdGeneratorRepository idGeneratorRepository;

    public RegistrarClienteUseCase(ClienteRepository clienteRepository, IdGeneratorRepository idGeneratorRepository) {
        this.clienteRepository = clienteRepository;
        this.idGeneratorRepository = idGeneratorRepository;
    }

    public Cliente ejecutar(String nombre, String email) {
        Cliente cliente = new Cliente(idGeneratorRepository.nextId('U'), nombre, email);
        clienteRepository.save(cliente);
        return cliente;
    }

}
