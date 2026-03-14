package model;

<<<<<<< Updated upstream:src/model/DetalleTransaccion.java
import service.CalculadoraPrecio;
import service.Reglas;

=======
>>>>>>> Stashed changes:src/entities/DetalleTransaccion.java
public class DetalleTransaccion {

    private final double subtotal;
    private final double total;

    public DetalleTransaccion(double total, double subtotal){
        this.subtotal = subtotal;
        this.total = total;
    }

    public double getSubtotal() {return subtotal;}
    public double getTotal() {return total;}
}
