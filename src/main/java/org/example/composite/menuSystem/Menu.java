package org.example.composite.menuSystem;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent{
    private final List<MenuComponent> children=new ArrayList<>();

    public Menu(String name) {
        super(name);
    }
    @Override
    public void add(MenuComponent menuComponent){
        children.add(menuComponent);
    }
    @Override
    public void remove(MenuComponent menuComponent){
        children.add(menuComponent);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + (enabled?"[ENABLED]":"[DISABLED]") + name);
        for (MenuComponent menu: children){
            menu.display(indent+"  ");
        }
    }

    @Override
    public int getMenuItemCount() {
        int count=0;
        for (MenuComponent menu:children){
            count+=menu.getMenuItemCount();
        }
        return count;
    }

    @Override
    public void enable() {
        enabled=true;
        for (MenuComponent menu:children){
            menu.enable();
        }
    }

    @Override
    public void disable() {
        enabled=false;
        for (MenuComponent menu:children){
            menu.disable();
        }
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
        for (MenuComponent menu: children){
            MenuComponent found=menu.findMenu(searchName);
            if(found!=null){
                return found;
            }
        }
        return null;
    }
}
