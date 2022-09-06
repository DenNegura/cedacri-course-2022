package com.company;

import java.sql.*;

public class Database {
    private Connection connection = null;
    Database(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTable(String nameTable, String filds) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("drop table if exists " + nameTable);
            statement.execute("create table " + nameTable + "( " + filds + " );");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertInto(String tableName, String data) {
        try {
            Statement statement = connection.createStatement();
                    statement.executeUpdate("insert into " + tableName + " values ( " + data + " );");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int delete(String nameTable, String fild, String valueFild) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate("delete from " + nameTable + " where " + fild + " = " + valueFild);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void selectAll(String nameTable, String filds, int count) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select " + filds + " from " + nameTable);
            while (resultSet.next()) {
                for(int i = 1; i <= count; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String select(String nameTable, String fild, String data, int count) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement.executeQuery("select * from " + nameTable + " where " + fild + " = " + data);
            String executeFilds = "";
            if(resultSet.next()) {
                for(int i = 1; i <= count; i++) {
                    executeFilds += resultSet.getString(i) + "\t";
                }
                return executeFilds;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "not data";
    }
    public int update(String nameTable, String fild, String currentData, String newData) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate("update " + nameTable + " set " + fild + " = " + newData + " where " + fild + " = " + currentData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void insertClient(int id, String name, int age) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into client values(?, ?, ?);");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
