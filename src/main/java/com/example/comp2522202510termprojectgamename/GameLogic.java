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

    private void checkCollisions() {
        List<Shuriken> shurikens = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();
        List<Boss> bosses = new ArrayList<>();

        for (GameObject object : gameState.getGameObjects()) {
            if (object instanceof Shuriken) {
                shurikens.add((Shuriken) object);
            } else if (object instanceof Enemy) {
                enemies.add((Enemy) object);
            } else if (object instanceof Boss) {
                bosses.add((Boss) object);
            }
        }
        for (Shuriken shuriken : shurikens) {
            for (Enemy enemy : enemies) {
                if (shuriken.getBounds().intersects(enemy.getBounds())) {
                    shuriken.setDead(true);
                    enemy.setDead(true);
                    gameState.setScore(gameState.getScore() + 10);
                    gameUI.updateScore(gameState.getScore());

                    if (gameState.getScore() % 100 == 0) {
                        Enemy.SPEED += 2;
                    }
                }
            }

            for (Boss boss : bosses) {
                if (shuriken.getBounds().intersects(boss.getBounds())) {
                    shuriken.setDead(true);
                    boss.takeHit();
                    if (boss.isDead()) {
                        gameState.setScore(gameState.getScore() + 50);
                        gameUI.updateScore(gameState.getScore());
                    }
                }
            }
        }
    }

}
