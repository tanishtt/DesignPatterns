package org.example.composite.menuSystem;

public class MenuItem extends MenuComponent{
    public MenuItem(String name) {
        super(name);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + (enabled?"[ENABLED]":"[DISABLED]") + name);
    }

    @Override
    public int getMenuItemCount() {
        return 1;
    }

    @Override
    public void enable() {
        enabled=true;
    }

    @Override
    public void disable() {
        enabled=false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public MenuComponent findMenu(String searchName) {
        if(name.equalsIgnoreCase(searchName)){
            return this;
        }
        return null;
    }
}
