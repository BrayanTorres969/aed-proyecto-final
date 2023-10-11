package com.pe.biblioteca;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.pe.biblioteca.vista.Login;
import javax.swing.UIManager;

public class ProyectoFinalAed {
    public static void main(String[] args) {
        // Configura FlatLaf
        FlatMaterialLighterIJTheme.setup();
        initCompStyles();
        Login login = new Login();
        login.setVisible(true);
    }

    private static void initCompStyles() {
        UIManager.put("PasswordField.showRevealButton", true);
    }
}
