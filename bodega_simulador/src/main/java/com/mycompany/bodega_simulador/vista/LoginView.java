/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.bodega_simulador.vista;

import com.mycompany.bodega_simulador.viewmodel.BodegaViewModel;
import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private final JTextField txtUsuario;
    private final JPasswordField txtPassword;
    private final JButton btnLogin;
    private final JLabel lblMensaje;
    private final BodegaViewModel viewModel;

    public LoginView(BodegaViewModel viewModel) {
        this.viewModel = viewModel;

        setTitle("Login - Administrador");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();
        btnLogin = new JButton("Ingresar");
        lblMensaje = new JLabel("", SwingConstants.CENTER);

        add(new JLabel("Usuario:", SwingConstants.CENTER));
        add(txtUsuario);
        add(new JLabel("Contraseña:", SwingConstants.CENTER));
        add(txtPassword);
        add(btnLogin);
        add(lblMensaje);

        btnLogin.addActionListener(e -> autenticar());
    }

    private void autenticar() {
        String usuario = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());

        if (viewModel.autenticarAdministrador(usuario, password)) {
            lblMensaje.setText("Acceso concedido");
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();  
            new MenuView(viewModel).setVisible(true);  
        } else {
            lblMensaje.setText("Credenciales incorrectas");
            lblMensaje.setForeground(Color.RED);
        }
    }
}
