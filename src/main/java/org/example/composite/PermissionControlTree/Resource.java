package org.example.composite.PermissionControlTree;

import org.example.composite.PermissionControlTree.enums.Permission;
import org.example.composite.PermissionControlTree.enums.PermissionEffect;

import java.util.ArrayList;
import java.util.List;

//component/composite/leaf
//leaf=0 children.
//composite>0 children.
public class Resource {
    private final String name;
    private Resource parent;
    private final List<Resource> children;
    private final List<PermissionAssignment> assignments;

    public Resource(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public void addChild(Resource child){
        child.parent=this;
        children.add(child);
    }
    public void removeChild(Resource child){
        children.remove(child);
        child.parent=null;
    }

    public String getName() {
        return name;
    }

    public Resource getParent() {
        return parent;
    }

    public List<Resource> getChildren() {
        return children;
    }

    public List<PermissionAssignment> getAssignments() {
        return assignments;
    }

    public void assignPermission(User user, Permission permission, PermissionEffect permissionEffect){
        assignments.add(new PermissionAssignment(user,permission,permissionEffect));
    }
}
