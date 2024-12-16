package org.example.tugas1;

import javafx.application.Application;
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

public class EncryptionProgram extends Application {
    private static final int AES_KEY_SIZE = 128;
    public static final String AES_ALGORITHM = "AES";

    private TextArea inputTextArea;
    private TextArea outputTextArea;
    private TextField keyTextField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AES Encryption/Decryption");

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
        decryptButton.setStyle("-fx-background-color: green;");
        GridPane.setConstraints(decryptButton, 1, 3);
        decryptButton.setOnAction(e -> decryptMessage());

        Label outputLabel = new Label("Hasil:");
        GridPane.setConstraints(outputLabel, 0, 4);
        outputTextArea = new TextArea();
        outputTextArea.setEditable(false);
        GridPane.setConstraints(outputTextArea, 0, 5, 2, 1);

        grid.getChildren().addAll(inputLabel, inputTextArea, keyLabel, keyTextField, encryptButton, decryptButton, outputLabel, outputTextArea);

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void encryptMessage() {
        try {
            String message = inputTextArea.getText();
            SecretKey aesKey = generateAESKey();
            String encryptedAES = encryptMessageAES(message, aesKey);
            String encodedKey = Base64.getEncoder().encodeToString(aesKey.getEncoded());
            outputTextArea.setText("Hasil Enkripsi (AES): " + encryptedAES + "\nKunci AES (simpan untuk dekripsi): " + encodedKey);
        } catch (Exception e) {
            outputTextArea.setText("Error: " + e.getMessage());
        }
    }

    private void decryptMessage() {
        try {
            String message = inputTextArea.getText();
            String encodedKey = keyTextField.getText();
            SecretKey aesKey = decodeAESKey(encodedKey);
            String decryptedAES = decryptMessageAES(message, aesKey);
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
}