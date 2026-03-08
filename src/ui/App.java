package ui;

import java.util.Scanner;
import model.*;
import service.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TiendaVideojuego tienda = new TiendaVideojuego("GameStore");

        // Datos de prueba
        tienda.registrarCliente(new Cliente(IdGenerator.generarId(), "Lucia", "Lucia@mail.com"));
        tienda.registrarCliente(new Cliente(IdGenerator.generarId(), "Felipe", "Felipe@mail.com"));

        tienda.registrarProducto(new Consola(IdGenerator.generarId(), "Z BOX", 239.99, true, 2, "MacroSoft"));
        tienda.registrarProducto(new Videojuego(IdGenerator.generarId(), "God of peace",19.99, true, 3, "PolyStation 5"));

        int op;
        do {
            System.out.println("\n=== " + tienda.getNombre() + " ===");
            System.out.println("1) Listar productos");
            System.out.println("2) Listar clientes");
            System.out.println("3) Listar transacciones");
            System.out.println("4) Vender producto");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            op = leerEntero(sc);

            switch (op) {
                case 1 -> tienda.listarProductos();
                case 2 -> tienda.listarClientes();
                case 3 -> tienda.listarTransacciones();
                case 4 -> {
                    System.out.print("ID Cliente: ");
                    int idCliente = leerEntero(sc);
                    System.out.print("ID Producto: ");
                    int idProducto = leerEntero(sc);
                    tienda.vender(idCliente, idProducto);
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 0);

        sc.close();
    }

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Ingrese un número: ");
        }
        return sc.nextInt();
    }
}