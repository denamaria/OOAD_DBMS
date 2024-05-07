package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ilp03.entity.Department;
import com.ilp03.entity.Employee;

public class EmployeeDAO {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/reward_system";
        String userName = "root";
        String password = "2346719";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getEmployeesByPerformance(String performance) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT Employees.first_name, Employees.last_name, Departments.department_name " +
                       "FROM Employees " +
                       "JOIN EmployeePerformance ON Employees.employee_id = EmployeePerformance.employee_id " +
                       "JOIN Reward ON EmployeePerformance.technical_rating = Reward.Technical_rating " +
                       "             AND EmployeePerformance.behavioural_rating = Reward.Behavioural_rating " +
                       "JOIN Departments ON Employees.department_id = Departments.department_id " +
                       "WHERE Reward.Performance = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, performance);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String firstName = resultSet.getString(1);
                    String lastName = resultSet.getString(1);
                    String departmentName = resultSet.getString(3);

                    Employee employee = new Employee(firstName, lastName, departmentName);
                    employees.add(employee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }}
