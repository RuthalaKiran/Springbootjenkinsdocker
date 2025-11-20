package com.service;

import com.document.Employee;
import com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public String storeEmployee(Employee employee){
        Optional<Employee> optionalemp = employeeRepository.findById(employee.getId());
        if(optionalemp.isPresent()){
            return "Employee id must be unique";
        }else{
            employeeRepository.save(employee);
            return "employee record stored successfylly";
        }
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public String update(Employee employee){
        Optional<Employee> optionalemp = employeeRepository.findById(employee.getId());
        if(optionalemp.isPresent()){
            employeeRepository.save(employee);
//            employeeRepository.fl
            return "updated price successfully";
        }else{
            return "employee no found";
        }
    }
}
