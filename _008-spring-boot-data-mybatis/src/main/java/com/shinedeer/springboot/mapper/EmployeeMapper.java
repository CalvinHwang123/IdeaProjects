package com.shinedeer.springboot.mapper;

import com.shinedeer.springboot.bean.Employee;

/**
 * @author Calvin Hwang
 * 2018/12/19 20:44
 * 员工 Mapper
 */
public interface EmployeeMapper {

    Integer insertEmp(Employee employee);

    Integer deleteEmpById(Integer id);

    Integer updateEmp(Employee employee);

    Employee getEmpById(Integer id);
}
