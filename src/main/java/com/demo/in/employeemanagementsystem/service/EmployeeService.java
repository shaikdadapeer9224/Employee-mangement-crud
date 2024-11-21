package com.demo.in.employeemanagementsystem.service;

import com.demo.in.employeemanagementsystem.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer eid);

    Employee updateOrSaveEmployee(Integer eid,Employee employee);

    void deleteEmployee(Integer eid);
}
