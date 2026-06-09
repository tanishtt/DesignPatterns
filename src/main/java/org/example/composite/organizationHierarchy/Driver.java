package org.example.composite.organizationHierarchy;

public class Driver {
    public static void main(String[] args) {
        Employee ceo=new Employee(1, "Tanish","CEO");
        OrganizationService org=new OrganizationService(ceo);
        org.addEmployee(2,"Alice","VP Engineering",1);
        org.addEmployee(3,"Bob","VP Sales",1);
        org.addEmployee(4, "David", "Manager", 2);
        org.addEmployee(5, "Emma", "Engineer", 4);
        org.addEmployee(6, "Chris", "Engineer", 4);
        org.addEmployee(7, "Monty", "Data Science", 3);
        org.printHierarchy();
        System.out.println();
        System.out.println(org.findCommonManager(5,6));
        System.out.println();
        System.out.println(org.getReportingChain(5));
        System.out.println();
        System.out.println(org.countSubordinates(2));
        org.moveEmployee(7,4);
        org.removeEmployee(5);
        org.printHierarchy();

    }
}
