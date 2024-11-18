public class MainApp {
    public static void main(String[] args) {
        Product prod = new Product("Smartphone", 699.99, 50);
        Inventory inv = new Inventory(prod, "Warehouse A");

        inv.showInventory();
        prod.applyStockAdjustment(10);
        inv.showInventory();
    }
}