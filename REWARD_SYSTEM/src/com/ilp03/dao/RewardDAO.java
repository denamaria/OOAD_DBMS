package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ilp03.entity.Rewards;

public class RewardDAO 
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


    public List<Rewards> getAllRewards(Connection connection) {
        List<Rewards> rewardList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Reward");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int technicalRating = resultSet.getInt("Technical_rating");
                int behaviouralRating = resultSet.getInt("Behavioural_rating");
                String performance = resultSet.getString("Performance");

                Rewards rewards= new Rewards(id, technicalRating, behaviouralRating, performance);
                rewardList.add(rewards);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rewardList;
    }
}
