import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

/**
 * Program untuk melakukan enkripsi dan dekripsi menggunakan algoritma AES.
 * Pengguna dapat memilih opsi untuk mengenkripsi atau mendekripsi pesan dengan kunci AES.
 */
public class EncryptionProgramRefactored {

    /** Ukuran kunci AES dalam bit */
    private static final int AES_KEY_SIZE = 128;

    /** Algoritma AES */
    public static final String AES_ALGORITHM = "AES";

    /** Scanner untuk input dari pengguna */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Metode utama program. Menyediakan menu bagi pengguna untuk memilih opsi enkripsi atau dekripsi,
     * atau untuk keluar dari program.
     *
     * @param args argumen baris perintah (tidak digunakan dalam program ini)
     */
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
                        String outputMessage = "Hasil Dekripsi (AES):";
                        System.out.println(outputMessage + " " + decryptedAES);
                    }
                    default -> System.out.println("Opsi tidak valid, silakan pilih antara 0 hingga 2.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Meminta pengguna untuk memasukkan pesan.
     *
     * @return String yang meminta pengguna untuk memasukkan pesan.
     */
    private static String getUserInput() {
        return "Masukkan pesan";
    }

    /**
     * Mengenkripsi pesan menggunakan algoritma AES.
     *
     * @param message pesan yang akan dienkripsi
     * @param key kunci AES yang digunakan untuk enkripsi
     * @return pesan yang telah dienkripsi dalam bentuk String
     * @throws Exception jika terjadi kesalahan pada proses enkripsi
     */
    public static String encryptMessageAES(String message, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(encryptedBytes);
    }

    /**
     * Mendekripsi pesan yang telah dienkripsi menggunakan algoritma AES.
     *
     * @param encryptedMessage pesan yang telah dienkripsi
     * @param key kunci AES yang digunakan untuk dekripsi
     * @return pesan asli yang telah didekripsi
     * @throws Exception jika terjadi kesalahan pada proses dekripsi
     */
    public static String decryptMessageAES(String encryptedMessage, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        return new String(decryptedBytes);
    }

    /**
     * Menghasilkan kunci AES secara acak.
     *
     * @return kunci AES yang dihasilkan
     * @throws Exception jika terjadi kesalahan pada proses pembuatan kunci
     */
    public static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES_ALGORITHM);
        keyGenerator.init(AES_KEY_SIZE);
        return keyGenerator.generateKey();
    }

    /**
     * Mengubah kunci AES dari bentuk String (Base64) menjadi objek SecretKey.
     *
     * @param encodedKey kunci AES dalam bentuk String (Base64)
     * @return kunci AES dalam bentuk objek SecretKey
     */
    public static SecretKey decodeAESKey(String encodedKey) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedKey = decoder.decode(encodedKey);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, AES_ALGORITHM);
    }
}

// ini lewat master yaa