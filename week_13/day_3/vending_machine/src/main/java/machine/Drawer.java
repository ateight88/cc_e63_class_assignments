package machine;

import products.Product;

import java.util.ArrayList;

public class Drawer {
    private ArrayList<Product> products;
    private KeyCode code;
    private double price;

    public Drawer(KeyCode code, double price) {
        this.code = code;
        this.price = price;
        products = new ArrayList<>();
    }

    public KeyCode getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public int productCount(){
        return this.products.size();
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public Product sellProduct(){
        return this.products.remove(0);
    }
}
