package com.shinedeer.bean;

/**
 * @author Calvin Hwang
 * 2018/11/24 19:58
 * Dog 实体类
 */
public class Dog {

    private String name;
    private String color;
    private String bark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBark() {
        return bark;
    }

    public void setBark(String bark) {
        this.bark = bark;
    }

    @Override
    public String toString() {
        return "Dog{" +
            "name='" + name + '\'' +
            ", color='" + color + '\'' +
            ", bark='" + bark + '\'' +
            '}';
    }
}
