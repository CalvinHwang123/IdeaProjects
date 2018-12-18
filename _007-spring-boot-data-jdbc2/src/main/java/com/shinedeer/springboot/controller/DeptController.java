package com.shinedeer.springboot.controller;

import com.shinedeer.springboot.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Calvin Hwang
 * 2018/12/18 20:51
 * 部门 controller
 */
@RestController
public class DeptController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/depts")
    public Map<String, Object> getDept() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList(
            "SELECT * FROM department");
        return list != null && list.size() > 0 ? list.get(0) : null;
    }
}
