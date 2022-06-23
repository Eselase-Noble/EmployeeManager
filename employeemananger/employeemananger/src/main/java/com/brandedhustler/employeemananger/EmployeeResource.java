package com.brandedhustler.employeemananger;


import com.brandedhustler.employeemananger.model.Employee;
import com.brandedhustler.employeemananger.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;


    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getAllEmployeesById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);

    }


    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);

    }

//    @PutMapping(path = "/update/{id}")
//    public void updateStudent(@PathVariable("id") Long  id,
//                              @RequestParam(required = false) String name,
//                              @RequestParam(required = false) String email,
//                              @RequestParam(required = false) String employeeCode,
//                              @RequestParam(required = false) String phone,
//                              @RequestParam(required = false) String imageUrl,
//                              @RequestParam(required = false) String jobTitle){
//
//        employeeService.updateEmployee(id, name, email, employeeCode, phone, imageUrl ,jobTitle );
//
//    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id){
         employeeService.deleteEmployee(id);
        return new ResponseEntity<>( HttpStatus.OK);

    }


}
