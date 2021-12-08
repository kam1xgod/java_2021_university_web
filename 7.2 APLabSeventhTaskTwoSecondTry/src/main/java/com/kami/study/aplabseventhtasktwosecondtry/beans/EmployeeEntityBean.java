package com.kami.study.aplabseventhtasktwosecondtry.beans;

import com.kami.study.aplabseventhtasktwosecondtry.entities.Employee;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
public class EmployeeEntityBean implements EmployeeEntityBeanLocal{

    @PersistenceContext(unitName = "APLabSeventhTaskTwoSecondTry")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public EmployeeEntityBean() {
//        super(Employee.class);
    }
}
