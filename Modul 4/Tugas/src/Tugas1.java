import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Siswa {
    String nama;
    int nilai;

    public Siswa(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public int getNilai() {
        return nilai;

    }
}

public class Tugas1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Siswa> daftarSiswa = new ArrayList<>();

        int pilihan;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Siswa");
            System.out.println("2. Urutkan dan Tampilkan berdasarkan Nama");
            System.out.println("3. Urutkan dan Tampilkan berdasarkan Nilai");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama siswa: ");
                    String nama = scanner.next();
                    System.out.print("Masukkan nilai siswa: ");
                    int nilai = scanner.nextInt();
                    daftarSiswa.add(new Siswa(nama, nilai));
                    System.out.println("Data siswa berhasil ditambahkan.");
                    break;
                case 2:
                    Collections.sort(daftarSiswa, Comparator.comparing(Siswa::getNama));
                    System.out.println("Data siswa, diurutkan berdasarkan nama:");
                    for (Siswa siswa : daftarSiswa) {
                        System.out.println("Nama: " + siswa.nama + ", Nilai: " + siswa.nilai);
                    }
                    break;
                case 3:
                    Collections.sort(daftarSiswa, Comparator.comparing(Siswa::getNilai).reversed());
                    System.out.println("Data siswa, diurutkan berdasarkan nilai:");
                    for (Siswa siswa : daftarSiswa) {
                        System.out.println("Nama: " + siswa.nama + ", Nilai: " + siswa.nilai);
                    }
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);
    }
}