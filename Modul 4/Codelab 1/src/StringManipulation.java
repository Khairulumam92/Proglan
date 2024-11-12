import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = scanner.nextLine();

        String kalimatKapital = kalimat.toUpperCase();
        System.out.println("Huruf kapital: " + kalimatKapital);

        System.out.print("Masukkan kata yang ingin diganti: ");
        String kataLama = scanner.nextLine();
        System.out.print("Masukkan kata pengganti: ");
        String kataBaru = scanner.nextLine();
        String kalimatBaru = kalimat.replace(kataLama, kataBaru);
        System.out.println("Setelah mengganti kata: " + kalimatBaru);

        StringBuilder kalimatTerbalik = new StringBuilder(kalimatBaru);
        kalimatTerbalik.reverse();
        System.out.println("Kalimat terbalik: " + kalimatTerbalik);
    }
}