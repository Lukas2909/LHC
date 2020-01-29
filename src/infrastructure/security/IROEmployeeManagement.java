package infrastructure.security;

import human_ressources.Employee;

import java.util.Map;

public interface IROEmployeeManagement {
    public Map<Integer, Employee> getEmployeeInformationMap();
}
