package model;
import java.time.LocalDate;

public class Transaccion {

    private final int id;
    private final Cliente cliente;
    private final Producto producto;
    private final LocalDate fecha;
    private final DetalleTransaccion detalleTransaccion;

    public Transaccion(int id, Cliente cliente, Producto producto, LocalDate fecha){
        this.id = IdGenerator.generarId();
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = fecha;
        this.detalleTransaccion = new DetalleTransaccion(producto);
    }

    public int getId(){return id;}
    public Cliente getCliente(){return cliente;}
    public Producto getProducto(){return producto;}
    public LocalDate getFecha(){return fecha;}
    public DetalleTransaccion getDetalleTransaccion() {return detalleTransaccion;}
}