/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.bodega_simulador.vista;

import com.mycompany.bodega_simulador.modelo.Producto;
import com.mycompany.bodega_simulador.viewmodel.BodegaViewModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListarProductosView extends JFrame {

    private final BodegaViewModel viewModel;
    private JTable tableProductos;
    private DefaultTableModel tableModel;
    private JComboBox<String> cbOrden;
    private JButton btnRefrescar;
    private JButton btnVolver;

    public ListarProductosView(BodegaViewModel viewModel) {
        this.viewModel = viewModel;
        initComponents();
        cargarDatos(); 
    }

    private void initComponents() {
        setTitle("Listado de Productos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new FlowLayout());
        panelSuperior.add(new JLabel("Ordenar por:"));
        cbOrden = new JComboBox<>(new String[]{"Nombre", "Precio", "Cantidad"});
        panelSuperior.add(cbOrden);
        btnRefrescar = new JButton("Refrescar");
        panelSuperior.add(btnRefrescar);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Precio");
        tableModel.addColumn("Cantidad");

        tableProductos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableProductos);

        JPanel panelInferior = new JPanel(new FlowLayout());
        btnVolver = new JButton("Volver");
        panelInferior.add(btnVolver);

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        btnRefrescar.addActionListener(e -> cargarDatos());
        btnVolver.addActionListener(e -> dispose());
    }

    private void cargarDatos() {
        tableModel.setRowCount(0);
        
        String criterioOrden = (String) cbOrden.getSelectedItem();
        List<Producto> productos;
        if (criterioOrden.equals("Nombre")) {
            productos = viewModel.ordenarProductosPorNombre();
        } else if (criterioOrden.equals("Precio")) {
            productos = viewModel.ordenarProductosPorPrecio();
        } else if (criterioOrden.equals("Cantidad")) {
            productos = viewModel.ordenarProductosPorCantidad();
        } else {
            productos = viewModel.listarProductos();
        }

        for (Producto p : productos) {
            Object[] fila = new Object[]{
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                p.getCantidad()
            };
            tableModel.addRow(fila);
        }
    }
}

