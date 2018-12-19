package com.shinedeer.springboot.controller;

import com.shinedeer.springboot.bean.Department;
import com.shinedeer.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Calvin Hwang
 * 2018/12/19 19:43
 * 部门 controller
 */
@RestController
public class DeptController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/depts/{id}")
    public Department getOne(@PathVariable Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @PostMapping("/depts")
    public Department insertOne(Department department) {
        departmentMapper.insertDept(department);
        return department; // 返回新增的记录
    }

}
