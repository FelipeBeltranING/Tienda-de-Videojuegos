package usecases;

public class IdGenerator {
    private static int contador = 0;

    public static int generarId() {
        contador++;
        return contador;
    }
}