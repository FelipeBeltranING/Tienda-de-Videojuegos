package entities;

import java.time.LocalDate;

public class Transaccion {

    private final String id;
    private final Cliente cliente;
    private final Producto producto;
    private final LocalDate fecha;
    private final DetalleTransaccion detalleTransaccion;


    public Transaccion(String id,Cliente cliente, Producto producto, DetalleTransaccion detalleTransaccion){
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = LocalDate.now();
        this.detalleTransaccion = detalleTransaccion;
    }

    public String getId(){return id;}
    public Cliente getCliente(){return cliente;}
    public Producto getProducto(){return producto;}
    public LocalDate getFecha(){return fecha;}
    public DetalleTransaccion getDetalleTransaccion() {return detalleTransaccion;}

    @Override                              // ← agregar desde aquí
    public String toString() {
        return "Transaccion{" +
                "\n  ID: " + id +
                "\n  Fecha: " + fecha +
                "\n  Cliente: " + cliente.getNombre() +
                "\n  Producto: " + producto.getTitulo() +
                "\n  Subtotal: $" + detalleTransaccion.getSubtotal() +
                "\n  Total: $" + detalleTransaccion.getTotal() +
                "\n}";
    }
}