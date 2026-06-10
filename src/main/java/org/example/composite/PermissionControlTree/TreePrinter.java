package org.example.composite.PermissionControlTree;

public class TreePrinter {
    public static void print(Resource resource) {
        print(resource,"");
    }
    public static void print(Resource resource, String indent){
        System.out.println(indent+resource.getName());
        for (Resource child: resource.getChildren()){
            print(child,indent+"  ");
        }
    }

}
