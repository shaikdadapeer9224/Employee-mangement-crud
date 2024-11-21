package com.demo.in.employeemanagementsystem.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.demo.in.employeemanagementsystem.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer eid;
    
    @NotEmpty(message = "Employee name should not be empty")
    private String ename;
    
    @NotEmpty(message = "City name should not be empty")
    private String ecity;
    
    @Column(unique = true)
    @NotEmpty(message = "Email id Is Required")
    @Email(message = "email is not valid")
    private String email;
    
    @NotNull(message = "Gender Is Required")
    @Enumerated(EnumType.STRING)
    private Gender egender;
    
    @NotNull(message = "Mobile Number Is Required")
    @Size(min = 10, max = 10, message = "mobile number is not valid")
    private String emobile;

	private boolean delete_status=false;
    
}
