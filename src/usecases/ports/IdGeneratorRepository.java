package usecases.ports;

public interface IdGeneratorRepository {
    String nextId(char typeId);
}
