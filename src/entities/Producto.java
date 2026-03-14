package entities;

public abstract class Producto implements Transaccionable {
    protected final int id;
    protected final String titulo;
    protected final double precioBase;
    protected boolean disponible=true;
    protected int unidades;
    
    public Producto(int id, String titulo, double precioBase, boolean disponible, int unidades) {
        this.id = id;
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.unidades = unidades;
        this.disponible = disponible;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public double getPrecioBase() {
        return precioBase;
    }
    
    public int getUnidades() {
        return unidades;
    }
    
    @Override
    public boolean estaDisponible() {
      return disponible;
    }
    
    @Override
    public void vender() {
        disponible=false;
    }
    
    @Override
    public abstract String toString();

}