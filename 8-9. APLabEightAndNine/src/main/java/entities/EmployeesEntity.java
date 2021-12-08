package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employees", schema = "company"/*, catalog = ""*/)
@NamedQueries({
        @NamedQuery(name = "EmployeesEntity.findAll", query = "SELECT e FROM EmployeesEntity e"),
        @NamedQuery(name = "EmployeesEntity.findByName", query = "SELECT e FROM EmployeesEntity e WHERE e.firstname = ?1"),
        @NamedQuery(name = "EmployeesEntity.findByID", query = "SELECT e FROM EmployeesEntity e WHERE e.id = ?1")
})
    public class EmployeesEntity implements Serializable {
    private int id;
    private String firstname;
    private String lastname;
    private String manager;
    private int salary;
    private String department;
    private String city;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "Lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "Manager")
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Basic
    @Column(name = "Salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "Department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeesEntity that = (EmployeesEntity) o;

        if (id != that.id) return false;
        if (salary != that.salary) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (manager != null ? !manager.equals(that.manager) : that.manager != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + salary;
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
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
}
