package usecases;
import entities.*;

import java.util.ArrayList;
    public class  TiendaVideojuego {

        private String nombre;
        private final ArrayList<Producto> productos;
        private final ArrayList<Transaccion> transacciones;
        private final ArrayList<Cliente> clientes;
        private final CalculadoraPrecio calculadoraPrecio;
        public TiendaVideojuego(String nombre){
            this.nombre = nombre;
            this.productos = new ArrayList<>();
            this.transacciones = new ArrayList<>();
            this.clientes = new ArrayList<>();
            this.calculadoraPrecio = new CalculadoraPrecio();
        }
        public String getNombre(){return nombre;}

        public Producto buscarProducto(int idProducto){ 
            for(Producto p : productos){
                if (p.getId() == idProducto) return p;
            }
            return null; 
        }
        public Transaccion buscarTransaccion(int idTransaccion){
            for(Transaccion t : transacciones){
                if(t.getId() == idTransaccion) return t;
            }
            return null;
        }

        public Cliente buscarCliente(int idCliente){
            for(Cliente c : clientes){
                if (c.getId() == idCliente)  return c;
            }
            return null;
        }
//funciones de registrar para productos, transacciones y clientes:
        public void registrarProducto(Producto p){
            if(p == null) return;
            productos.add(p);
        }

        public void registrarTransaccion(Transaccion t){
            if (t == null) return;
            transacciones.add(t);
        }

        public void registrarCliente(Cliente c){
            if (c == null) return;
            clientes.add(c);
        }
//funciones de listar para productos, transacciones y clientes
        public void listarProductos(){
            if(productos.isEmpty()){
                System.out.println("No hay productos para ser listados");
                return;
            }
            System.out.println("---Lista de Productos en el sistema---");
                for(Producto p : productos){
                    System.out.println(p);
                }
        }

        public void listarTransacciones(){
            if(transacciones.isEmpty()){
                System.out.println("No hay Transacciones para ser listadas");
                return;
            }
            System.out.println("---Lista de las transacciones---");
                for(Transaccion t : transacciones){
                    System.out.println(t);
                }
        }

        public void listarClientes(){
            if(clientes.isEmpty()){
                System.out.println("No hay clientes para listar");
                return;
            }
            System.out.println("---Lista de los clientes---");
                for(Cliente c : clientes){
                    System.out.println(c);
                }
        }
//funcion de venta
        public void vender(int idCliente, int idProducto){
            Cliente c = buscarCliente(idCliente);
            Producto p = buscarProducto(idProducto);

            if (c == null){
                System.out.println("Usuario no encontrado");
                return;
            }
            if (p == null){
                System.out.println("Producto no encontrado");
                return;
            }
            if (!p.estaDisponible()){
                System.out.println("Producto no disponible");
                return;
            }

            Transaccion t = new Transaccion(IdGenerator.generarId(),c, p, new DetalleTransaccion(calculadoraPrecio.calcularPrecioVenta(p.getPrecioBase(),Reglas.iva),p.getPrecioBase()));
            transacciones.add(t);
            p.vender(); //metodo de interfaz

            System.out.println("venta realizada -> " + p.getTitulo() + ", id -> " + p.getId());
            System.out.println("Subtotal: " + t.getDetalleTransaccion().getSubtotal() + " IVA: " + Reglas.iva*100+"%");
            System.out.println("Costo total de la compra: " + t.getDetalleTransaccion().getTotal() +"$");
        }

    }

