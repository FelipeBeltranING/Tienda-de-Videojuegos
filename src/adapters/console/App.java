package adapters.console;

import java.util.Scanner;
import entities.*;
import infrastructure.services.IdGenerator;
import usecases.ports.IdGeneratorRepository;
import usecases.services.RegistrarClienteUseCase;
import usecases.services.TiendaVideojuego;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TiendaVideojuego tienda = new TiendaVideojuego("GameStore");

        IdGeneratorRepository idGeneratorRepository = new IdGenerator();
        // Datos de prueba

        TiendaVideojuego.(new Cliente(idGeneratorRepository.nextId('U'), "Lucia", "Lucia@mail.com"));
        tienda.registrarCliente(new Cliente(idGeneratorRepository.nextId('U'), "Felipe", "Felipe@mail.com"));
        RegistrarClienteUseCase.
        tienda.registrarProducto(new Consola(idGeneratorRepository.nextId('C'), "Z BOX", 239.99, true, 2, "MacroSoft"));
        tienda.registrarProducto(new Videojuego(idGeneratorRepository.nextId('V'), "God of peace",19.99, true, 3, "PolyStation 5", "Accion"));

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