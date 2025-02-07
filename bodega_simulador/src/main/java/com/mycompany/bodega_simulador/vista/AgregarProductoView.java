/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.bodega_simulador.vista;

import com.mycompany.bodega_simulador.modelo.Producto;
import com.mycompany.bodega_simulador.viewmodel.BodegaViewModel;
import javax.swing.*;
import java.awt.*;

public class AgregarProductoView extends JFrame {
    private final BodegaViewModel viewModel;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JButton btnAgregar;
    private JButton btnCancelar;

    public AgregarProductoView(BodegaViewModel viewModel) {
        this.viewModel = viewModel;
        initComponents();
    }

    private void initComponents() {
        setTitle("Agregar Producto");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panelCampos = new JPanel(new GridLayout(4, 2, 10, 10));
        
        panelCampos.add(new JLabel("ID:"));
        txtId = new JTextField();
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
        btnAgregar = new JButton("Agregar");
        btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnAgregar);
        panelBotones.add(btnCancelar);
        
        setLayout(new BorderLayout(10, 10));
        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        
        btnAgregar.addActionListener(e -> agregarProducto());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void agregarProducto() {
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String precioStr = txtPrecio.getText().trim();
        String cantidadStr = txtCantidad.getText().trim();

        if(id.isEmpty() || nombre.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty()){
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
        
        Producto producto = new Producto(id, nombre, precio, cantidad);

        viewModel.agregarProducto(producto);

        JOptionPane.showMessageDialog(this, "Producto agregado exitosamente.");
        dispose(); 
    }
}
