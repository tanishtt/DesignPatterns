package org.example.composite.PermissionControlTree;

import org.example.composite.PermissionControlTree.enums.Permission;
import org.example.composite.PermissionControlTree.enums.PermissionEffect;

public class PermissionService {
    public boolean hasPermission(User user, Resource resource, Permission permission){
        Resource current=resource;
        while (current!=null){
            for (PermissionAssignment assignment:current.getAssignments()){
                if(assignment.getUser().getId().equals(user.getId()) && assignment.getPermission() == permission){
                    return assignment.getPermissionEffect() == PermissionEffect.ALLOW;
                }
            }
            current=current.getParent();
        }

        return false;
    }
}
