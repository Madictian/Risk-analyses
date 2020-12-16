package main;

import database.DatabaseHandler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField usernameInputField;
    @FXML
    private PasswordField passwordInputField;

    public void login() {
        String username = usernameInputField.getText();
        String password = passwordInputField.getText();
        System.out.println(username);
        System.out.println(password);
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
