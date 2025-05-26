package com.example.EmployeeCRUD.dao;

import com.example.EmployeeCRUD.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    Employee deleteById(int theId);

}
