package com.example.comp2522202510termprojectgamename;

import java.util.List;
import java.util.ArrayList;

public class GameState {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    public static final int DEFAULT_LIVES = 10;
    private int numLives;
    private int score = 0;
    private boolean reset = false;

    private final List<GameObject> gameObjects = new ArrayList<>();
    private final List<GameObject> newObjects = new ArrayList<>();

    private final Player player = new Player(WIDTH / 2, HEIGHT - 40);

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
        Enemy.SPEED = 2;
        gameObjects.add(player);
        reset = true;
    }
}
