package com.example.comp2522202510termprojectgamename;

import java.util.List;
import java.util.ArrayList;

public class GameState {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;

    private int numLives = 10;
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

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
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
        numLives = 10;
        score = 0;
        Enemy.SPEED = 2;
        gameObjects.add(player);
        reset = true;
    }
}
