package infrastructure.security;

import human_ressources.Employee;

import java.util.HashMap;
import java.util.Map;

public enum EmployeeManagement implements IROEmployeeManagement, IEmployeeManagement{
    instance;
    private Map<Integer, Employee> employeeHashMap = new HashMap<Integer, Employee>();

    public void createEmployee(String name, String type)
    {

    }

    public Map<Integer, Employee> getEmployeeInformationMap(){
        return this.employeeHashMap;
    }

    public void setEmployeeInformationMap(Map<Integer, Employee> employeeInformationMap) {
        this.employeeHashMap = employeeInformationMap;
    }
}
