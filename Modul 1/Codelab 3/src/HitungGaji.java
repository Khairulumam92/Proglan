import java.util.Scanner;

public class HitungGaji {

    public int perhitunganGaji(int jamKerja, int gajiperJam) {

        if (jamKerja < 0 || gajiperJam < 0) {
            System.out.println("Jam kerja dan gaji per jam harus bernilai positif.");
            return 0;
        }

        int gajiTotal = jamKerja * gajiperJam;
        return gajiTotal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah jam kerja: ");
        int jamKerja = scanner.nextInt();

        System.out.print("Masukkan gaji per jam: ");
        int gajiperJam = scanner.nextInt();

        HitungGaji hitung = new HitungGaji();
        int gajiTotal = hitung.perhitunganGaji(jamKerja, gajiperJam);

        System.out.println("Gaji karyawan dengan " + jamKerja + " jam kerja = " + gajiTotal);

        scanner.close();
    }
}
