package com.example.EmployeeCRUD.dao;

import com.example.EmployeeCRUD.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    //define field for entityManager
    private final EntityManager entityManager;

    //constructor injection
    @Autowired
    public EmployeeDaoImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees=theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //get employee
        Employee theEmployee= entityManager.find(Employee.class,theId);

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save employee
        Employee dbEmployee=entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public Employee deleteById(int theId) {
        //find employee by id
        Employee theEmployee=entityManager.find(Employee.class,theId);

        //remove the employee
        entityManager.remove(theEmployee);

        return theEmployee;
    }

}
