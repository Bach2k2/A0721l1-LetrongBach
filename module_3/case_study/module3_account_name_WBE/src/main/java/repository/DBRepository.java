package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBRepository {
    public static String urlJDBC = "jdbc:mysql://localhost:3306/case_study";
    public static String usernameJDBC = "root";
    public static String passwordJDBC = "bach2002";
    private Connection connection;

    public DBRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection=DriverManager.getConnection(urlJDBC,usernameJDBC,passwordJDBC);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.setAutoCommit(false);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Connection getAConnect() {
        return this.connection;
    }
}
