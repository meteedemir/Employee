package com.example.EmployeeCRUD.controller;

import com.example.EmployeeCRUD.entity.Employee;
import com.example.EmployeeCRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

//    @GetMapping("/")
//    public String home(){
//    return "home";
//    }

    //expose "/employees" and return a list of employees
//    @GetMapping("/employees")
//    public List<Employee> findAll() {
//        return employeeService.findAll();
//    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employee";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }
    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);

        // send over to our form
        return "employees/employee-form";
    }
//    @GetMapping("/edit")
//    public String editEmployee(@RequestParam("employeeId") int id, Model model) {
//        Employee theEmployee = employeeService.findById(id);
//        model.addAttribute("employee", theEmployee);
//        return "employee-form";
//    }
//    @GetMapping("/employees/{employeeId}")
//    public Employee getEmployee(@PathVariable int employeeId){
//
//        Employee theEmployee= employeeService.findById(employeeId);
//
//        if(theEmployee==null){
//            throw new RuntimeException("Employee id not found - "+employeeId);
//        }
//
//        return theEmployee;
//    }

    //add mapping for POST /employees - add new employee
//    @PostMapping("/employees")
//    public Employee addEmployee(@RequestBody Employee theEmployee){
//        //set id to 0
//        //this is to force a save of new item ... instead of update
//
//        theEmployee.setId(0);
//
//        Employee dbEmployee=employeeService.save(theEmployee);
//
//        return dbEmployee;
//    }
//    @PostMapping("/update")
//    public String updateEmployee(@RequestParam("employeeId") int id, Model theModel) {
//        Employee employee=employeeService.findById(id);
//
//        theModel.addAttribute("employee",employee);
//
//        return "employee-form";
//    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        // save the employee
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
//
//    @DeleteMapping("/employees/{employeeId}")
//    public Employee deleteEmployee(@PathVariable int employeeId){
//
//        Employee theEmployee=employeeService.deleteById(employeeId);
//
//        return theEmployee;
//
//    }
    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
}


}
