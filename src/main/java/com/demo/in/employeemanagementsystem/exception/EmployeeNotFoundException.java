package com.demo.in.employeemanagementsystem.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String str){
        super(str);
    }
}
