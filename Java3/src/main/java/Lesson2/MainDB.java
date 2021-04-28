package Lesson2;

import javax.swing.*;
import java.sql.*;

public class MainDB {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disConnect() throws  ClassNotFoundException, SQLException {
        connection.close();      
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rs = stmt.executeQuery("SELECT * FROM students");

        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.println(rsmd.getColumnName(i));
        }

        while (rs.next()){
            System.out.println(rs.getString(2));
        }

        disConnect();

    }
}
