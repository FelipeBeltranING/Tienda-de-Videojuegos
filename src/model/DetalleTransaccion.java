package model;

public class DetalleTransaccion {

    private final Producto producto;
    private final double subtotal;

    public DetalleTransaccion(Producto producto, double subtotal){
        this.producto = producto;
        this.subtotal = subtotal;
    }

    public double getSubtotal() {return subtotal;}
}
