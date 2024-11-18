import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class EncryptionDecryptionApp {
    private static final int AES_KEY_SIZE = 128;
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

                System.out.print("Masukkan pesan: ");
                String message = scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        SecretKey aesKey = generateAESKey();
                        String encryptedAES = encryptAES(message, aesKey);
                        String encodedKey = Base64.getEncoder().encodeToString(aesKey.getEncoded());
                        System.out.println("Hasil Enkripsi (AES): " + encryptedAES);
                        System.out.println("Kunci AES (simpan untuk dekripsi): " + encodedKey);
                    }
                    case 2 -> {
                        System.out.print("Masukkan kunci AES: ");
                        String encodedKey = scanner.nextLine();
                        SecretKey aesKey = decodeAESKey(encodedKey);
                        String decryptedAES = decryptAES(message, aesKey);
                        System.out.println("Hasil Dekripsi (AES): " + decryptedAES);
                    }
                    default -> System.out.println("Opsi tidak valid, silakan pilih antara 0 hingga 2.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encryptAES(String message, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decryptAES(String encryptedMessage, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes);
    }

    public static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(AES_KEY_SIZE);
        return keyGenerator.generateKey();
    }

    public static SecretKey decodeAESKey(String encodedKey) {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }
}
