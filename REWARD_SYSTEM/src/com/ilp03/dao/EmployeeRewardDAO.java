package com.ilp03.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.ilp03.entity.EmployeeRewards;

public class EmployeeRewardDAO 
{	
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
	public List<EmployeeRewards> getAllRewards(Connection connection) {
	    List<EmployeeRewards> rewardList = new ArrayList<>();

	    try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EmployeeRewards");
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            int rewardId = resultSet.getInt("employee_reward_id");
	            int employeeId = resultSet.getInt("employee_id");
	            Date dateReceived = resultSet.getDate("date_received");
	            int performanceId = resultSet.getInt("performance_id");

	            EmployeeRewards reward = new EmployeeRewards(rewardId, employeeId, dateReceived, performanceId);
	            rewardList.add(reward);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Handle or log the exception appropriately
	    }

	    return rewardList;
	}}
