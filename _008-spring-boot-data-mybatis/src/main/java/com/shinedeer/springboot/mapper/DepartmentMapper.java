package com.shinedeer.springboot.mapper;

import com.shinedeer.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author Calvin Hwang
 * 2018/12/19 19:37
 * 部门 Mapper
 */
// @Mapper // 一个个写 @Mapper 太麻烦，直接 @MapperScan 加在配置类或主程序类
public interface DepartmentMapper {

    @Select("select * from department where id = #{ id }")
    Department getDeptById(Integer id);

    @Delete("delete from department where id = #{ id }")
    Integer deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id") // 使得 return insert 的数据有 id
    @Insert("insert into department (department_name) values (#{ departmentName })")
    Integer insertDept(Department department);

    @Update("update department set department_name = #{ departmentName } where id = #{ id }")
    Integer updateDept(Department department);

}
