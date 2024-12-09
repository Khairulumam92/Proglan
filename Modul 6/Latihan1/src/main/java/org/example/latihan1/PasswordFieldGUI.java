package org.example.latihan1;

import javax.swing.*;
import java.awt.*;

public class PasswordFieldGUI {
    private final JFrame frame;

    public PasswordFieldGUI() {
        // Membuat JFrame
        frame = new JFrame("Contoh Password Field");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Membuat komponen GUI
        JLabel label = new JLabel("Masukkan Kata Sandi:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton button = new JButton("Validasi Password");
        JLabel resultLabel = new JLabel("Password akan divalidasi di sini.");

        // Menambahkan komponen ke JFrame
        frame.add(label);
        frame.add(passwordField);
        frame.add(button);
        frame.add(resultLabel);

        // Menambahkan ActionListener ke tombol
        button.addActionListener(new PasswordValidator(passwordField, resultLabel));
    }

    public void show() {
        frame.setVisible(true);
    }
}
