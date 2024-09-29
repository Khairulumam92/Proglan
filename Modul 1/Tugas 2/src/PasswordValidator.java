import java.util.Scanner;

// Custom exception class
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class PasswordValidator {

    // Method to validate password
    public static void validatePassword(String password) throws InvalidPasswordException {
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password harus memiliki panjang minimal 8 karakter.");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu karakter huruf besar (A-Z).");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu karakter huruf kecil (a-z).");
        }

        if (!password.matches(".*[0-9].*")) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu karakter angka (0-9).");
        }

        if (!password.matches(".*[!@#$%^&*].*")) {
            throw new InvalidPasswordException("Password harus mengandung setidaknya satu karakter khusus ('!', '@', '#', '$', '%', '^', '&', '*').");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validPassword = false;

        while (!validPassword) {
            System.out.println("=====Ketentuan Password=====");
            System.out.println("1. Memiliki panjang minimal 8 karakter.\n" +
                    "2. Mengandung setidaknya satu karakter huruf besar (A-Z).\n" +
                    "3. Mengandung setidaknya satu karakter huruf kecil (a-z).\n" +
                    "4. Mengandung setidaknya satu karakter angka (0-9).\n" +
                    "5. Mengandung setidaknya satu karakter khusus ('!', '@', '#', '$', '%', '^', '&', '*').");
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            try {
                validatePassword(password);
                System.out.print("Password valid.");
                validPassword = true;
            } catch (InvalidPasswordException e) {
                System.out.println("Password tidak valid: " + e.getMessage());
                System.out.println("Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}