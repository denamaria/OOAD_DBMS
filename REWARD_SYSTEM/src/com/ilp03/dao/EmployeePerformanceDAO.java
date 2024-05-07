package com.ilp03.dao;

import com.ilp03.entity.EmployeePerformance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePerformanceDAO {

	public static Connection getConnection() 
	{
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
	public static void   closeConnection(Connection connection)
	{
		try {
			connection.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<EmployeePerformance> getAllPerformances(Connection connection) {
        List<EmployeePerformance> performanceList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EmployeePerformance");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int performanceId = resultSet.getInt("performance_id");
                int employeeId = resultSet.getInt("employee_id");
                Date performanceDate = resultSet.getDate("performance_date");
                int reviewerId = resultSet.getInt("reviewer_id");
                int technicalRating = resultSet.getInt("technical_rating");
                int behaviouralRating = resultSet.getInt("behavioural_rating");

                EmployeePerformance performance = new EmployeePerformance(
                        performanceId, employeeId, performanceDate, reviewerId, technicalRating, behaviouralRating);
                performanceList.add(performance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            
        }

        return performanceList;
    }
}
