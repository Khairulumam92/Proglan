package org.example.latihan2;

import javax.swing.*;
import java.awt.*;

public class JTableExample {
    public static void main(String[] args) {
        // Membuat frame utama
        JFrame frame = new JFrame("Form Tabel dengan Input Pengguna");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Membuat instance dari TableManager dan InputPanel
        TableManager tableManager = new TableManager();
        InputPanel inputPanel = new InputPanel(tableManager);

        // Menambahkan komponen ke frame
        frame.add(tableManager.getScrollPane(), BorderLayout.CENTER);
        frame.add(inputPanel.getPanel(), BorderLayout.NORTH);

        // Menampilkan frame
        frame.setVisible(true);
    }
}
