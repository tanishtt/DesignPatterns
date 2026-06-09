package org.example.composite.menuSystem;

public abstract class MenuComponent {
   protected String name;
   protected boolean enabled=true;
   public MenuComponent(String name){
       this.name=name;
   }
   public String getName(){
       return this.name;
   }

   //composite operations
    public void add(MenuComponent menuComponent){
       throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    //business operations
    public abstract void display(String indent);
    public abstract int getMenuItemCount();
    public abstract void enable();
    public abstract void disable();
    public abstract boolean isEnabled();
    public abstract MenuComponent findMenu(String name);
}
