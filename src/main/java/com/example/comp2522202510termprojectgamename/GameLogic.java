package com.example.comp2522202510termprojectgamename;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GameLogic {
    private final GameState gameState;
    private final GameUI gameUI;
    private long lastEnemySpawned = 0;
    private long lastPowerUpSpawned = 0;

    public GameLogic(GameState gameState, GameUI gameUI) {
        this.gameState = gameState;
        this.gameUI = gameUI;
    }

    private void spawnEnemy() {
        Random random = new Random();
        int coordinate = random.nextInt(GameState.WIDTH - 50) + 25;
        Enemy enemy = new Enemy(coordinate, -40);
        gameState.getGameObjects().add(enemy);
    }


}
