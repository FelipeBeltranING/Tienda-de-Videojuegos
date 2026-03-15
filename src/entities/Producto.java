package entities;

public abstract class Producto implements Transaccionable {
    protected final String id;
    protected final String titulo;
    protected final double precioBase;
    protected boolean disponible=true;
    protected int unidades;
    
    public Producto(String id, String titulo, double precioBase, boolean disponible, int unidades) {
        this.id = id;
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.unidades = unidades;
        this.disponible = disponible;
    }
    
    public String getId() {
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