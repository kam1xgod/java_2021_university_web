package com.kami.study.aplabseventhtasktwosecondtry.entities;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private int id;
    private String firstname;
    private String lastname;
    private String manager;
    private int salary;
    private String department;
    private String city;

    public Employee(int id, String firstname, String lastname, String manager, int salary, String department, String city) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.manager = manager;
        this.salary = salary;
        this.department = department;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getManager() {
        return manager;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "<tr><td>" + this.id + "</td>" +
                "<td>" + this.firstname + "</td>" +
                "<td>" + this.lastname + "</td>" +
                "<td>" + this.manager + "</td>" +
                "<td>" + this.salary + "</td>" +
                "<td>" + this.department + "</td>" +
                "<td>" + this.city + "</td></tr>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && lastname == employee.lastname && salary == employee.salary && Objects.equals(firstname, employee.firstname) && Objects.equals(manager, employee.manager) && Objects.equals(department, employee.department) && Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, manager, salary, department, city);
    }
}
