package com.fullstack.controller;

import com.fullstack.model.Employee;
import com.fullstack.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        log.info("@@@@Trying to save data for Employee : "+ employee.getEmpName());
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int empId){
        return ResponseEntity.ok(employeeService.findById(empId));
    }
}
