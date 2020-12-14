package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHandler {
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

            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.printf("Connected to %s '%s'@'%s' on port %s\n", databaseName, username, domain, port);
            return conn;
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
