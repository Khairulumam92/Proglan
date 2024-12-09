package org.example.latihan2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableManager {
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;

    public TableManager() {
        // Data awal dan kolom tabel
        String[][] data = {
                {"1", "Budi", "Santoso", "25"},
                {"2", "Siti", "Nurhaliza", "30"},
                {"3", "Ahmad", "Suhendra", "40"},
                {"4", "Dewi", "Putri", "35"}
        };
        String[] columns = {"ID", "Nama Depan", "Nama Belakang", "Usia"};

        // Membuat model dan tabel
        model = new DefaultTableModel(data, columns);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void addRow(String id, String namaDepan, String namaBelakang, String usia) {
        model.addRow(new Object[]{id, namaDepan, namaBelakang, usia});
    }
}

