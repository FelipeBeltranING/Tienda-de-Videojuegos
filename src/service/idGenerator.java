package service;

public class idGenerator {
    private static int contador = 0;

    public static int generarId() {
        contador++;
        return contador;
    }
}