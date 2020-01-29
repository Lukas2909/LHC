package infrastructure.security;

import human_ressources.Employee;

import java.util.Map;

public interface IEmployeeManagement extends IROEmployeeManagement {
    public void setEmployeeInformationMap(Map<Integer, Employee> employeeInformationMap);
}
