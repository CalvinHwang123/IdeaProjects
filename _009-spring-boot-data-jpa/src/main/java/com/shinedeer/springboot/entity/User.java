package com.shinedeer.springboot.entity;

import javax.persistence.*;

/**
 * @author Calvin Hwang
 * 2018/12/19 21:33
 * User 实体类
 */
@Entity // 告诉 JPA 这是一个实体类（和数据表映射的类）
@Table(name = "tb_user") // 省略则为类名小写
public class User {

    @Id // 这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主键
    private Integer id;
    @Column(name = "last_name")
    private String lastName;
    @Column // 省略则属性名是 字段名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
