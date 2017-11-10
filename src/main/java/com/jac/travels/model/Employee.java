package com.jac.travels.model;

public class Employee {
    private long id;
    private String name;
    private String mobile;

    public Employee(long id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Employee:{" +
                "id:" + id +
                ", name:" + name +
                ", mobile:" + mobile +
                '}';
    }
}
