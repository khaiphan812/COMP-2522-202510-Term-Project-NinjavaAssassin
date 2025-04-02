package com.example.comp2522202510termprojectgamename;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class GameState {
    protected static final int WIDTH = 400;
    protected static final int HEIGHT = 800;
    protected static final int DEFAULT_LIVES = 10;
    private int numLives;
    private int score = 0;
    private boolean reset = false;

    private final List<GameObject> gameObjects = new ArrayList<>();
    private final List<GameObject> newObjects = new ArrayList<>();

    private final Player player = new Player((double) WIDTH / 2, HEIGHT - 40);

    public GameState() {
        gameObjects.add(player);
    }

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(final int numLives) {
        this.numLives = numLives;
    }

    public int getScore() {
        return score;
    }
    public void setScore(final int score) {
        this.score = score;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(final boolean reset) {
        this.reset = reset;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public List<GameObject> getNewObjects() {
        return newObjects;
    }

    public Player getPlayer() {
        return player;
    }

    public void resetGame() {
        gameObjects.clear();
        numLives = DEFAULT_LIVES;
        score = 0;
        Enemy.speed = 2;
        gameObjects.add(player);
        reset = true;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(numLives, score, reset, gameObjects, newObjects, player);
    }

    @Override
    public String toString() {
        return "GameState{" + "numLives=" + numLives + ", score=" + score
                + ", reset=" + reset + ", gameObjects=" + gameObjects
                + ", newObjects=" + newObjects + ", player=" + player + '}';
    }
}
