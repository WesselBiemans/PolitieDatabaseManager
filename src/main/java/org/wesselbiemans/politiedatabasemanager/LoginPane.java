package org.wesselbiemans.politiedatabasemanager;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginPane extends GridPane {
    private TextField usernameField;
    private PasswordField passwordField;
    private HelloApplication app;

    public LoginPane(HelloApplication app) {
        this.app = app;
        initializeUI();
    }

    private void initializeUI() {
        // Set up the layout
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setVgap(8);
        this.setHgap(10);

        // Create UI components
        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        usernameField = new TextField();
        GridPane.setConstraints(usernameField, 1, 0);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> handleLogin());

        // Add components to the grid
        this.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, loginButton);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (DatabaseConnector.verifyCredentials(username, password)) {
            System.out.println("Login successful");
            app.showMainScreen();
        } else {
            System.out.println("Login failed");
        }
    }
}
