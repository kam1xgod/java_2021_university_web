package com.kami.study.aplabseventhtasktwosecondtry.beans;

import com.kami.study.aplabseventhtasktwosecondtry.entities.Employee;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;

import java.util.ArrayList;

@Local
public interface MyMainBeanLocal {

    ArrayList<Employee> getAllEmps();
    ArrayList<Employee> getById(int id);
    ArrayList<Employee> getByName(String name);
    ArrayList<Employee> updateAndGetList();
    ArrayList<Employee> updateAndGetListById(int id);
    ArrayList<Employee> updateAndGetListByName(String name);
}
