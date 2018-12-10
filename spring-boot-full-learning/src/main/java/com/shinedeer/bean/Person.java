package com.shinedeer.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Calvin Hwang
 * 2018/11/24 19:56
 * Person 实体类
 */
@Component
@Validated
@ConfigurationProperties(prefix = "person") // 使用 @PropertySource 之前也要加上该注解
@PropertySource(value = "classpath:person.properties")
public class Person {

    // @Value("${person.name}")
    // @Email
    private String name;
    // @Value("#{ 11 * 4 }")
    private String age;
    private Date birthday;
    // @Value("false")
    private Boolean boss;
    private Map<String, Object> map;
    private List<Object> list;
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            ", birthday=" + birthday +
            ", boss=" + boss +
            ", map=" + map +
            ", list=" + list +
            ", dog=" + dog +
            '}';
    }
}
