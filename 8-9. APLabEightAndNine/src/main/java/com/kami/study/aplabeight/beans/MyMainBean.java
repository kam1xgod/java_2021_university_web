package com.kami.study.aplabeight.beans;

import com.kami.study.aplabeight.entities.Employee;

import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Startup
@Stateless(name = "MyMainBean")
@LocalBean
public class MyMainBean {

    private ArrayList<Employee> list;

    private Connection getConnection() {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Employee> getAllEmps() {

        // List<EmployeeEntity> employeeEntities = entityManager.createQuery("SELECT '*' FROM employees").getResultList();

        ArrayList<Employee> empList = new ArrayList<>();
        String query = "SELECT * FROM employees";
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Employee employer;
            while (rs.next()) {
                employer = new Employee(rs.getInt("ID"),
                        rs.getString("Firstname"),
                        rs.getString("Lastname"),
                        rs.getString("Manager"),
                        rs.getInt("Salary"),
                        rs.getString("Department"),
                        rs.getString("City"));
                empList.add(employer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return empList;
    }

    public ArrayList<Employee> getById(int id) {
        ArrayList<Employee> employerList = new ArrayList<>();
        String query = "SELECT * FROM employees WHERE ID=" + id;
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Employee employee;
            if (rs.next()) {
                employee = new Employee(rs.getInt("ID"),
                        rs.getString("Firstname"),
                        rs.getString("Lastname"),
                        rs.getString("Manager"),
                        rs.getInt("Salary"),
                        rs.getString("Department"),
                        rs.getString("City"));
                employerList.add(employee);
                return employerList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Employee> getByName(String name) {
        ArrayList<Employee> employerList = new ArrayList<>();
        String query = "SELECT * FROM employees WHERE Firstname=" + "'" + name + "'";
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Employee employee;
            if (rs.next()) {
                employee = new Employee(rs.getInt("ID"),
                        rs.getString("Firstname"),
                        rs.getString("Lastname"),
                        rs.getString("Manager"),
                        rs.getInt("Salary"),
                        rs.getString("Department"),
                        rs.getString("City"));
                employerList.add(employee);
                return employerList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> updateAndGetList() {
        ArrayList<Employee> list = getAllEmps();

        return list;
    }

    public ArrayList<Employee> updateAndGetListById(int id) {
        ArrayList<Employee> list = getById(id);

        return list;
    }

    public ArrayList<Employee> updateAndGetListByName(String name) {
        ArrayList<Employee> list = getByName(name);

        return list;
    }
}
