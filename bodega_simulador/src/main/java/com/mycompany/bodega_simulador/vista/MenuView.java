/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.bodega_simulador.vista;

import com.mycompany.bodega_simulador.viewmodel.BodegaViewModel;
import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {
    private final JButton btnListarProductos;
    private final JButton btnAgregarProducto;
    private final JButton btnActualizarProducto;
    private final JButton btnEliminarProducto;
    private final JButton btnCerrarSesion;
    private final BodegaViewModel viewModel; 

    public MenuView(BodegaViewModel viewModel) {
        this.viewModel = viewModel; 

        setTitle("Surti_Max");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        btnListarProductos = new JButton("Listar productos");
        btnAgregarProducto = new JButton("Agregar producto");
        btnActualizarProducto = new JButton("Actualizar producto");
        btnEliminarProducto = new JButton("Eliminar Producto");
        btnCerrarSesion = new JButton("Cerrar sesión");

        add(btnListarProductos);
        add(btnAgregarProducto);
        add(btnActualizarProducto);
        add(btnEliminarProducto);
        add(btnCerrarSesion);

        btnListarProductos.addActionListener(e -> listarProductos());
        btnAgregarProducto.addActionListener(e -> agregarProducto());
        btnActualizarProducto.addActionListener(e -> actualizarProducto());
        btnEliminarProducto.addActionListener(e -> eliminarProducto());
        btnCerrarSesion.addActionListener(e -> cerrarSesion());
    }

    private void listarProductos() {
        ListarProductosView listarView = new ListarProductosView(viewModel);
        listarView.setVisible(true);
    }

    private void agregarProducto() {
        AgregarProductoView agregarView = new AgregarProductoView(viewModel);
        agregarView.setVisible(true);
    }

    private void actualizarProducto() {
        ActualizarProductoView actualizarView = new ActualizarProductoView(viewModel);
        actualizarView.setVisible(true);
    }

    private void eliminarProducto() {
        EliminarProductoView eliminarView = new EliminarProductoView(viewModel);
        eliminarView.setVisible(true);
    }
    
    private void cerrarSesion() {
        dispose(); 
        new LoginView(viewModel).setVisible(true);  
    }
}
