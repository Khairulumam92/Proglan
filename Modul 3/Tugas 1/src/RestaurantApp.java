import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private MenuItem item;
    private int quantity;

    public Order(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double calculateSubtotal() {
        return item.getPrice() * quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}//classor

public class RestaurantApp {
    private static ArrayList<MenuItem> menuItems = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        populateMenu();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== MENU RESTORAN =====");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).getName() + " - Rp" + menuItems.get(i).getPrice());
        }

        while (true) {
            System.out.print("Pilih nomor menu (0 untuk selesai): ");
            int choice = scanner.nextInt();
            if (choice == 0) break;

            System.out.print("Jumlah: ");
            int quantity = scanner.nextInt();

            if (choice > 0 && choice <= menuItems.size()) {
                orders.add(new Order(menuItems.get(choice - 1), quantity));
            } else {
                System.out.println("Nomor menu tidak valid.");
            }
        }

        System.out.println("\n===== NOTA PEMESANAN =====");
        double total = 0;
        for (Order order : orders) {
            double subtotal = order.calculateSubtotal();  // Menggunakan Custom Live Template untuk perhitungan
            System.out.println(order.getItem().getName() + " - " + order.getQuantity() + " x Rp" + order.getItem().getPrice() + " = Rp" + subtotal);
            total += subtotal;
        }
        System.out.println("Total Pembayaran: Rp" + total);
    }

    private static void populateMenu() {
        menuItems.add(new MenuItem("Nasi Goreng", 15000));
        menuItems.add(new MenuItem("Mie Goreng", 12000));
        menuItems.add(new MenuItem("Sate Ayam", 20000));
        menuItems.add(new MenuItem("Es Teh", 5000));
        menuItems.add(new MenuItem("Es Jeruk", 7000));
    }
}
