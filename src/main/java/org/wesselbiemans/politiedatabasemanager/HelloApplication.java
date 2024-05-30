package org.wesselbiemans.politiedatabasemanager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        showLoginScreen();

        stage.setTitle("PolitieDatabaseManager");
        stage.show();
    }

    public void showLoginScreen() {
        LoginPane loginPane = new LoginPane(this);
        Scene loginScene = new Scene(loginPane, 900, 700);
        primaryStage.setScene(loginScene);
    }

    public void showMainScreen() {
        GridPane mainPane = new GridPane();
        Scene mainScene = new Scene(mainPane, 900, 700);
        // Initialize the mainPane with your main application UI components
        primaryStage.setScene(mainScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
