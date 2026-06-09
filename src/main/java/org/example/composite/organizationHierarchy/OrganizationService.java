package org.example.composite.organizationHierarchy;

import java.util.*;

public class OrganizationService {
    private Employee ceo;
    private final Map<Long, Employee> employeeMap;

    public OrganizationService(Employee ceo) {
        this.ceo=ceo;
        this.employeeMap = new HashMap<>();
        this.employeeMap.put(ceo.getId(), ceo);
    }

    //add employee
    public void addEmployee(long id, String name, String designation, long managerId){
        Employee manager=employeeMap.get(managerId);
        if(manager == null){
            throw new IllegalArgumentException("Manager not found");
        }

        Employee employee=new Employee(id, name,designation);
        employee.setManager(manager);
        manager.getDirectReports().add(employee);
        employeeMap.put(id, employee);
    }

    //remove employee
    public void removeEmployee(long employeeId){
        Employee employee=employeeMap.get(employeeId);
        if(employee == null){
            throw new IllegalArgumentException("employee not found.");
        }
        if(employee == ceo){
            throw new IllegalArgumentException("cannot remove CEO");
        }

        Employee manager=employee.getManager();
        manager.getDirectReports().remove(employee);
        for (Employee child: employee.getDirectReports()){
            child.setManager(manager);
            manager.getDirectReports().add(child);
        }
        employeeMap.remove(employeeId);
    }

    //find manager
    public Employee getManager(long employeeId) {
        Employee employee=employeeMap.get(employeeId);
        if(employee == null){
            return null;
        }
        return employee.getManager();
    }

    //get direct reports
    public List<Employee> getDirectReports(long employeeId){
        Employee employee= employeeMap.get(employeeId);
        if(employee==null){
            return Collections.emptyList();
        }
        return employee.getDirectReports();
    }
    //reporting chain
    public List<Employee> getReportingChain(long employeeId){
        Employee current=employeeMap.get(employeeId);
        List<Employee> result=new ArrayList<>();
        while (current!=null){
            result.add(current);
            current=current.getManager();
        }
        return result;
    }
    //count subordinates
    public int countSubordinates(long employeeId){
        Employee employee=employeeMap.get(employeeId);
        if(employee==null){
            return 0;
        }
        return dfsCount(employee);
    }
    private int dfsCount(Employee employee){
        int count=0;
        for(Employee child: employee.getDirectReports()){
            count++;
            count+=dfsCount(child);
        }
        return count;
    }
    //move employee
    public void moveEmployee(long employeeId, long newManagerId) {
        Employee employee=employeeMap.get(employeeId);
        Employee newManager=employeeMap.get(newManagerId);

        if(employee==null || newManager == null){
            throw new IllegalArgumentException();
        }
        if(employee == ceo){
            throw new IllegalArgumentException("CEO cant be moved.");
        }
        Employee oldManager=employee.getManager();
        oldManager.getDirectReports().remove(employee);
        newManager.getDirectReports().add(employee);
        employee.setManager(newManager);
    }
    //lowest common Manager
    public Employee findCommonManager(long employee1, long employee2) {
        Employee e1=employeeMap.get(employee1);
        Employee e2=employeeMap.get(employee2);
        Set<Employee> ancestors=new HashSet<>();
        while (e1!=null){
            ancestors.add(e1);
            e1=e1.getManager();
        }
        while(e2!=null){
            if(ancestors.contains(e2)){
                return e2;
            }
            e2=e2.getManager();
        }

        return null;
    }
    //print hierarchy
    public void printHierarchy(){
        print(ceo, "");
    }
    private void print(Employee employee, String prefix){
        System.out.println(prefix + employee);
        List<Employee> children=employee.getDirectReports();
        for(int i=0;i<children.size();i++){
            print(children.get(i), prefix+"  ");
        }
    }

}
