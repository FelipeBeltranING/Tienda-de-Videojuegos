package model;

import service.CalculadoraPrecio;
import service.Reglas;

public class DetalleTransaccion {

    private final Producto producto;
    private final double subtotal;
    private final double total;

    public DetalleTransaccion(Producto producto){
        this.producto = producto;
        this.subtotal = producto.getPrecioBase();
        this.total = new CalculadoraPrecio().calcularPrecioVenta(producto.getPrecioBase(),Reglas.iva);
    }

    public double getSubtotal() {return subtotal;}
    public double getTotal() {return total;}
}
