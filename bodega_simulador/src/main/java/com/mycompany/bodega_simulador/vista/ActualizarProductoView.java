/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.bodega_simulador.vista;

import com.mycompany.bodega_simulador.modelo.Producto;
import com.mycompany.bodega_simulador.viewmodel.BodegaViewModel;
import javax.swing.*;
import java.awt.*;

public class ActualizarProductoView extends JFrame {
    private final BodegaViewModel viewModel;
    
    private JTextField txtBuscarId;
    private JButton btnBuscar;
    
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JButton btnActualizar;
    private JButton btnCancelar;

    public ActualizarProductoView(BodegaViewModel viewModel) {
        this.viewModel = viewModel;
        initComponents();
    }

    private void initComponents() {
        setTitle("Actualizar Producto");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        JPanel panelBusqueda = new JPanel(new FlowLayout());
        panelBusqueda.add(new JLabel("Ingrese ID del producto:"));
        txtBuscarId = new JTextField(10);
        panelBusqueda.add(txtBuscarId);
        btnBuscar = new JButton("Buscar");
        panelBusqueda.add(btnBuscar);
        
        JPanel panelCampos = new JPanel(new GridLayout(4, 2, 10, 10));
        panelCampos.add(new JLabel("ID:"));
        txtId = new JTextField();
        txtId.setEditable(false);
        panelCampos.add(txtId);
        
        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);
        
        panelCampos.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelCampos.add(txtPrecio);
        
        panelCampos.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        panelCampos.add(txtCantidad);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnActualizar = new JButton("Actualizar");
        btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnActualizar);
        panelBotones.add(btnCancelar);
        
        add(panelBusqueda, BorderLayout.NORTH);
        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        
        btnBuscar.addActionListener(e -> buscarProducto());
        btnActualizar.addActionListener(e -> actualizarProducto());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void buscarProducto() {
        String id = txtBuscarId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Producto producto = viewModel.buscarProducto(id);
        if (producto != null) {
            txtId.setText(producto.getId());
            txtNombre.setText(producto.getNombre());
            txtPrecio.setText(String.valueOf(producto.getPrecio()));
            txtCantidad.setText(String.valueOf(producto.getCantidad()));
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarProducto() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero busque un producto a actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = txtNombre.getText().trim();
        String precioStr = txtPrecio.getText().trim();
        String cantidadStr = txtCantidad.getText().trim();
        
        if (nombre.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double precio;
        int cantidad;
        try {
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            cantidad = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Producto productoActualizado = new Producto(id, nombre, precio, cantidad);
        
        viewModel.actualizarProducto(id, productoActualizado);
        JOptionPane.showMessageDialog(this, "Producto actualizado exitosamente.");
        dispose();
    }
}
