package database;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;


public class DatabaseHandler {
    @FXML
    private TextField usernameInputField;
    @FXML
    private PasswordField passwordInputField;


    public static void createUser(Connection conn, int admin, String username, String password) throws SQLException {
        // insert hashing algorithm here

        PreparedStatement create = conn.prepareStatement(String.format("INSERT INTO users (admin, username, password) VALUES ('%s', '%s', '%s')", admin, username, password));
        create.executeUpdate();
    }

    public static void createTables(Connection conn) throws SQLException {
        PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS users(id int NOT NULL AUTO_INCREMENT, admin BOOLEAN, username varchar(255), password varchar(255), PRIMARY KEY(id))");
        create.executeUpdate();
    }

    public static Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String domain = "localhost";
            String port = "3306";
            String databaseName = "risk_manager";
            String username = "root";
            String password = "";
            String url = String.format("jdbc:mysql://%s:%s/%s", domain, port, databaseName);
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.printf("Connected to %s '%s'@'%s' on port %s\n", databaseName, username, domain, port);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
