package Refac;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class EncryptionProgramRefactored {
    private static final int AES_KEY_SIZE = 128;
    public static final String AES_ALGORITHM = "AES";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Enkripsi menggunakan AES");
                System.out.println("2. Dekripsi menggunakan AES");
                System.out.println("0. Keluar");
                System.out.print("Pilih opsi: ");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 0) {
                    System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                    break;
                }
                //Extract Method
                System.out.print(getUserInput() + ": ");
                String message = scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        SecretKey aesKey = generateAESKey();
                        String encryptedAES = encryptMessageAES(message, aesKey);
                        String encodedKey = Base64.getEncoder().encodeToString(aesKey.getEncoded());
                        System.out.println("Hasil Enkripsi (AES): " + encryptedAES);
                        System.out.println("Kunci AES (simpan untuk dekripsi): " + encodedKey);
                    }
                    case 2 -> {
                        System.out.print("Masukkan kunci AES: ");
                        String encodedKey = scanner.nextLine();
                        SecretKey aesKey = decodeAESKey(encodedKey);
                        String decryptedAES = decryptMessageAES(message, aesKey);
                        // Introduce Local Variable
                        String outputMassage = "Hasil Dekripsi (AES):";
                        System.out.println(outputMassage + " " + decryptedAES);
                    }
                    default -> System.out.println("Opsi tidak valid, silakan pilih antara 0 hingga 2.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getUserInput() {
        //Extract Method
        return "Masukkan pesan";
    }
    //Rename Method
    public static String encryptMessageAES(String message, SecretKey key) throws Exception {
        //Extract Constant
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        //Extract Variable
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(encryptedBytes);
    }
    //Rename Method
    public static String decryptMessageAES(String encryptedMessage, SecretKey key) throws Exception {
        //Extract Constant
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
        //Extract Variable
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedKey = decoder.decode(encodedKey);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, AES_ALGORITHM);
    }
}

/*
- Rename Method untuk memperjelas nama metode.
- Extract Constant untuk menghindari penggunaan string yang berulang.
- Extract Method untuk menyederhanakan pengambilan input pengguna.
- Extract Variable untuk membuat kode lebih efisien dengan variabel encoder/decoder.
- Introduce Local Variable untuk meningkatkan keterbacaan dalam mencetak output.
*/
