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

    public GameMenu(final Stage primaryStage, final Scene gameScene) {
        this.primaryStage = primaryStage;
        this.gameScene = gameScene;
    }

    public Pane createMenu() {
        Pane menuPane = new Pane();
        menuPane.setStyle("-fx-background-color: rgba(34,15,15,0.91);");

        Text welcomeText = new Text("Welcome to NinJava!");
        welcomeText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 30));
        welcomeText.setFill(javafx.scene.paint.Color.WHITE);
        welcomeText.setX((GameState.WIDTH - welcomeText.getLayoutBounds().getWidth()) / 2);
        welcomeText.setY(100);

        Button startButton = createButton("START", 200);
        startButton.setOnAction(event -> primaryStage.setScene(gameScene));

        Button instructionButton = createButton("Instructions", 300);
        instructionButton.setOnAction(event -> showInstructions());

        Button quitButton = createButton("Quit", 400);
        quitButton.setOnAction(event -> System.exit(0));

        VBox buttonsContainer = new VBox(20);
        buttonsContainer.setLayoutX((GameState.WIDTH - startButton.getPrefWidth()) / 2 - 100);
        buttonsContainer.setLayoutY(200);
        buttonsContainer.getChildren().addAll(startButton, instructionButton, quitButton);
        menuPane.getChildren().addAll(welcomeText, buttonsContainer);

        return menuPane;
    }

    private Button createButton(final String text, final double y) {
        Button button = new Button(text);
        button.setLayoutX((GameState.WIDTH - button.getPrefWidth()) / 2);
        button.setLayoutY(y);
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setStyle("-fx-background-color: rgba(21,10,10,0.44);"
                + "-fx-font-size: 20; -fx-font-weight: bold; -fx-padding: 10 20;");
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

    private void showInstructions() {
        Alert instructionsAlert = new Alert(AlertType.INFORMATION);
        instructionsAlert.setTitle("Instructions");
        instructionsAlert.setHeaderText("NinJava Guide");
        instructionsAlert.setContentText("Press WASD or arrow keys to move your Ninja.\n"
                + "Press SPACE to throw shurikens and destroy the enemies.\n"
                + "Enemies move faster as you reach a higher score.\n"
                + "Killing special bosses earn you more points.\n"
                + "If an enemy reaches the bottom or touches you, you'll lose a life.\n"
                + "The game resets if you lose all lives.");
        instructionsAlert.showAndWait();
    }

}
