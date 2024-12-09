package org.example.latihan2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPanel {
    private JPanel panel;
    private JTextField idField, namaDepanField, namaBelakangField, usiaField;
    private JButton addButton;

    public InputPanel(TableManager tableManager) {
        // Membuat panel dan layout
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Membuat input fields
        idField = new JTextField(20);
        namaDepanField = new JTextField(20);
        namaBelakangField = new JTextField(20);
        usiaField = new JTextField(20);

        // Menambahkan komponen ke panel
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Nama Depan:"));
        panel.add(namaDepanField);
        panel.add(new JLabel("Nama Belakang:"));
        panel.add(namaBelakangField);
        panel.add(new JLabel("Usia:"));
        panel.add(usiaField);

        // Tombol tambah
        addButton = new JButton("Tambah Data");
        panel.add(addButton);

        // Menambahkan listener untuk tombol tambah
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validasi input
                String id = idField.getText();
                String namaDepan = namaDepanField.getText();
                String namaBelakang = namaBelakangField.getText();
                String usia = usiaField.getText();

                if (id.isEmpty() || namaDepan.isEmpty() || namaBelakang.isEmpty() || usia.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Menambahkan data ke tabel
                    tableManager.addRow(id, namaDepan, namaBelakang, usia);

                    // Mengosongkan field
                    idField.setText("");
                    namaDepanField.setText("");
                    namaBelakangField.setText("");
                    usiaField.setText("");
                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}

