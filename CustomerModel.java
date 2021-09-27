package com.example.myapplication;

public class CustomerModel {

    private int id;
    private String name;
    private int age;
    private String isActive;

    //constructors


    public CustomerModel(int id, String name, int age, String isActive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }

    public CustomerModel() {
    }

    @Override
    public String toString() {
        return ""+ " flavor="+ name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String isActive() {
        return isActive;
    }

    public void setActive(String active) {
        isActive = active;
    }
}
