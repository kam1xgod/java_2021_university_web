package com.kami.study.aplabseventhtasktwosecondtry.beans;

import com.kami.study.aplabseventhtasktwosecondtry.entities.Employee;
import jakarta.ejb.Remote;


import java.util.ArrayList;

@Remote
public interface MyMainBeanRemote {

    ArrayList<Employee> getAllEmps();
    ArrayList<Employee> getById(int id);
    ArrayList<Employee> getByName(String name);
    ArrayList<Employee> updateAndGetList();
    ArrayList<Employee> updateAndGetListById(int id);
    ArrayList<Employee> updateAndGetListByName(String name);
}
