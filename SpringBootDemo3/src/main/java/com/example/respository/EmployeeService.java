package com.example.respository;


import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> retrieveEmployees();

    Employee getEmployee(Long employeeId);

    void saveEmployee(Employee employee);

    void deleteEmployee(Long employeeId);

    void updateEmployee(Employee employee);
}
