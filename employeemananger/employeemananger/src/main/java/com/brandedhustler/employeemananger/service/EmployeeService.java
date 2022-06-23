package com.brandedhustler.employeemananger.service;

import com.brandedhustler.employeemananger.exception.UserNotFoundException;
import com.brandedhustler.employeemananger.model.Employee;
import com.brandedhustler.employeemananger.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;


    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }



    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);

    }

//    @Transactional
//    public void updateEmployee(Long id,
//                               String name,
//                               String email,
//                               String employeeCode,
//                               String phone,
//                               String imageUrl,
//                               String jobTitle){
//
//        Employee newEmployee = employeeRepo.findById(id).orElseThrow(()-> new IllegalStateException(
//                "Student with id " + id + " does not exist"));
//
//        if (name != null && name.length()>0 && !Objects.equals(newEmployee.getName(), name)){
//            newEmployee.setName(name);
//        }
//
//        if (employeeCode != null && employeeCode.length()>0 && !Objects.equals(newEmployee.getEmployeeCode(), employeeCode)){
//            newEmployee.setEmployeeCode(employeeCode);
//        }
//
//        if (phone != null && phone.length()>0 && !Objects.equals(newEmployee.getPhone(), phone)){
//            newEmployee.setPhone(phone);
//        }
//
//        if (jobTitle != null && jobTitle.length()>0 && !Objects.equals(newEmployee.getJobTitle(), jobTitle)){
//            newEmployee.setJobTitle(jobTitle);
//        }
//
//        if (imageUrl != null && imageUrl.length()>0 && !Objects.equals(newEmployee.getImageUrl(), imageUrl)){
//            newEmployee.setImageUrl(imageUrl);
//        }
//
//        if (email != null && email.length() > 0 && !Objects.equals(newEmployee.getEmail(), email)){
//            Optional<Employee> optionalEmployee = employeeRepo.findEmployeeByEmail(email);
//            if (optionalEmployee.isPresent()){
//                throw new IllegalStateException("email already exist");
//            }
//            newEmployee.setEmail(email);
//        }
//
//
//        //return employeeRepo.save(employee);
//    }


    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() ->new UserNotFoundException("User by id " + id + " not found"));
    }

    public void deleteEmployee(Long id){

        boolean exists = employeeRepo.existsById(id);

        if (!exists){
            throw new IllegalStateException("Student with id " + id + " does not exist");
        }

        employeeRepo.deleteById(id);
       // employeeRepo.deleteEmployeeById(id);
    }

}
