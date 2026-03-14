package usecases.services;

import entities.Producto;

public class registrarProducto {



    public void registrarProducto(Producto p){
        if(p == null) return;
        productos.add(p);
    }
}
