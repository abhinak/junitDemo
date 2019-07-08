package com.endurance.dao;

import com.endurance.entity.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {

    private DataSource ds;

    public EmployeeDao(DataSource ds) {
        this.ds = ds;
    }

    public void create(Employee employee) {
        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c
                    .prepareStatement("INSERT INTO employee (id, first_name, last_name, salary, joining_year) values (?, ?, ?),?,?");
            stmt.setInt(1, employee.getId());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getLastName());
            stmt.setLong(4,employee.getSalary());
            stmt.setInt(5,employee.getJoiningYear());
            stmt.executeUpdate();
            c.close();
        } catch (SQLException e) {
            System.out.println("Exception occured while inserting the data "+e.getMessage());;
        }
    }

    public Employee retrieve(int id) {
        try {
            Connection c = ds.getConnection();
            PreparedStatement stmt = c
                    .prepareStatement("SELECT id, first_name, last_name, salary, joining_year FROM employee WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Employee employee = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),
                    rs.getLong(4),rs.getInt(5));
            c.close();
            return employee;
        } catch (SQLException e) {
            System.out.println("Exception occured while retrieving the data "+e.getMessage());
            return null;
        }
    }
}
