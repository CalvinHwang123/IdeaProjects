package com.shinedeer.springboot.controller;

import com.shinedeer.springboot.dao.DepartmentDao;
import com.shinedeer.springboot.dao.EmployeeDao;
import com.shinedeer.springboot.entities.Department;
import com.shinedeer.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Calvin Hwang
 * 2018/12/20 23:14
 * 员工 controller
 */
@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 员工列表页面
     * @return
     */
    @GetMapping("/emps")
    public String toListPage(Model model) {
        model.addAttribute("empList", employeeDao.getAll());

        return "emp/list";
    }

    /**
     * 员工添加页面
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 查询部门
        queryDept(model);

        return "emp/add";
    }

    /**
     * 编辑页面
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditViewPage(@PathVariable Integer id, Model model) {
        Employee emp = employeeDao.get(id);
        model.addAttribute("emp", emp);

        /*// 查询部门
        queryDept(model);
        return "emp/add"; // 来到编辑页面（添加二合一）*/

        // 更简洁写法：转发到 添加页面
        return "forward:/emp";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        return saveAndRedirect2ListPage(employee);
    }

    /**
     * 修改员工
     * @param employee
     * @return
     */
    @PutMapping("emp")
    public String updateEmp(Employee employee) {
        return saveAndRedirect2ListPage(employee);
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @DeleteMapping("emp/{id}")
    public String deleteEmp(@PathVariable Integer id) {
        employeeDao.delete(id);
        // 重定向到员工列表页面
        return "redirect:/emps";
    }

    /**
     * 查询部门
     * @param model
     */
    private void queryDept(Model model) {
        Collection<Department> deptList = departmentDao.getDepartments();
        model.addAttribute("deptList", deptList);
    }

    /**
     * 保存并且转发到列表页面
     * @param employee
     * @return
     */
    private String saveAndRedirect2ListPage(Employee employee) {
        employeeDao.save(employee);
        // 重定向到员工列表页面
        return "redirect:/emps";
    }

}
