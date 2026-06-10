package org.example.composite.ShoppingCartBundle;

import java.util.ArrayList;
import java.util.List;

public class Bundle implements CartItem{
    private final String name;
    private final List<CartItem> children;

    public Bundle(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
    public void add(CartItem cartItem){
        children.add(cartItem);
    }
    public void remove(CartItem cartItem){
        children.remove(cartItem);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        double total=0;
        for (CartItem item:children){
            total+=item.getPrice();
        }
        return total;
    }

    @Override
    public int getItemCount() {
        int count=0;
        for (CartItem item:children){
            count+=item.getItemCount();
        }
        return count;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent+name);
        for (CartItem item:children){
            item.display(indent+"  ");
        }
    }
}
