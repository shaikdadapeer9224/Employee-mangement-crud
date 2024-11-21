package com.demo.in.employeemanagementsystem.controller;

import com.demo.in.employeemanagementsystem.model.Employee;
import com.demo.in.employeemanagementsystem.service.EmployeeService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@Tag(name = "Employee Management System", description = "Employee Management System APIs")
@RequestMapping(value = "/employee")
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /*
        URL : http://localhost:8080/swagger-ui/index.html
        Input :
            {
                "eid": 1,
                "ename": "dadapeer",
                "ecity": "guntur",
                "email": "dadapeer@gmail.com",
                "egender": "MALE",
                "emobile": "7780798117"
                }
     */
    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody  Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(value = "/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(value = "/{eid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer eid){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(eid), HttpStatus.OK);
    }

    @PutMapping(value = "/updateEmployee/{eid}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer eid, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateOrSaveEmployee(eid,employee),HttpStatus.OK);
    }


    @DeleteMapping(value = "/deleteEmployee/{eid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer eid){
     employeeService.deleteEmployee(eid);
     return new ResponseEntity<String>("Employee with ID: "+eid+" deleted successfully",HttpStatus.OK);
    }


}
