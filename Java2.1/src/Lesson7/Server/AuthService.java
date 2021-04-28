package Lesson7.Server;

import java.sql.*;

public class AuthService {
    private static Connection connection;
    private static Statement stmt;

    public static void connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:D:/MyProjects/Java/Java2.1/src/main.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNickLoginPass (String login, String pass) {
        String sql = String.format("SELECT nickname FROM users\n" +
                "WHERE login = '%s'\n" +
                "AND password = '%s'\n", login, pass);
        try {
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
