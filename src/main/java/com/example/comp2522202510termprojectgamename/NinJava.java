package com.example.comp2522202510termprojectgamename;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class NinJava extends Application {

    private GameState gameState;
    private GameUI gameUI;
    private GameLogic gameLogic;
    private ImageView playerView;

    public static void main(final String[] args) {
        launch(args);
    }

    private void addBackground(final Pane root) {
        Image bgImage = new Image(Objects.requireNonNull(getClass().
                getResourceAsStream("/images/bg-dark.jpg")));
        ImageView bgView = new ImageView(bgImage);
        bgView.setFitWidth(GameState.WIDTH);
        bgView.setFitHeight(GameState.HEIGHT);
        root.getChildren().add(0, bgView);
    }
}
