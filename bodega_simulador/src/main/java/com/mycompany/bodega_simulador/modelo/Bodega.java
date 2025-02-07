/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bodega_simulador.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bodega {
    private final List<Producto> productos;

    public Bodega() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void modificarProducto(String id, Producto nuevoProducto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId().equals(id)) {
                productos.set(i, nuevoProducto);
                return;
            }
        }
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productos);
    }

    public List<Producto> ordenarPorNombreAsc() {
        List<Producto> ordenados = new ArrayList<>(productos);
        ordenados.sort(Comparator.comparing(Producto::getNombre));
        return ordenados;
    }

    public List<Producto> ordenarPorPrecioAsc() {
        List<Producto> ordenados = new ArrayList<>(productos);
        ordenados.sort(Comparator.comparingDouble(Producto::getPrecio));
        return ordenados;
    }

    public List<Producto> ordenarPorCantidadAsc() {
        List<Producto> ordenados = new ArrayList<>(productos);
        ordenados.sort(Comparator.comparingInt(Producto::getCantidad));
        return ordenados;
    }
    
    public void eliminarProducto(String id) {
    productos.removeIf(p -> p.getId().equals(id));
    }

    public Producto buscarProducto(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}

