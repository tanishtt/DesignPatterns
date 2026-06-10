package org.example.composite.ShoppingCartBundle;

public class Product implements CartItem {
    private final String id;
    private final String name;
    private final double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent+name+" Rs."+price);
    }
}
