package model;

public class Cliente {

    private final int id;
    private final String nombre;
    private final String email;

    public Cliente(int id, String nombre, String email){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId(){return id;}
    public String getNombre(){return nombre;}
    public String getEmail(){return email;}

    @Override                              // ← agregar desde aquí
    public String toString() {
        return "Cliente{" +
                "\n  ID: " + id +
                "\n  Nombre: " + nombre +
                "\n  Email: " + email +
                "\n}";
    }
}