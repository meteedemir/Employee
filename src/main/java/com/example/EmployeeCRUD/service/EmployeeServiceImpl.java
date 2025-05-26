package com.example.EmployeeCRUD.service;

import com.example.EmployeeCRUD.exception.EmployeeAlreadyExistsException;
import com.example.EmployeeCRUD.exception.NoSuchEmployeeExistsException;
import com.example.EmployeeCRUD.dao.EmployeeDao;
import com.example.EmployeeCRUD.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao theEmployeeDao){
        employeeDao=theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return Optional.ofNullable(employeeDao.findById(theId))
                .orElseThrow(() -> new NoSuchElementException("No Employee Present with id: " + theId));
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDao.save(theEmployee);
    }

    @Transactional
    @Override
    public Employee deleteById(int theId) {
        return employeeDao.deleteById(theId);

    }
}
