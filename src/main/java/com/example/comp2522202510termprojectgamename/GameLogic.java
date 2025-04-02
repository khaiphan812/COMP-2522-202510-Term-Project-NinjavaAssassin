package com.example.comp2522202510termprojectgamename;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {
    private static final int COORDINATE_ELO_1 = 50;
    private static final int COORDINATE_ELO_2 = 25;
    private static final int COORDINATE_ELO_3 = -40;
    private static final int SCORE_PER_ENEMY = 10;
    private static final int SCORE_PER_BOSS = 50;
    private static final int MULTI_OF_100 = 100;
    private static final double SPEED_INCREASE_RATE = 0.4;
    private static final long NANO_SECONDS_1 = 1_000_000_000;
    private static final long NANO_SECONDS_2 = 10_000_000_000L;
    private final GameState gameState;
    private final GameUI gameUI;
    private long lastEnemySpawned = 0;
    private long lastBossSpawned = 0;

    public GameLogic(final GameState gameState, final GameUI gameUI) {
        this.gameState = gameState;
        this.gameUI = gameUI;
    }

    private void spawnEnemy() {
        Random random = new Random();
        int randomCoordinate = random.nextInt(GameState.WIDTH - COORDINATE_ELO_1)
                + COORDINATE_ELO_2;
        Enemy enemy = new Enemy(randomCoordinate, COORDINATE_ELO_3);
        gameState.getGameObjects().add(enemy);
    }

    private void spawnBoss() {
        Random random = new Random();
        int randomCoordinate = random.nextInt(GameState.WIDTH - Boss.WIDTH) + Boss.WIDTH / 2;
        Boss boss = new Boss(randomCoordinate, (double) -Boss.HEIGHT / 2);
        gameState.getGameObjects().add(boss);
    }

    private void checkCollisions() {
        List<Shuriken> shurikens = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();
        List<Boss> bosses = new ArrayList<>();
        Player player = gameState.getPlayer();

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
                    gameState.setScore(gameState.getScore() + SCORE_PER_ENEMY);
                    gameUI.updateScore(gameState.getScore());

                    if (gameState.getScore() % MULTI_OF_100 == 0) {
                        Enemy.SPEED += 2;
                    }
                }
            }

            for (Boss boss : bosses) {
                if (shuriken.getBounds().intersects(boss.getBounds())) {
                    shuriken.setDead(true);
                    boss.takeHit();
                    if (boss.isDead()) {
                        gameState.setScore(gameState.getScore() + SCORE_PER_BOSS);
                        gameUI.updateScore(gameState.getScore());
                    }
                }
            }
        }
        for (Enemy enemy : enemies) {
            if (player.getBounds().intersects(enemy.getBounds())) {
                enemy.setDead(true);
                gameState.setNumLives(gameState.getNumLives() - 1);
                gameUI.updateLives(gameState.getNumLives());
            }
        }

        for (Boss boss : bosses) {
            if (player.getBounds().intersects(boss.getBounds())) {
                boss.setDead(true);
                gameState.setNumLives(gameState.getNumLives() - 1);
                gameUI.updateLives(gameState.getNumLives());
            }
        }
        checkGameOver();
    }

    private void checkGameOver() {
        if (gameState.getNumLives() == 0) {
            gameUI.showGameOverMessage();
            gameState.resetGame();
            gameUI.updateScore(0);
            gameUI.updateLives(gameState.getNumLives());
        }
    }

    private void controlEnemyMovement() {
        List<Enemy> enemies = new ArrayList<>();
        for (GameObject obj: gameState.getGameObjects()) {
            if (obj instanceof Enemy) {
                enemies.add((Enemy) obj);
            }
        }

        for (Enemy enemy : enemies) {
            if (enemy.getY() + enemy.getHeight() / 2 >= GameState.HEIGHT) {
                enemy.setDead(true);
                Enemy.SPEED += SPEED_INCREASE_RATE;
                gameState.setNumLives(gameState.getNumLives() - 1);
                gameUI.updateLives(gameState.getNumLives());
                gameUI.updateScore(gameState.getScore());

                checkGameOver();
            }
        }
    }
    private void controlBossMovement() {
        List<Boss> bosses = new ArrayList<>();
        for (GameObject object: gameState.getGameObjects()) {
            if (object instanceof Boss) {
                bosses.add((Boss) object);
            }
        }

        for (Boss boss : bosses) {
            if (boss.getY() + boss.getHeight() / 2 >= GameState.HEIGHT) {
                boss.setDead(true);
                gameState.setNumLives(gameState.getNumLives() - 1);
                gameUI.updateLives(gameState.getNumLives());
                gameUI.updateScore(gameState.getScore());

                checkGameOver();
            }
        }
    }
    public void updateGame(long currentTime) {
        if (gameState.isReset()) {
            gameState.setReset(false);
        }

        if (currentTime - lastEnemySpawned > NANO_SECONDS_1) {
            spawnEnemy();
            lastEnemySpawned = currentTime;
        }

        if (currentTime - lastBossSpawned > NANO_SECONDS_2) {
            spawnBoss();
            lastBossSpawned = currentTime;
        }

        checkCollisions();
        controlEnemyMovement();
        controlBossMovement();

        gameState.getGameObjects().addAll(gameState.getNewObjects());
        gameState.getNewObjects().clear();
        gameState.getGameObjects().removeIf(GameObject::isDead);
    }
}
