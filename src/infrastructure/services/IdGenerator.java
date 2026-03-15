package infrastructure.services;
import usecases.ports.IdGeneratorRepository;

public class IdGenerator implements IdGeneratorRepository {
    private int videojuego = 100;
    private int consola = 100;
    private int cliente = 100;
    private int Transaccion = 100;

    @Override
    public String nextId(char typeId) {
        return switch (typeId) {
            case 'C' -> "C" + consola++;
            case 'V' -> "V" + videojuego++;
            case 'U' -> "U" + cliente++;
            case 'T' -> "T" + Transaccion++;
            default -> throw new IllegalArgumentException("Tipo de ID no soportado: " + typeId);
        };
    }
}