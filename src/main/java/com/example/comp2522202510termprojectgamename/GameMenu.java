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
import java.util.Objects;

/**
 * Represents the game menu.
 *
 * @author Khai Phan
 * @version 2025
 */
public class GameMenu {
    private static final int WELCOME_SIZE = 30;
    private static final int START_SIZE = 200;
    private static final int INSTRUCTIONS_SIZE = 300;
    private static final int QUIT_SIZE = 400;
    private static final int LAYOUT_100 = 100;
    private static final int LAYOUT_200 = 200;
    private static final int VBOX = 20;
    private final Stage primaryStage;
    private final Scene gameScene;

    /**
     * Constructs the game menu.
     *
     * @param primaryStage the main stage of the game
     * @param gameScene the scene of the game
     */
    public GameMenu(final Stage primaryStage, final Scene gameScene) {
        this.primaryStage = primaryStage;
        this.gameScene = gameScene;
    }
    /**
     * Creates the game menu.
     *
     * @return a Pane object
     */
    public Pane createMenu() {
        Pane menuPane = new Pane();
        menuPane.setStyle("-fx-background-color: rgb(88,79,68);");

        Text welcomeText = new Text("Welcome to NinJava!");
        welcomeText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, WELCOME_SIZE));
        welcomeText.setFill(javafx.scene.paint.Color.WHITE);
        welcomeText.setX((GameState.WIDTH - welcomeText.getLayoutBounds().getWidth()) / 2);
        welcomeText.setY(LAYOUT_100);

        Button startButton = createButton("START", START_SIZE);
        startButton.setOnAction(event -> primaryStage.setScene(gameScene));

        Button instructionButton = createButton("Game Guide", INSTRUCTIONS_SIZE);
        instructionButton.setOnAction(event -> showInstructions());

        Button quitButton = createButton("Quit", QUIT_SIZE);
        quitButton.setOnAction(event -> System.exit(0));

        VBox buttonsContainer = new VBox(VBOX);
        buttonsContainer.setLayoutX((GameState.WIDTH - startButton.getPrefWidth()) / 2
                - LAYOUT_100);
        buttonsContainer.setLayoutY(LAYOUT_200);
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
        instructionsAlert.setTitle("Game Guide");
        instructionsAlert.setHeaderText("NinJava Guide");
        instructionsAlert.setContentText("""
                - Press arrow keys or WASD to move your Ninja.
                - Press SPACE to throw shurikens and destroy the enemies.
                - Enemies move faster as your score gets higher.
                - Kill bosses to earn more points, but it also takes more shots.
                - If an enemy reaches the bottom or touches you, you will lose a life.
                - The game will end if you lose all your lives.""");
        instructionsAlert.showAndWait();
    }

    /**
     * Returns true if the argument is equal to this game menu, else false.
     *
     * @param object an Object
     * @return true if the argument is equal to this game menu, else false
     */
    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        GameMenu gameMenu = (GameMenu) object;
        return Objects.equals(primaryStage, gameMenu.primaryStage)
                && Objects.equals(gameScene, gameMenu.gameScene);
    }

    /**
     * Returns a hashCode for this game menu.
     *
     * @return hashCode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(primaryStage, gameScene);
    }

    /**
     * Returns a string representation of the game menu.
     *
     * @return a string containing game menu's contents
     */
    @Override
    public String toString() {
        return "GameMenu{" + "primaryStage=" + primaryStage
                + ", gameScene=" + gameScene + '}';
    }
}
