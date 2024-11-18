import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean lanjut = true;

        while (lanjut) {
            Locale[] locales = {
                    new Locale("en", "US"),
                    new Locale("id", "ID"),
                    new Locale("ja", "JP"),
                    new Locale("ko", "KR")
            };

            System.out.println("Pilih Locale:");
            for (int i = 0; i < locales.length; i++) {
                System.out.println((i + 1) + ". " + locales[i].getDisplayCountry() + " (" + locales[i].getCountry() + ")");
            }
            System.out.print("Pilih Locale: ");

            int pilihanLocale = scanner.nextInt();
            Locale locale = locales[pilihanLocale - 1];

            System.out.print("Masukkan sebuah angka: ");
            double angka = scanner.nextDouble();
            System.out.print("Masukkan tanggal (dd-MM-yyyy): ");
            String tanggalString = scanner.next();

            NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);

            String formattedNumber = numberFormat.format(angka);
            String formattedCurrency = currencyFormat.format(angka);

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy", locale);
            try {
                java.util.Date tanggal = sdf.parse(tanggalString);
                String formattedDate = dateFormat.format(tanggal);
                System.out.println("Formatted date: " + formattedDate);
            } catch (Exception e) {
                System.out.println("Format tanggal tidak valid.");
            }

            System.out.println("\nLocale: " + locale);
            System.out.println("Formatted number: " + formattedNumber);
            System.out.println("Formatted currency: " + formattedCurrency);

            System.out.print("Ingin mengulang? (y/n): ");
            String jawaban = scanner.next();
            lanjut = jawaban.equalsIgnoreCase("y");
        }
    }
}