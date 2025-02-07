/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.bodega_simulador.viewmodel;

import com.mycompany.bodega_simulador.modelo.Administrador;
import com.mycompany.bodega_simulador.modelo.Bodega;
import com.mycompany.bodega_simulador.modelo.Producto;
import java.util.List;

public class BodegaViewModel {
    private final Administrador administrador;
    private final Bodega bodega;

    public BodegaViewModel() {
        administrador = new Administrador("STEVE", "open");
        bodega = new Bodega();

        bodega.agregarProducto(new Producto("10231", "Pan", 3000, 6));
        bodega.agregarProducto(new Producto("10232", "Huevos", 600, 12));
        bodega.agregarProducto(new Producto("10233", "Aceite", 12000, 1));
        bodega.agregarProducto(new Producto("10234", "Moras", 6000, 25));
        bodega.agregarProducto(new Producto("10235", "Naranjas 1kg", 5000, 3));
        bodega.agregarProducto(new Producto("10236", "Manzanas 1kg", 12000, 7));
        bodega.agregarProducto(new Producto("10235", "Papas 1kg",  8000, 4));
        bodega.agregarProducto(new Producto("10237", "Minichips", 2000, 1));
        bodega.agregarProducto(new Producto("10238", "Arroz 1kg", 9000, 15));
        bodega.agregarProducto(new Producto("10239", "Jamon", 30000, 2));
    }

    public boolean autenticarAdministrador(String usuario, String password) {
        return administrador.getUsuario().equals(usuario) && administrador.getPassword().equals(password);
    }
    
    public void agregarProducto(Producto producto) {
        bodega.agregarProducto(producto);
    }
    
    public List<Producto> listarProductos() {
        return bodega.listarProductos();
    }
    
    public Producto buscarProducto(String id) {
        return bodega.buscarProducto(id);
    }
    
    public void actualizarProducto(String id, Producto producto) {
        bodega.modificarProducto(id, producto);
    }
    
    public void eliminarProducto(String id) {
        bodega.eliminarProducto(id);
    }
    
    public List<Producto> ordenarProductosPorNombre() {
        return bodega.ordenarPorNombreAsc();
    }
    
    public List<Producto> ordenarProductosPorPrecio() {
        return bodega.ordenarPorPrecioAsc();
    }
    
    public List<Producto> ordenarProductosPorCantidad() {
        return bodega.ordenarPorCantidadAsc();
    }
}

