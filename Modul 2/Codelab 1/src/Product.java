public class Product {
    private String name;
    private double price;
    private int stock;
    private static final double DISCOUNT_RATE = 0.1;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double calculateDiscount() {
        return price * (1 - DISCOUNT_RATE);
    }

    public void displayProduct() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Discounted Price: $" + calculateDiscount());
        System.out.println("Stock: " + stock);
    }

    public void applyStockAdjustment(int adjustment) {
        stock += adjustment;
        System.out.println("Stock adjusted. New stock: " + stock);
    }
}

/*
public class Product {
    public String name;
    public double price;
    public int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void displayProduct() {
        double discountedPrice = price * 0.9; // 10% discount
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Discounted Price: $" + discountedPrice);
        System.out.println("Stock: " + stock);
    }

    public void applyStockAdjustment(int adjustment) {
        stock += adjustment;
        System.out.println("Stock adjusted. New stock: " + stock);
    }
}
*/