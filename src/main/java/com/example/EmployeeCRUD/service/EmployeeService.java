package com.example.EmployeeCRUD.service;

import com.example.EmployeeCRUD.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    Employee deleteById(int theId);
}
