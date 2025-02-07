/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.bodega_simulador;

import com.mycompany.bodega_simulador.vista.LoginView;
import com.mycompany.bodega_simulador.viewmodel.BodegaViewModel;
import javax.swing.SwingUtilities;

public class Bodega_simulador {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BodegaViewModel viewModel = new BodegaViewModel();  
            new LoginView(viewModel).setVisible(true);  
        });
    }
}



