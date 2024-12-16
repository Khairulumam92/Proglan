package org.example.tugas2;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptedTableProgram extends Application {

    private static final int AES_KEY_SIZE = 128;
    public static final String AES_ALGORITHM = "AES";

    private TextArea inputTextArea;
    private TextArea outputTextArea;
    private TextField keyTextField;
    private TableView<EncryptedData> table;
    private ObservableList<EncryptedData> dataList;

    String[][] data = {
            {"Halo", "NXXaSuCIQ+PZCTvlKgVH3w==", "Otw0uI0HkBVadaqk2j/f4w=="},
            {"Umam", "8tHwOouMTvKo4Fdf8+r7UA==", "ofadwGK5qMWFnYBDTNoH6w=="}
    };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AES Encryption/Decryption");

        // Grid pane untuk layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label inputLabel = new Label("Masukkan Pesan:");
        GridPane.setConstraints(inputLabel, 0, 0);
        inputTextArea = new TextArea();
        GridPane.setConstraints(inputTextArea, 0, 1, 2, 1);

        Label keyLabel = new Label("Kunci AES:");
        GridPane.setConstraints(keyLabel, 0, 2);
        keyTextField = new TextField();
        GridPane.setConstraints(keyTextField, 1, 2);

        Button encryptButton = new Button("Enkripsi");
        encryptButton.setStyle("-fx-background-color: skyblue;");
        GridPane.setConstraints(encryptButton, 0, 3);
        encryptButton.setOnAction(e -> encryptMessage());

        Button decryptButton = new Button("Dekripsi");
        decryptButton.setStyle("-fx-background-color: orange;");
        GridPane.setConstraints(decryptButton, 1, 3);
        decryptButton.setOnAction(e -> decryptMessage());

        Label outputLabel = new Label("Hasil:");
        GridPane.setConstraints(outputLabel, 0, 4);
        outputTextArea = new TextArea();
        outputTextArea.setEditable(false);
        GridPane.setConstraints(outputTextArea, 0, 5, 2, 1);

        table = new TableView<>();
        TableColumn<EncryptedData, String> messageColumn = new TableColumn<>("Pesan");
        TableColumn<EncryptedData, String> encryptedColumn = new TableColumn<>("Hasil Enkripsi");
        TableColumn<EncryptedData, String> aesKeyColumn = new TableColumn<>("Kunci AES");

        messageColumn.setCellValueFactory(cellData -> cellData.getValue().messageProperty());
        encryptedColumn.setCellValueFactory(cellData -> cellData.getValue().encryptedMessageProperty());
        aesKeyColumn.setCellValueFactory(cellData -> cellData.getValue().aesKeyProperty());

        table.getColumns().addAll(messageColumn, encryptedColumn, aesKeyColumn);

        dataList = FXCollections.observableArrayList();
        table.setItems(dataList);

        loadDataIntoTable();

        grid.getChildren().addAll(inputLabel, inputTextArea, keyLabel, keyTextField, encryptButton, decryptButton, outputLabel, outputTextArea);

        grid.add(table, 0, 6, 2, 1);

        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadDataIntoTable() {
        for (String[] entry : data) {
            String message = entry[0];
            String encryptedMessage = entry[1];
            String aesKey = entry[2];
            dataList.add(new EncryptedData(message, encryptedMessage, aesKey));
        }
    }

    private void encryptMessage() {
        try {
            String message = inputTextArea.getText();
            SecretKey aesKey = generateAESKey();
            String encryptedAES = encryptMessageAES(message, aesKey);
            String encodedKey = Base64.getEncoder().encodeToString(aesKey.getEncoded());

            outputTextArea.setText("Hasil Enkripsi (AES): " + encryptedAES + "\nKunci AES (simpan untuk dekripsi): " + encodedKey);

            dataList.add(new EncryptedData(message, encryptedAES, encodedKey));

        } catch (Exception e) {
            outputTextArea.setText("Error: " + e.getMessage());
        }
    }

    private void decryptMessage() {
        try {
            String encryptedMessage = inputTextArea.getText();
            String encodedKey = keyTextField.getText();
            SecretKey aesKey = decodeAESKey(encodedKey);
            String decryptedAES = decryptMessageAES(encryptedMessage, aesKey);

            outputTextArea.setText("Hasil Dekripsi (AES): " + decryptedAES);

        } catch (Exception e) {
            outputTextArea.setText("Error: " + e.getMessage());
        }
    }

    public static String encryptMessageAES(String message, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decryptMessageAES(String encryptedMessage, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes);
    }

    public static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES_ALGORITHM);
        keyGenerator.init(AES_KEY_SIZE);
        return keyGenerator.generateKey();
    }

    public static SecretKey decodeAESKey(String encodedKey) {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, AES_ALGORITHM);
    }

    public static class EncryptedData {
        private StringProperty message;
        private StringProperty encryptedMessage;
        private StringProperty aesKey;

        public EncryptedData(String message, String encryptedMessage, String aesKey) {
            this.message = new SimpleStringProperty(message);
            this.encryptedMessage = new SimpleStringProperty(encryptedMessage);
            this.aesKey = new SimpleStringProperty(aesKey);
        }

        public String getMessage() {
            return message.get();
        }

        public String getEncryptedMessage() {
            return encryptedMessage.get();
        }

        public String getAesKey() {
            return aesKey.get();
        }

        public StringProperty messageProperty() {
            return message;
        }

        public StringProperty encryptedMessageProperty() {
            return encryptedMessage;
        }

        public StringProperty aesKeyProperty() {
            return aesKey;
        }
    }
}
