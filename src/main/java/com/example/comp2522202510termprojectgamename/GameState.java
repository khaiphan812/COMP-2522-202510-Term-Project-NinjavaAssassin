package com.example.comp2522202510termprojectgamename;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents the game state.
 *
 * @author Khai Phan
 * @version 2025
 */
public class GameState {
    /**
     * Width is an int.
     */
    protected static final int WIDTH = 400;
    /**
     * Height is an int.
     */
    protected static final int HEIGHT = 800;
    /**
     * Default lives is an int.
     */
    protected static final int DEFAULT_LIVES = 10;
    private int numLives;
    private int score = 0;
    private boolean reset = false;

    private final List<GameObject> gameObjects = new ArrayList<>();
    private final List<GameObject> newObjects = new ArrayList<>();

    private final Player player = new Player((double) WIDTH / 2, HEIGHT - 40);
    /**
     * Constructs a game state.
     */
    public GameState() {
        gameObjects.add(player);
    }
    /**
     * Gets the current number of lives.
     *
     * @return the current number of lives
     */
    public int getNumLives() {
        return numLives;
    }
    /**
     * Sets the current number of lives to a specified int.
     *
     * @param numLives the current number of lives
     */
    public void setNumLives(final int numLives) {
        this.numLives = numLives;
    }
    /**
     * Gets the current score.
     *
     * @return the current score
     */
    public int getScore() {
        return score;
    }
    /**
     * Sets the current score to a specified int.
     *
     * @param score the current score
     */
    public void setScore(final int score) {
        this.score = score;
    }
    /**
     * Checks if the game should reset.
     *
     * @return true if the game should reset, otherwise false
     */
    public boolean isReset() {
        return reset;
    }
    /**
     * Resets the game.
     *
     * @param reset reset status is a boolean
     */
    public void setReset(final boolean reset) {
        this.reset = reset;
    }
    /**
     * Gets the game object.
     *
     * @return the list of game objects
     */
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
    /**
     * Gets more game objects to add to the game.
     *
     * @return the list of game objects
     */
    public List<GameObject> getNewObjects() {
        return newObjects;
    }
    /**
     * Gets the player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }
    /**
     * Resets the game.
     */
    public void resetGame() {
        gameObjects.clear();
        numLives = DEFAULT_LIVES;
        score = 0;
        Enemy.speed = 2;
        gameObjects.add(player);
        reset = true;
    }

    /**
     * Returns true if the argument is equal to this game state, else false.
     *
     * @param object an Object
     * @return true if the argument is equal to this game state, else false
     */
    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        GameState gameState = (GameState) object;
        return numLives == gameState.numLives && score == gameState.score
                && reset == gameState.reset && Objects.equals(gameObjects, gameState.gameObjects)
                && Objects.equals(newObjects, gameState.newObjects)
                && Objects.equals(player, gameState.player);
    }

    /**
     * Returns a hashCode for this game state.
     *
     * @return hashCode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(numLives, score, reset, gameObjects, newObjects, player);
    }

    /**
     * Returns a string representation of the game state.
     *
     * @return a string containing game state's contents
     */
    @Override
    public String toString() {
        return "GameState{" + "numLives=" + numLives + ", score=" + score
                + ", reset=" + reset + ", gameObjects=" + gameObjects
                + ", newObjects=" + newObjects + ", player=" + player + '}';
    }
}
