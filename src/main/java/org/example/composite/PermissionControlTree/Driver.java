package org.example.composite.PermissionControlTree;

import org.example.composite.PermissionControlTree.enums.Permission;
import org.example.composite.PermissionControlTree.enums.PermissionEffect;

public class Driver {
    public static void main(String[] args) {
        PermissionService permissionService = new PermissionService();
        User tanish=new User("Tanish");

        Resource organization =
                new Resource("Organization");

        Resource engineering =
                new Resource("Engineering");

        Resource backend =
                new Resource("Backend Team");

        Resource frontend =
                new Resource("Frontend Team");

        Resource serviceA =
                new Resource("Service A");

        Resource serviceB =
                new Resource("Service B");

        organization.addChild(engineering);

        engineering.addChild(backend);
        engineering.addChild(frontend);

        backend.addChild(serviceA);
        backend.addChild(serviceB);

        //Engineering READ ALLOW

        engineering.assignPermission(
                tanish,
                Permission.READ,
                PermissionEffect.ALLOW);

        //ServiceB READ DENY

        serviceB.assignPermission(
                tanish,
                Permission.READ,
                PermissionEffect.DENY);


        System.out.println(permissionService.hasPermission(tanish,serviceA,Permission.READ));
        System.out.println(permissionService.hasPermission(tanish,serviceB,Permission.READ));
        System.out.println();
        TreePrinter.print(organization);

        //ALLOW->DENY->... can be possible
//        Organization
//                READ = ALLOW
//
//                |
//                v
//
//        Engineering
//                READ = DENY
//
//                |
//                v
//
//        Backend Team
//        READ = ALLOW
//
//                |
//                v
//
//        Service A
//        READ = DENY
    }
}
