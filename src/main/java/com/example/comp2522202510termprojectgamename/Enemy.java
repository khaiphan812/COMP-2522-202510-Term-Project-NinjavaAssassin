package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

/**
 * Represents an enemy in the game.
 *
 * @author Khai Phan
 * @version 2025
 */
public class Enemy extends GameObject {
    /**
     * The width of the enemy is an int.
     */
    protected static final int WIDTH = 65;
    /**
     * The height of the enemy is an int.
     */
    protected static final int HEIGHT = 65;
    private static final Image ENEMY_IMAGE = new Image(Objects.requireNonNull(Enemy.class.
            getResourceAsStream("/images/junkrat.gif")));
    private static final int INITIAL_SPEED = 2;
    /**
     * The speed of the enemy is a double.
     */
    protected static double speed = INITIAL_SPEED;
    private boolean dead = false;

    /**
     * Constructs an enemy with specified width, height, X and Y coordinates.
     *
     * @param xCoordinate the X coordinate of the enemy, must be a double.
     * @param yCoordinate the Y coordinate of the enemy, must be a double.
     */
    public Enemy(final double xCoordinate, final double yCoordinate) {
        super(xCoordinate, yCoordinate, WIDTH, HEIGHT);
    }

    /**
     * Updates the position of the enemy when moving.
     */
    @Override
    public void update() {
        yCoordinate += speed;
    }

    /**
     * Renders the GIF of the enemy.
     */
    @Override
    public void render(final GraphicsContext gc) {
        gc.drawImage(ENEMY_IMAGE, xCoordinate - (double) WIDTH / 2,
                yCoordinate - (double) HEIGHT / 2, WIDTH, HEIGHT);
    }

    /**
     * Gets the width of the enemy as a double.
     *
     * @return the width of the enemy as a double
     */
    @Override
    public double getWidth() {
        return WIDTH;
    }

    /**
     * Gets the height of the enemy as a double.
     *
     * @return the height of the enemy as a double
     */
    @Override
    public double getHeight() {
        return HEIGHT;
    }

    /**
     * Regulates the life/death status to the enemy.
     *
     * @param dead a boolean value
     */
    public void setDead(final boolean dead) {
        this.dead = dead;
    }

    /**
     * Check if the enemy is dead.
     *
     * @return true if the enemy is dead, otherwise false.
     */
    @Override
    public boolean isDead() {
        return dead;
    }

    /**
     * Returns true if the argument is equal to this enemy, else false.
     *
     * @param object an Object
     * @return true if the argument is equal to this enemy, else false
     */
    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Enemy enemy = (Enemy) object;
        return dead == enemy.dead;
    }

    /**
     * Returns a hashCode for this enemy.
     *
     * @return hashCode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(dead);
    }

    /**
     * Returns a string representation of the enemy.
     *
     * @return a string containing enemy's contents
     */
    @Override
    public String toString() {
        return "Enemy{" + "dead=" + dead + '}';
    }
}
