package com.shinedeer.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Calvin Hwang
 * 2018/11/30 20:47
 * Person 实体类
 */
@Component
// @ConfigurationProperties(prefix = "person")
@PropertySource(value = "classpath:person.properties")
public class Person {

    @Value("${person.name}")
    private String name;
    @Value("true")
    private Boolean boss;
    @Value("2018/1/1")
    private Date birthday;
    private Map<String, Object> map;
    private List<Object> list;
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
            ", boss=" + boss +
            ", birthday=" + birthday +
            ", map=" + map +
            ", list=" + list +
            ", dog=" + dog +
            '}';
    }
}
