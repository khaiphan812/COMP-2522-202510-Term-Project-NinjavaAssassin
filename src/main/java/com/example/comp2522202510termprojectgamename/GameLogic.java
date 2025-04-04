package com.example.comp2522202510termprojectgamename;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Represents the game logic.
 *
 * @author Khai Phan
 * @version 2025
 */
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

    /**
     * Constructs the game logic.
     *
     * @param gameState the game state
     * @param gameUI the game UI
     */
    public GameLogic(final GameState gameState, final GameUI gameUI) {
        this.gameState = gameState;
        this.gameUI = gameUI;
    }

    /**
     * Spawns an enemy in the game.
     *
     */
    private void spawnEnemy() {
        Random random = new Random();
        int randomCoordinate = random.nextInt(GameState.WIDTH - COORDINATE_ELO_1)
                + COORDINATE_ELO_2;
        Enemy enemy = new Enemy(randomCoordinate, COORDINATE_ELO_3);
        gameState.getGameObjects().add(enemy);
    }

    /**
     * Spawns a boss in the game.
     *
     */
    private void spawnBoss() {
        Random random = new Random();
        int randomCoordinate = random.nextInt(GameState.WIDTH - Boss.WIDTH) + Boss.WIDTH / 2;
        Boss boss = new Boss(randomCoordinate, (double) -Boss.HEIGHT / 2);
        gameState.getGameObjects().add(boss);
    }

    private void checkGameOver() {
        if (gameState.getNumLives() == 0 && !gameState.isGameOver()) {
            gameState.setGameOver(true);
            gameUI.showGameOverMessage();
            gameUI.showGameOverMessage();
        }
    }

    private void controlEnemyMovement() {
        List<Enemy> enemies = new ArrayList<>();
        for (GameObject object: gameState.getGameObjects()) {
            if (object instanceof Enemy) {
                enemies.add((Enemy) object);
            }
        }

        for (Enemy enemy : enemies) {
            if (enemy.getY() + enemy.getHeight() / 2 >= GameState.HEIGHT) {
                enemy.setDead(true);
                Enemy.speed += SPEED_INCREASE_RATE;
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

    private void checkShurikenEnemyCollisions() {
        List<Shuriken> shurikens = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();

        for (GameObject object : gameState.getGameObjects()) {
            if (object instanceof Shuriken) {
                shurikens.add((Shuriken) object);
            } else if (object instanceof Enemy) {
                enemies.add((Enemy) object);
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
                        Enemy.speed += 2;
                    }
                }
            }
        }
    }

    private void checkShurikenBossCollisions() {
        List<Shuriken> shurikens = new ArrayList<>();
        List<Boss> bosses = new ArrayList<>();

        for (GameObject object : gameState.getGameObjects()) {
            if (object instanceof Shuriken) {
                shurikens.add((Shuriken) object);
            } else if (object instanceof Boss) {
                bosses.add((Boss) object);
            }
        }

        for (Shuriken shuriken : shurikens) {
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
    }

    private void checkPlayerCollisions() {
        List<Enemy> enemies = new ArrayList<>();
        List<Boss> bosses = new ArrayList<>();
        Player player = gameState.getPlayer();

        for (GameObject object : gameState.getGameObjects()) {
            if (object instanceof Enemy) {
                enemies.add((Enemy) object);
            } else if (object instanceof Boss) {
                bosses.add((Boss) object);
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
    }

    private void checkCollisions() {
        checkShurikenEnemyCollisions();
        checkShurikenBossCollisions();
        checkPlayerCollisions();
        checkGameOver();
    }
    /**
     * Updates the game logic over time.
     *
     * @param currentTime the current time
     */
    public void updateGame(final long currentTime) {
        if (gameState.isGameOver()) {
            return;
        }
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

    /**
     * Returns true if the argument is equal to this game logic, else false.
     *
     * @param object an Object
     * @return true if the argument is equal to this game logic, else false
     */
    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        GameLogic gameLogic = (GameLogic) object;
        return lastEnemySpawned == gameLogic.lastEnemySpawned
                && lastBossSpawned == gameLogic.lastBossSpawned
                && Objects.equals(gameState, gameLogic.gameState)
                && Objects.equals(gameUI, gameLogic.gameUI);
    }

    /**
     * Returns a hashCode for this game logic.
     *
     * @return hashCode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(gameState, gameUI, lastEnemySpawned, lastBossSpawned);
    }

    /**
     * Returns a string representation of the game logic.
     *
     * @return a string containing game logic's contents
     */
    @Override
    public String toString() {
        return "GameLogic{" + "gameState=" + gameState
                + ", gameUI=" + gameUI
                + ", lastEnemySpawned=" + lastEnemySpawned
                + ", lastBossSpawned=" + lastBossSpawned + '}';
    }
}
