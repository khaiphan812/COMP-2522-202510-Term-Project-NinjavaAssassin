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
    private GameLogic gameLogic;

    public static void main(final String[] args) {
        launch(args);
    }

    private void addBackground(final Pane root) {
        Image bgImage = new Image(Objects.requireNonNull(getClass().
                getResourceAsStream("/images/bg-dark.jpg")));
        ImageView bgView = new ImageView(bgImage);
        bgView.setFitWidth(GameState.WIDTH);
        bgView.setFitHeight(GameState.HEIGHT);
        root.getChildren().addFirst(bgView);
    }

    private void initEventHandlers(final Scene scene) {
        Player player = gameState.getPlayer();
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case A: case LEFT: player.setMoveLeft(true); break;
                case D: case RIGHT: player.setMoveRight(true); break;
                case W: case UP: player.setMoveUp(true); break;
                case S: case DOWN: player.setMoveDown(true); break;
                case SPACE: player.shoot(gameState.getNewObjects()); break;
                default: break;
            }
        });
        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case A: case LEFT: player.setMoveLeft(false); break;
                case D: case RIGHT: player.setMoveRight(false); break;
                case W: case UP: player.setMoveUp(false); break;
                case S: case DOWN: player.setMoveDown(false); break;
                default: break;
            }
        });
    }
    @Override
    public void start(final Stage primaryStage) {
        this.gameState = new GameState();
        Pane root = new Pane();
        addBackground(root);
        Canvas canvas = new Canvas(GameState.WIDTH, GameState.HEIGHT);
        root.getChildren().add(canvas);

        this.gameLogic = new GameLogic(gameState, new GameUI(root, gameState));

        Scene gameScene = new Scene(root, GameState.WIDTH,
                GameState.HEIGHT, javafx.scene.paint.Color.BLACK);
        initEventHandlers(gameScene);

        GameMenu gameMenu = new GameMenu(primaryStage, gameScene);
        Pane menuPane = gameMenu.createMenu();
        Scene menuScene = new Scene(menuPane, GameState.WIDTH, GameState.HEIGHT);

        primaryStage.setScene(menuScene);
        primaryStage.setTitle("NinJava");
        primaryStage.setResizable(false);

        new AnimationTimer() {
            @Override
            public void handle(final long currentTime) {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.clearRect(0, 0, GameState.WIDTH, GameState.HEIGHT);
                gameLogic.updateGame(currentTime);

                for (GameObject object : gameState.getGameObjects()) {
                    object.update();
                    object.render(gc);
                }
            }
        }.start();
        primaryStage.show();
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        NinJava ninJava = (NinJava) object;
        return Objects.equals(gameState, ninJava.gameState)
                && Objects.equals(gameLogic, ninJava.gameLogic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameState, gameLogic);
    }

    @Override
    public String toString() {
        return "NinJava{" + "gameState=" + gameState
                + ", gameLogic=" + gameLogic + '}';
    }
}
