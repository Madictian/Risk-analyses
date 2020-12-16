package database;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.*;

public class DatabaseHandler {
    public static User validateUser(Connection conn, String username, String password) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        PreparedStatement statement = conn.prepareStatement(String.format("SELECT * FROM users WHERE username='%s'", username));
        ResultSet result = statement.executeQuery();

        int id, admin;
        String salt, hash;
        while (result.next()) {
            id = result.getInt("id");
            admin = result.getInt("admin");
            username = result.getString("username");
            salt = result.getString("salt");
            hash = result.getString("hash");
            String confirmHash = PBKDF2Hash(password, salt);
            System.out.println(hash);
            System.out.println(confirmHash);
            if (hash.equals(confirmHash)) {
                return new User(id, admin, username);
            } else {
                System.out.println("Incorrect password");
            }
        }
        return null;
    }

    public static byte[][] PBKDF2Hash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 64536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();

        return new byte[][]{hash, salt};
    }

    public static String PBKDF2Hash(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] saltArray = salt.split("qwe");
        byte[] convertedSalt = new byte[saltArray.length];
        for (int i = 0; i < saltArray.length; i++) {
            convertedSalt[i] = Byte.parseByte(saltArray[i]);
        }

        KeySpec spec = new PBEKeySpec(password.toCharArray(), convertedSalt, 64536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] byteHash = factory.generateSecret(spec).getEncoded();

        StringBuilder hashBuilder = new StringBuilder();
        for (byte e : byteHash) {
            hashBuilder.append(e).append("qwe");
        }
        return hashBuilder.toString();
    }

    public static void createUser(Connection conn, int admin, String username, String password) throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException {
        byte[][] hashAndSalt = PBKDF2Hash(password);

        StringBuilder hashBuilder = new StringBuilder();
        for (byte e : hashAndSalt[0]) {
            hashBuilder.append(e).append("qwe");
        }
        String hash = hashBuilder.toString();

        StringBuilder saltBuilder = new StringBuilder();
        for (byte e : hashAndSalt[1]) {
            saltBuilder.append(e).append("qwe");
        }
        String salt = saltBuilder.toString();

        PreparedStatement statement = conn.prepareStatement(String.format("INSERT INTO users (admin, username, salt, hash) VALUES ('%s', '%s', '%s', '%s')", admin, username, salt, hash));
        statement.executeUpdate();
    }

    public static void createTables(Connection conn) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("CREATE TABLE IF NOT EXISTS users(id int NOT NULL AUTO_INCREMENT, admin BOOLEAN, username varchar(255), salt varchar(255) , hash varchar(255), PRIMARY KEY(id))");
        statement.executeUpdate();
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
