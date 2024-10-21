import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;

public class EncryptionProgramRefactored {
    private static final int AES_KEY_SIZE = 128;
    private static final int RSA_KEY_SIZE = 2048;
    private static SecretKey aesKey;
    private static PublicKey rsaPublicKey;
    private static PrivateKey rsaPrivateKey;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            initializeKeys();

            boolean running = true;
            while (running) {
                int choice = displayMenu(scanner);

                if (choice == 0) {
                    System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                    running = false;
                } else {
                    processUserChoice(choice, scanner);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void initializeKeys() throws Exception {
        aesKey = generateAESKey();
        generateRSAKeys();
    }

    private static int displayMenu(Scanner scanner) {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Enkripsi menggunakan AES");
        System.out.println("2. Dekripsi menggunakan AES");
        System.out.println("3. Enkripsi menggunakan RSA");
        System.out.println("4. Dekripsi menggunakan RSA");
        System.out.println("0. Keluar");
        System.out.print("Pilih opsi: ");
        return scanner.nextInt();
    }

    private static void processUserChoice(int choice, Scanner scanner) throws Exception {
        scanner.nextLine(); // Consume newline
        System.out.print("Masukkan pesan: ");
        String message = scanner.nextLine();

        switch (choice) {
            case 1 -> System.out.println("Hasil Enkripsi (AES): " + encryptAES(message));
            case 2 -> System.out.println("Hasil Dekripsi (AES): " + decryptAES(message));
            case 3 -> System.out.println("Hasil Enkripsi (RSA): " + encryptRSA(message));
            case 4 -> System.out.println("Hasil Dekripsi (RSA): " + decryptRSA(message));
            default -> System.out.println("Opsi tidak valid, silakan pilih antara 0 hingga 4.");
        }
    }

    public static String encryptAES(String message) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        return encryptMessage(cipher, message);
    }

    public static String decryptAES(String encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        return decryptMessage(cipher, encryptedMessage);
    }

    private static String encryptMessage(Cipher cipher, String message) throws Exception {
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decryptMessage(Cipher cipher, String encryptedMessage) throws Exception {
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes);
    }

    private static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(AES_KEY_SIZE);
        return keyGenerator.generateKey();
    }

    public static String encryptRSA(String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
        return encryptMessage(cipher, message);
    }

    public static String decryptRSA(String encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
        return decryptMessage(cipher, encryptedMessage);
    }

    private static void generateRSAKeys() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(RSA_KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        rsaPublicKey = keyPair.getPublic();
        rsaPrivateKey = keyPair.getPrivate();
    }
}
