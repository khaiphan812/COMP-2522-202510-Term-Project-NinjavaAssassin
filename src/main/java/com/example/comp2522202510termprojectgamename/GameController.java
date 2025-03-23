package com.example.comp2522202510termprojectgamename;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.HashSet;
import java.util.Set;

public class GameController {
    @FXML private Pane gamePane;
    @FXML private ImageView player;
    @FXML private ImageView background;

    private final double playerSpeed = 5;
    private final Set<KeyCode> activeKeys = new HashSet<>();

    public void initialize() {
        startGameLoop();
    }

    private void startGameLoop() {
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        gameLoop.start();
    }

    private void update() {
        if (activeKeys.contains(KeyCode.W)) player.setLayoutY(player.getLayoutY() - playerSpeed);
        if (activeKeys.contains(KeyCode.S)) player.setLayoutY(player.getLayoutY() + playerSpeed);
        if (activeKeys.contains(KeyCode.A)) player.setLayoutX(player.getLayoutX() - playerSpeed);
        if (activeKeys.contains(KeyCode.D)) player.setLayoutX(player.getLayoutX() + playerSpeed);
    }

    public void onKeyPressed(KeyCode key) {
        activeKeys.add(key);
    }

    public void onKeyReleased(KeyCode key) {
        activeKeys.remove(key);
    }
}

