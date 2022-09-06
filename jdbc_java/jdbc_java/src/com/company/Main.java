package com.company;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://192.168.43.184/template", "postgres", "1961");
            System.out.println("\nConnected to the PostgreSQL server successfully.\n");

            Statement statement = connection.createStatement();
            String selectEmployee = "SELECT " +
                    "id_emp, " +
                    "id_branch, " +
                    "rpad(lastname, 15), " +
                    "rpad(firstname, 15), " +
                    "date_emp, " +
                    "salary, " +
                    "commision " +
                    "FROM employee;";
            String insert = "INSERT INTO employee " +
                    "VALUES(20, 7, 'Irina', 'Verlan', to_date('11.11.2019', 'dd.mm.yyyy'), 6100);";
            int rows = statement.executeUpdate(insert);
            System.out.println("\nБыло добавленно " + rows + " строк.");
            ResultSet resultSet = statement.executeQuery(selectEmployee);
            while(resultSet.next()) {
                int id_emp = resultSet.getInt(1);
                int id_branch = resultSet.getInt(2);
                String firstname = resultSet.getString(3);
                String lastname = resultSet.getString(4);
                Date date = resultSet.getDate(5);
                int salary = resultSet.getInt(6);
                double commisiom = resultSet.getDouble(7);
                System.out.println(id_emp + "\t|  " + id_branch + "\t|  " + firstname + "  |  " + lastname + "  |  " + date + "  |  " + salary + "  |  " + commisiom);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}








// /usr/share/java/postgresql-jdbc

// source pgadmin4/bin/activate
//pgadmin4