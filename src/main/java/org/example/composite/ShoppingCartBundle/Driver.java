package org.example.composite.ShoppingCartBundle;

public class Driver {
    public static void main(String[] args) {
        Product laptop=new Product("P1","Laptop",60000);
        Product mouse=new Product("P2","Mouse",1000);
        Product keyboard =new Product("P3", "Keyboard", 2000);
        Product headset =new Product("P4", "Headset", 3000);
        Product controller =new Product("P5", "Controller", 4000);
        Bundle workFromHome=new Bundle("Work from Home Bundle");
        workFromHome.add(laptop);
        workFromHome.add(mouse);
        workFromHome.add(keyboard);

        Bundle gamingBundle =new Bundle("Gaming Bundle");
        gamingBundle.add(headset);
        gamingBundle.add(controller);

        Bundle megaBundle =new Bundle("Mega Tech Bundle");
        megaBundle.add(workFromHome);
        megaBundle.add(gamingBundle);

        ShoppingCartService cart=new ShoppingCartService();
        cart.add(keyboard);
        cart.add(megaBundle);
        cart.displayCart();
    }
}
