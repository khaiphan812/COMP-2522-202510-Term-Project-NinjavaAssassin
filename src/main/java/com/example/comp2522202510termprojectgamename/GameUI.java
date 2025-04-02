package com.example.comp2522202510termprojectgamename;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class GameUI {
    private static final int DELAY = 2500;
    private static final int SETTING_1 = 10;
    private static final int SETTING_2 = 40;
    private static final int FONT_SIZE = 18;
    private final Label scoreLabel;
    private final Label lifeLabel;
    private final Pane root;
    private final GameState gameState;

    public GameUI(final Pane root, final GameState gameState) {
        this.root = root;
        this.gameState = gameState;

        scoreLabel = new Label("Score: 0");
        scoreLabel.setTranslateX(SETTING_1);
        scoreLabel.setTranslateY(SETTING_1);
        scoreLabel.setTextFill(Color.WHITESMOKE);
        scoreLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FONT_SIZE));

        lifeLabel = new Label("Lives: 10");
        lifeLabel.setTranslateX(SETTING_1);
        lifeLabel.setTranslateY(SETTING_2);
        lifeLabel.setTextFill(Color.WHITESMOKE);
        lifeLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FONT_SIZE));

        root.getChildren().addAll(scoreLabel, lifeLabel);
    }

    public void updateScore(final int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void updateLives(final int lives) {
        lifeLabel.setText("Lives: " + lives);
    }

    public void showGameOverMessage() {
        Text lostMessage = new Text("Game Over! Your score is "
                + gameState.getScore() + ".\nGame has been reset.");
        lostMessage.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FONT_SIZE));
        lostMessage.setFill(Color.WHITESMOKE);
        lostMessage.setX((GameState.WIDTH - lostMessage.getLayoutBounds().getWidth()) / 2);
        lostMessage.setY((double) GameState.HEIGHT / 2);
        root.getChildren().add(lostMessage);

        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(() ->
                                root.getChildren().remove(lostMessage));
                    }
                },
                DELAY
        );
    }
}
