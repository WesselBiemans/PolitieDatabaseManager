package org.wesselbiemans.politiedatabasemanager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginPane extends GridPane {

    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;

    public LoginPane(HelloApplication app) {
        initializePane(app);
    }

    private void initializePane(HelloApplication app) {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));

        // Add title label
        Label titleLabel = new Label("Politie Database Manager");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        add(titleLabel, 0, 0, 2, 1); // span 2 columns

        // Adjust row indices for username and password fields
        Label usernameLabel = new Label("Username:");
        usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();

        loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleLogin(app));

        add(usernameLabel, 0, 1);
        add(usernameField, 1, 1);
        add(passwordLabel, 0, 2);
        add(passwordField, 1, 2);
        add(loginButton, 1, 3);
    }

    private void handleLogin(HelloApplication app) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Replace with actual authentication logic
        if ("admin".equals(username) && "password".equals(password)) {
            System.out.println("Login successful");
            app.showMainScreen();
        } else {
            System.out.println("Login failed");
        }
    }
}
