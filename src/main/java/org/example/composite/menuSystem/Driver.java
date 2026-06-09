package org.example.composite.menuSystem;

public class Driver {
    public static void main(String[] args) {
        Menu mainMenu = new Menu("Main Menu");

        Menu dashboard = new Menu("Dashboard");

        Menu products = new Menu("Products");

        Menu inventory = new Menu("Inventory");

        Menu orders = new Menu("Orders");

        Menu settings = new Menu("Settings");

        MenuItem addProduct =
                new MenuItem("Add Product");

        MenuItem searchProduct =
                new MenuItem("Search Product");

        MenuItem stockReport =
                new MenuItem("Stock Report");

        MenuItem reorderItems =
                new MenuItem("Reorder Items");

        MenuItem createOrder =
                new MenuItem("Create Order");

        MenuItem cancelOrder =
                new MenuItem("Cancel Order");

        MenuItem userManagement =
                new MenuItem("User Management");

        MenuItem roleManagement =
                new MenuItem("Roles & Permissions");

        inventory.add(stockReport);
        inventory.add(reorderItems);

        products.add(addProduct);
        products.add(searchProduct);
        products.add(inventory);

        orders.add(createOrder);
        orders.add(cancelOrder);

        settings.add(userManagement);
        settings.add(roleManagement);

        mainMenu.add(dashboard);
        mainMenu.add(products);
        mainMenu.add(orders);
        mainMenu.add(settings);

        System.out.println("===== MENU =====");

        mainMenu.display("");

        System.out.println();

        System.out.println(
                "Products Folder Item Count = "
                        + products.getMenuItemCount());

        System.out.println();

        MenuComponent found =
                mainMenu.findMenu("Inventory");

        System.out.println(
                "Found Menu = "
                        + found.getName());

        System.out.println();

        System.out.println(
                "===== DISABLING SETTINGS =====");

        settings.disable();

        mainMenu.display("");
    }
}
