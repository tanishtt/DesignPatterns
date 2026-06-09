package org.example.composite.organizationHierarchy;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private final long id;
    private String name;
    private String designation;

    private Employee manager;

    private final List<Employee> directReports;

    public Employee(long id, String name, String designation) {
        this.id = id;
        this.name=name;
        this.designation=designation;
        this.directReports = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee getManager() {
        return manager;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    @Override
    public String toString(){
        return id+" - "+name+" ("+designation+") ";
    }
}
