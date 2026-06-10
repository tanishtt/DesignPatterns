package org.example.composite.ShoppingCartBundle;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService {
    private final List<CartItem> items=new ArrayList<>();
    public void add(CartItem item){
        items.add(item);
    }
    public void remove(CartItem item){
        items.remove(item);
    }
    public double getTotalPrice(){
        double total=0;
        for (CartItem item:items){
            total+=item.getPrice();
        }
        return total;
    }

    public int getTotalItemCount(){
        int count=0;
        for (CartItem item:items){
            count+=item.getItemCount();
        }
        return count;
    }
    public void displayCart() {

        System.out.println("\n===== CART =====");

        for (CartItem item : items) {
            item.display("");
        }

        System.out.println("----------------");
        System.out.println("Items : " + getTotalItemCount());
        System.out.println("Total : Rs." + getTotalPrice());
    }
}
