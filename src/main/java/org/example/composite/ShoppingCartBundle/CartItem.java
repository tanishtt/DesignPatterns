package org.example.composite.ShoppingCartBundle;

public interface CartItem {
    String getName();
    double getPrice();
    int getItemCount();
    void display(String indent);
}
