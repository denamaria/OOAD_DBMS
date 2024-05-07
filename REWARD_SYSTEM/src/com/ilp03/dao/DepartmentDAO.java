package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ilp03.entity.Department;

public class DepartmentDAO 
{
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
	public List<Department> getAllDepartments(Connection connection) {
        List<Department> departmentList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Departments");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int departmentId = resultSet.getInt("department_id");
                String departmentName = resultSet.getString("department_name");

                Department department = new Department(departmentId, departmentName);
                departmentList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentList;
    }
}
