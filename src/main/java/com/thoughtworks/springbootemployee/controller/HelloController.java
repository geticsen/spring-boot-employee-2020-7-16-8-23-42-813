package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class HelloController {
    private List<Employee> employees = new ArrayList<>();

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAll() {
        return employees;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return employee;
    }
    @PutMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee modifyEmployee(@PathVariable Integer employeeId, @RequestBody Employee employee){
        employees.forEach(employee1 -> {
            if(employee1.getId().equals(employeeId)){
                employee1.setAge(employee.getAge());
                employee1.setGender(employee.getGender());
                employee1.setName(employee.getName());
            }
        });
        return  employee;
    }
}
