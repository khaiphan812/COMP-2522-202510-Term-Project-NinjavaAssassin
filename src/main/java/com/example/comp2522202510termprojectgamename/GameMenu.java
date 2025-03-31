package com.example.comp2522202510termprojectgamename;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameMenu {
    private final Stage primaryStage;
    private final Scene gameScene;

    public GameMenu(Stage primaryStage, Scene gameScene) {
        this.primaryStage = primaryStage;
        this.gameScene = gameScene;
    }

    public Pane createMenu() {
        Pane menuPane = new Pane();
        menuPane.setStyle("-fx-background-color: rgba(19,19,19,0.91);");

        Text welcomeText = new Text("Welcome to NinJava!");
        welcomeText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        welcomeText.setFill(javafx.scene.paint.Color.WHITE);
        welcomeText.setX((GameState.WIDTH - welcomeText.getLayoutBounds().getWidth()) / 2);
        welcomeText.setY(100);

        Button startButton = createButton
    }
    private Button createButton(String text, double y) {
        Button button = new Button(text);
        button.setLayoutX((GameState.WIDTH - button.getPrefWidth()) / 2);
        button.setLayoutY(y);
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setStyle("-fx-background-color: rgba(21,10,10,0.44); -fx-font-size: 20; -fx-font-weight: bold; -fx-padding: 10 20;");
        button.setOnMouseEntered(event -> {
            button.setTextFill(javafx.scene.paint.Color.YELLOW);
            button.setEffect(new Glow());
        });
        button.setOnMouseExited(event -> {
            button.setTextFill(javafx.scene.paint.Color.WHITE);
            button.setEffect(null);
        });
        return button;
    }

}
