package model;

public class DetalleTransaccion {

    private final Producto producto;
    private final double subtotal;

    public DetalleTransaccion(Producto producto){
        this.producto = producto;
        this.subtotal = producto.getPrecioBase();
    }

    public double getSubtotal() {return subtotal;}
}
