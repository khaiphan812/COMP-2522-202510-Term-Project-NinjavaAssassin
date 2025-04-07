package com.example.comp2522202510termprojectgamename;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.Objects;

/**
 * Represents the game UI.
 *
 * @author Khai Phan
 * @version 2025
 */
public class GameUI {
    private static final int SETTING_1 = 10;
    private static final int SETTING_2 = 40;
    private static final int FONT_SIZE = 18;
    private final Label scoreLabel;
    private final Label lifeLabel;
    private final Pane root;
    private final GameState gameState;

    /**
     * Constructs the game UI.
     *
     * @param root the root of the game
     * @param gameState the game state
     */
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
    /**
     * Updates the score.
     *
     * @param score the root of the game
     */
    public void updateScore(final int score) {
        scoreLabel.setText("Score: " + score);
    }
    /**
     * Updates the lives count.
     *
     * @param lives the root of the game
     */
    public void updateLives(final int lives) {
        lifeLabel.setText("Lives: " + lives);
    }
    /**
     * Shows a message when game is over.
     */
    public void showGameOverMessage() {
        Text gameOverMessage = new Text("Game Over! Your score is "
                + gameState.getScore() + ".\nPress any key to start a new game.");
        gameOverMessage.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FONT_SIZE));
        gameOverMessage.setFill(Color.WHITESMOKE);
        gameOverMessage.setX((GameState.WIDTH - gameOverMessage.getLayoutBounds().getWidth()) / 2);
        gameOverMessage.setY((double) GameState.HEIGHT / 2);
        root.getChildren().add(gameOverMessage);
    }

    /**
     * Removes the game over message when from the screen.
     */
    public void removeGameOverMessage() {
        root.getChildren().removeIf(node -> node instanceof Text
                && ((Text) node).getText().startsWith("Game Over!"));
    }
    /**
     * Returns true if the argument is equal to this game UI, else false.
     *
     * @param object an Object
     * @return true if the argument is equal to this game UI, else false
     */
    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        GameUI gameUI = (GameUI) object;
        return Objects.equals(scoreLabel, gameUI.scoreLabel)
                && Objects.equals(lifeLabel, gameUI.lifeLabel)
                && Objects.equals(root, gameUI.root)
                && Objects.equals(gameState, gameUI.gameState);
    }

    /**
     * Returns a hashCode for this game UI.
     *
     * @return hashCode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(scoreLabel, lifeLabel, root, gameState);
    }

    /**
     * Returns a string representation of the game UI.
     *
     * @return a string containing game UI's contents
     */
    @Override
    public String toString() {
        return "GameUI{" + "scoreLabel=" + scoreLabel + ", lifeLabel=" + lifeLabel
                + ", root=" + root + ", gameState=" + gameState + '}';
    }
}
