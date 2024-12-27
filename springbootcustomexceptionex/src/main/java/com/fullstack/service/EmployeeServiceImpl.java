package com.fullstack.service;

import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.model.Employee;
import com.fullstack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(int empId) {
        if (employeeRepository.findById(empId).isEmpty()) {
            throw new RecordNotFoundException("Employee #ID Does Not Exist");
        }

        return employeeRepository.findById(empId);
    }
}
