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
        int randomCoordinate = random.nextInt(GameState.WIDTH - 50) + 25;
        Enemy enemy = new Enemy(randomCoordinate, -40);
        gameState.getGameObjects().add(enemy);
    }

    private void spawnBoss() {
        Random random = new Random();
        int randomCoordinate = random.nextInt(GameState.WIDTH - Boss.WIDTH) + Boss.WIDTH / 2;
        Boss boss = new Boss(randomCoordinate, - Boss.HEIGHT / 2);
        gameState.getGameObjects().add(boss);
    }

}
