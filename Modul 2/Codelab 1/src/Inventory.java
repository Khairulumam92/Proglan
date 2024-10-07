public class Inventory {
    private Product product;
    private String location;

    public Inventory(Product product, String location) {
        this.product = product;
        this.location = location;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void showInventory() {
        System.out.println("Location: " + location);
        product.displayProduct();
    }
}

/*
public class Inventory {
    public Product product;
    public String location;

    public Inventory(Product product, String location) {
        this.product = product;
        this.location = location;
    }

    public void showInventory() {
        System.out.println("Location: " + location);
        product.displayProduct();
    }
}
*/
