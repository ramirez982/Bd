/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.bodega_simulador.vista;

import com.mycompany.bodega_simulador.viewmodel.BodegaViewModel;
import javax.swing.*;
import java.awt.*;

public class EliminarProductoView extends JFrame {
    private final BodegaViewModel viewModel;
    private JTextField txtId;
    private JButton btnEliminar;
    private JButton btnCancelar;

    public EliminarProductoView(BodegaViewModel viewModel) {
        this.viewModel = viewModel;
        initComponents();
    }

    private void initComponents() {
        setTitle("Eliminar Producto");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelCampos = new JPanel(new GridLayout(1, 2, 10, 10));
        panelCampos.add(new JLabel("ID del Producto:"));
        txtId = new JTextField();
        panelCampos.add(txtId);

        JPanel panelBotones = new JPanel(new FlowLayout());
        btnEliminar = new JButton("Eliminar");
        btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCancelar);

        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnEliminar.addActionListener(e -> eliminarProducto());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void eliminarProducto() {
        String id = txtId.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el ID del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de eliminar el producto con ID: " + id + "?",
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            viewModel.eliminarProducto(id);
            JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente.");
            dispose();
        }
    }
}
