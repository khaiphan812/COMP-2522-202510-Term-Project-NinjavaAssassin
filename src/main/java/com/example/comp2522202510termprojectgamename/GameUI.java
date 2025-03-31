package com.example.comp2522202510termprojectgamename;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.Timer;
import java.util.TimerTask;

public class GameUI {
    private final Label scoreLabel;
    private final Label lifeLabel;
    private final Pane root;
    private final GameState gameState;

    public GameUI(Pane root, GameState gameState) {
        this.root = root;
        this.gameState = gameState;

        scoreLabel = new Label("Score: 0");
        scoreLabel.setTranslateX(10);
        scoreLabel.setTranslateY(10);
        scoreLabel.setTextFill(Color.WHITESMOKE);
        scoreLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));

        lifeLabel = new Label("Lives: 10");
        lifeLabel.setTranslateX(10);
        lifeLabel.setTranslateY(40);
        lifeLabel.setTextFill(Color.WHITESMOKE);
        lifeLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 18));

        root.getChildren().addAll(scoreLabel, lifeLabel);
    }

}
