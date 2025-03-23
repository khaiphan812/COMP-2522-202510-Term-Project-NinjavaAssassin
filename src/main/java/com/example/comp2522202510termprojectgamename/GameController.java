package com.example.comp2522202510termprojectgamename;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class GameController {
    @FXML private Pane gamePane;
    @FXML private ImageView player;
    @FXML private ImageView background;

    private final double playerSpeed = 5;
    private final double shurikenSpeed = 7;
    private final Set<KeyCode> activeKeys = new HashSet<>();
    private final ArrayList<ImageView> shurikens = new ArrayList<>();

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

        updateShurikens();
    }

    public void onKeyPressed(KeyCode key) {
        activeKeys.add(key);
        if (key == KeyCode.SPACE) {
            shoot();
        }
    }

    public void onKeyReleased(KeyCode key) {
        activeKeys.remove(key);
    }

    private void shoot() {
        ImageView shuriken = new ImageView("/images/shuriken.png");
        shuriken.setFitWidth(15);
        shuriken.setFitHeight(15);
        shuriken.setLayoutX(player.getLayoutX() + player.getFitWidth() / 2 - 5);
        shuriken.setLayoutY(player.getLayoutY() - 20);

        gamePane.getChildren().add(shuriken);
        shurikens.add(shuriken);
    }

    private void updateShurikens() {
        shurikens.removeIf(shuriken -> {
            shuriken.setLayoutY(shuriken.getLayoutY() - shurikenSpeed);
            if (shuriken.getLayoutY() < 0) {
                gamePane.getChildren().remove(shuriken);
                return true;
            }
            return false;
        });
    }
}

