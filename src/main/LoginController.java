package main;

import database.DatabaseHandler;

import database.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
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

    public void changeScreenToRiskManager(ActionEvent e) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("riskManagerView.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void login(ActionEvent e) throws InvalidKeySpecException, SQLException, NoSuchAlgorithmException, IOException {
        String username = usernameInputField.getText();
        String password = passwordInputField.getText();

        Connection conn = DatabaseHandler.getConnection();
        User user = DatabaseHandler.validateUser(conn, username, password);
        if(user == null) {
            System.out.println("Invalid user");
        } else {
            changeScreenToRiskManager(e);
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
