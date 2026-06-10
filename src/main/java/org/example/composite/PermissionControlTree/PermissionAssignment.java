package org.example.composite.PermissionControlTree;

import org.example.composite.PermissionControlTree.enums.Permission;
import org.example.composite.PermissionControlTree.enums.PermissionEffect;

public class PermissionAssignment {
    private final User user;
    private final Permission permission;
    private final PermissionEffect permissionEffect;

    public PermissionAssignment(User user, Permission permission, PermissionEffect permissionEffect) {
        this.user = user;
        this.permission = permission;
        this.permissionEffect = permissionEffect;
    }

    public Permission getPermission() {
        return permission;
    }

    public User getUser() {
        return user;
    }

    public PermissionEffect getPermissionEffect() {
        return permissionEffect;
    }
}
