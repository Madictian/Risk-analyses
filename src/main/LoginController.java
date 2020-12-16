package main;

import database.DatabaseHandler;

import database.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField usernameInputField;
    @FXML
    private PasswordField passwordInputField;

    public void login() throws InvalidKeySpecException, SQLException, NoSuchAlgorithmException {
        String username = usernameInputField.getText();
        String password = passwordInputField.getText();

        Connection conn = DatabaseHandler.getConnection();
        User user = DatabaseHandler.validateUser(conn, username, password);
        if(user == null) {
            System.out.println("Invalid user");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection conn = DatabaseHandler.getConnection();
            DatabaseHandler.createTables(conn);
            //DatabaseHandler.createUser(conn,1,"admin","admin1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
