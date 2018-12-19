package com.shinedeer.springboot.controller;

import com.shinedeer.springboot.bean.Employee;
import com.shinedeer.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Calvin Hwang
 * 2018/12/19 20:57
 * 员工 controller
 */
@RestController
public class EmpController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @PostMapping("/emps")
    public Employee insertOne(Employee employee) {
        employeeMapper.insertEmp(employee);
        return employee;
    }

    @GetMapping("/emps/{id}")
    public Employee findOne(@PathVariable Integer id) {
        return employeeMapper.getEmpById(id);
    }

}
