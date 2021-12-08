package com.kami.study.apfivethlab.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employer {
    private final IntegerProperty id;
    private final StringProperty firstname;
    private final StringProperty lastname;
    private final StringProperty manager;
    private final IntegerProperty salary;
    private final StringProperty department;
    private final StringProperty city;

    public Employer(int id, String firstname, String lastname, String manager, int salary, String department, String city) {
        this.id = new SimpleIntegerProperty(id);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.manager = new SimpleStringProperty(manager);
        this.salary = new SimpleIntegerProperty(salary);
        this.department = new SimpleStringProperty(department);
        this.city = new SimpleStringProperty(city);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty firstnameProperty() {
        return firstname;
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public StringProperty managerProperty() {
        return manager;
    }

    public IntegerProperty salaryProperty() {
        return salary;
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public StringProperty cityProperty() {
        return city;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getManager() {
        return manager.get();
    }

    public void setManager(String manager) {
        this.manager.set(manager);
    }

    public int getSalary() {
        return salary.get();
    }

    public void setSalary(int salary) {
        this.salary.set(salary);
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }
}
