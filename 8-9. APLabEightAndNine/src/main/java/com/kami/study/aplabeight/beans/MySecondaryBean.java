package com.kami.study.aplabeight.beans;

import com.kami.study.aplabeight.entities.Employee;
import entities.EmployeesEntity;

import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Startup
@Stateless(name = "MySecondaryBean")
@LocalBean
public class MySecondaryBean {


//    @PersistenceContext
//    EntityManager entityManager;

    private List<Employee> list;

    public String getAllEmps() {

        StringBuilder table = new StringBuilder("");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        List<EmployeesEntity> allEmps;

        try {
            transaction.begin();

            allEmps = entityManager.createNamedQuery("EmployeesEntity.findAll", EmployeesEntity.class).getResultList();

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }


        for (EmployeesEntity emp : allEmps) {
            table.append(emp.toString());
        }

        return table.toString();
    }

    public String getById(int id) {
        StringBuilder table = new StringBuilder("");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        List<EmployeesEntity> employerList;
        try {
            transaction.begin();

            TypedQuery<EmployeesEntity> empByID = entityManager.createNamedQuery("EmployeesEntity.findByID", EmployeesEntity.class);
            empByID.setParameter(1, id);
            employerList = empByID.getResultList();

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }


        for (EmployeesEntity emp : employerList) {
            table.append(emp.toString());
        }

        return table.toString();
    }

    public String getByName(String name) {
        StringBuilder table = new StringBuilder("");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        List<EmployeesEntity> employerList;
        try {
            transaction.begin();

            TypedQuery<EmployeesEntity> empByName = entityManager.createNamedQuery("EmployeesEntity.findByName", EmployeesEntity.class);
            empByName.setParameter(1, name);
            employerList = empByName.getResultList();

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }


        for (EmployeesEntity emp : employerList) {
            table.append(emp.toString());
        }

        return table.toString();
    }
}
