package com.training.controller.postgres;

import java.sql.*;

public class SQLOperations {
    public void insertIntoTable(String first_name, String last_name, double experience) throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/trainingdb", "training", "nagito");
        Statement statement = connection.createStatement();
//        int rowUpdate = statement.executeUpdate("INSERT INTO employee(first_name, last_name, dateOfBirth, experience)" +
//                "VALUES('" + first_name + "', '" + last_name + "', ' " + dateOfBirth + "', ' " + experience + "')");
        int rowUpdate = statement.executeUpdate("INSERT INTO employee(first_name, last_name, experience)" +
               "VALUES('" + first_name + "', '" + last_name +  "', ' " + experience + "')");
        System.out.println("Rows updated- " + rowUpdate);
        statement.close();
        connection.close();
    }

    public void deleteFromTable() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/trainingdb", "training", "nagito");
        Statement statement = connection.createStatement();
        int rowUpdate = statement.executeUpdate("DELETE FROM employee WHERE id = 2");
        System.out.println("Rows updated - " + rowUpdate);
        statement.close();
        connection.close();

    }

    public void displayResultSet() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/trainingdb", "training", "nagito");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
        while(resultSet.next()){
            String first_name = resultSet.getString(2);
            String last_name = resultSet.getString(3);
            String email = resultSet.getString(4);
            System.out.println("First Name : " + first_name);
            System.out.println("Last Name : " + last_name);
            System.out.println("Email : " + email);
        }
    }
}
