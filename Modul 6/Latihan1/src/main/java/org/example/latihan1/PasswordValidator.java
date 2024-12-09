package org.example.latihan1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordValidator implements ActionListener {
    private JPasswordField passwordField;
    private JLabel resultLabel;

    public PasswordValidator(JPasswordField passwordField, JLabel resultLabel) {
        this.passwordField = passwordField;
        this.resultLabel = resultLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Mengambil password dari JPasswordField
        char[] password = passwordField.getPassword();
        String passwordText = new String(password);

        // Memvalidasi password
        String validationMessage = validatePassword(passwordText);
        JOptionPane.showMessageDialog(null, validationMessage);
        resultLabel.setText(validationMessage);
    }

    private String validatePassword(String password) {
        if (password.length() < 7) {
            return "Password tidak valid. Minimal 7 karakter.";
        } else if (!password.matches(".*[A-Z].*")) {
            return "Password tidak valid. Harus mengandung huruf besar.";
        } else if (!password.matches(".*[a-z].*")) {
            return "Password tidak valid. Harus mengandung huruf kecil.";
        } else if (!password.matches(".*[0-9].*")) {
            return "Password tidak valid. Harus mengandung angka.";
        } else {
            return "Password Valid";
        }
    }
}
