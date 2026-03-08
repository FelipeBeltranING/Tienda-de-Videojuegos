package service;
public class CalculadoraPrecio {
    public double calcularPrecioVenta(double precioUnitario, double iva){
        double Total = precioUnitario + precioUnitario*iva;
        return Total;
    }
}
