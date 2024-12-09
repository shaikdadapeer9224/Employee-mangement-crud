package com.demo.in.employeemanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.in.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.demo.in.employeemanagementsystem.model.Employee;
import com.demo.in.employeemanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

   private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer eid) {
        return employeeRepository.findById(eid).orElseThrow(()->new EmployeeNotFoundException("Employee With ID :"+eid+" Not Exist!"));
    }

    @Override
    public Employee updateOrSaveEmployee(Integer eid, Employee employee) {
        Employee existingEmployee=getEmployeeById(eid);
        if(existingEmployee.getEid()!=0){
            existingEmployee.setEname(employee.getEname());
            existingEmployee.setEgender(employee.getEgender());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setEcity(employee.getEcity());
            existingEmployee.setEmobile(employee.getEmobile());
            return employeeRepository.save(existingEmployee);
        }
        else{
            return employeeRepository.save(employee);
        }
    }

    @Override
    public void deleteEmployee(Integer eid) {
    	Employee emp= employeeRepository.findById(eid).orElseThrow(()-> new EmployeeNotFoundException("Employee With ID :"+eid+" Not Exist!"));
    
        emp.setDelete_status(true);
        employeeRepository.save(emp);
    }

    @Override
    public Employee getEmployeeByEId(Integer eid) {
        return employeeRepository.findById(eid).orElseThrow(()->new EmployeeNotFoundException("Employee With ID :"+eid+" Not Exist!"));
    }
    
}
