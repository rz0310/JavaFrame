package com.bean;

import java.util.List;
import java.util.Map;

public class Student {
    private Integer id;
    private String name;
    private List list;
    private Dog dog;
    private Map map;

    public Student() {
    }

    public Student(Dog dog) {
        this.dog = dog;
    }

    public Student(List list) {
        this.list = list;
    }

    public Student(Map map) {
        this.map = map;
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Integer id, String name, Dog dog) {
        this.id = id;
        this.name = name;
        this.dog = dog;
    }

    public Student(Integer id, String name, List list) {
        this.id = id;
        this.name = name;
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Student(Integer id, String name, List list, Dog dog, Map map) {
        this.id = id;
        this.name = name;
        this.list = list;
        this.dog = dog;
        this.map = map;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                ", dog=" + dog +
                ", map=" + map +
                '}';
    }
}
