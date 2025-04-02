package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

/**
 * Represents a special boss in the game.
 *
 * @author Khai Phan
 * @version 2025
 */
public class Boss extends GameObject {
    /**
     * The width of the boss is an int.
     */
    protected static final int WIDTH = 120;
    /**
     * The height of the boss is an int.
     */
    protected static final int HEIGHT = 120;
    private static final double SPEED = 3;
    private static final Image BOSS_IMAGE = new Image(Objects.requireNonNull(Boss.class.
            getResourceAsStream("/images/hog.gif")));
    private static final int INITIAL_HIT_COUNT = 5;
    private int hitCount = INITIAL_HIT_COUNT;
    private boolean isDead = false;
    /**
     * Constructs a boss with specified width, height, X and Y coordinates.
     *
     * @param xCoordinate the X coordinate of the boss, must be a double.
     * @param yCoordinate the Y coordinate of the boss, must be a double.
     */
    public Boss(final double xCoordinate, final double yCoordinate) {
        super(xCoordinate, yCoordinate, WIDTH, HEIGHT);
    }

    /**
     * Updates the position of the boss when moving.
     */
    @Override
    public void update() {
        yCoordinate += SPEED;
    }

    /**
     * Renders the image of the boss.
     */
    @Override
    public void render(final GraphicsContext gc) {
        gc.drawImage(BOSS_IMAGE, xCoordinate - (double) WIDTH / 2,
                yCoordinate - (double) HEIGHT / 2, WIDTH, HEIGHT);
    }

    @Override
    public double getWidth() {
        return WIDTH;
    }

    @Override
    public double getHeight() {
        return HEIGHT;
    }

    public void takeHit() {
        hitCount--;
        if (hitCount == 0) {
            setDead(true);
        }
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    public void setDead(final boolean dead) {
        this.isDead = dead;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Boss boss = (Boss) object;
        return hitCount == boss.hitCount && isDead == boss.isDead;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitCount, isDead);
    }

    @Override
    public String toString() {
        return "Boss{" + "hitCount=" + hitCount + ", isDead=" + isDead + '}';
    }
}
