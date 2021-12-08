package com.kami.study.apfivethlab;

import com.kami.study.apfivethlab.model.Employer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class MainController implements Initializable {


    public TextField idField;
    public TextField firstnameField;
    public TextField lastnameField;
    public TextField managerField;
    public TextField salaryField;
    public TextField departmentField;
    public TextField cityField;
    public Button addButton;
    public Button editButton;
    public Button deleteButton;
    public Button byIdButton;
    public TableView<Employer> table;
    public TableColumn<Employer, Integer> idCol;
    public TableColumn<Employer, String> fNameCol;
    public TableColumn<Employer, String> lNameCol;
    public TableColumn<Employer, String> managerCol;
    public TableColumn<Employer, Integer> salaryCol;
    public TableColumn<Employer, String> departmentCol;
    public TableColumn<Employer, String> cityCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateTable(true, 0);
    }

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

    public ObservableList<Employer> allEmp() {
        ObservableList<Employer> empList = FXCollections.observableArrayList();
        String query = "SELECT * FROM employees ";
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;

        try {
            assert conn != null;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Employer employer;
            while (rs.next()) {
                employer = new Employer(rs.getInt("ID"),
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

    public void add() {
        String query = "INSERT INTO employees VALUES("
                + idField.getText() + ", '"
                + firstnameField.getText() + "', '"
                + lastnameField.getText() + "', '"
                + managerField.getText() + "', "
                + Integer.parseInt(salaryField.getText()) + ", '"
                + departmentField.getText() + "', '"
                + cityField.getText() + "')";
        executeQuery(query);
        updateTable(true, 0);
    }

    public void delete() {
        String query = "DELETE FROM employees WHERE ID=" + Integer.parseInt(idField.getText());
        executeQuery(query);
        updateTable(true, 0);
    }

    public void edit() {
        String query = "UPDATE employees SET " +
                "Firstname='" + firstnameField.getText() +
                "', Lastname='" + lastnameField.getText() +
                "', Manager='" + managerField.getText() +
                "', Salary=" + Integer.parseInt(salaryField.getText()) +
                ", Department='" + departmentField.getText() +
                "', City='" + cityField.getText() +
                "' WHERE ID=" + Integer.parseInt(idField.getText());
        executeQuery(query);
        updateTable(true, 0);
    }

    public ObservableList<Employer> getById(int id) {
        ObservableList<Employer> employerList = FXCollections.observableArrayList();
        String query = "SELECT * FROM employees WHERE ID=" + id;
        Connection conn = getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Employer employer;
            if (rs.next()) {
                employer = new Employer(rs.getInt("ID"),
                        rs.getString("Firstname"),
                        rs.getString("Lastname"),
                        rs.getString("Manager"),
                        rs.getInt("Salary"),
                        rs.getString("Department"),
                        rs.getString("City"));
                employerList.add(employer);
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

    public void updateTable(boolean getAll, int id) {
        ObservableList<Employer> list = allEmp();

        if ((!getAll) && (id>0)) {
            list = getById(id);
        }

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("Firstname"));
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
        managerCol.setCellValueFactory(new PropertyValueFactory<>("Manager"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        departmentCol.setCellValueFactory(new PropertyValueFactory<>("Department"));
        cityCol.setCellValueFactory(new PropertyValueFactory<>("City"));

        table.setItems(list);
    }

    public void addButtonAction(ActionEvent actionEvent) {
        add();
    }

    public void editButtonAction(ActionEvent actionEvent) {
        edit();
    }

    public void deleteButtonAction(ActionEvent actionEvent) {
        delete();
    }

    public void byIdButtonAction(ActionEvent actionEvent) {
        updateTable(false, Integer.parseInt(idField.getText()));
    }
}