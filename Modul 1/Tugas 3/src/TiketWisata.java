import java.util.Scanner;

public class TiketWisata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data dari pengguna
        System.out.println("=====Program Pembelian Tiket=====");
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Hari (contoh: Senin, Selasa, ...): ");
        String hari = scanner.nextLine();

        System.out.print("Masukkan Tanggal (format: dd-mm-yyyy): ");
        String tanggal = scanner.nextLine();

        System.out.print("Masukkan Jenis Tiket (Reguler/Terusan): ");
        String jenisTiket = scanner.nextLine();

        System.out.print("Masukkan Kategori Usia (Dewasa/Anak-anak): ");
        String kategoriUsia = scanner.nextLine();

        // Validasi input
        if (nama.isEmpty() || hari.isEmpty() || tanggal.isEmpty() || jenisTiket.isEmpty() || kategoriUsia.isEmpty()) {
            System.out.println("data harus diisi");
            return;
        }

        int harga = 0;
        if (jenisTiket.equalsIgnoreCase("Reguler")) {
            if (kategoriUsia.equalsIgnoreCase("Dewasa")) {
                harga = 75000;
            } else if (kategoriUsia.equalsIgnoreCase("Anak-anak")) {
                harga = 60000;
            }
        } else if (jenisTiket.equalsIgnoreCase("Terusan")) {
            if (kategoriUsia.equalsIgnoreCase("Dewasa")) {
                harga = 100000;
            } else if (kategoriUsia.equalsIgnoreCase("Anak-anak")) {
                harga = 85000;
            }
        }

        // Penambahan 20% jika hari Sabtu atau Minggu
        if (hari.equalsIgnoreCase("Sabtu") || hari.equalsIgnoreCase("Minggu")) {
            harga += harga * 0.2;
        }

        // Output total harga tiket
        System.out.println("Total harga tiket yang harus dibayar: " + harga);
    }
}