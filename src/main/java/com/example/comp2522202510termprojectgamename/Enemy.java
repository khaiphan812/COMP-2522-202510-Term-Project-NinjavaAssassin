package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

public class Enemy extends GameObject {

    protected static final int WIDTH = 65;
    protected static final int HEIGHT = 65;
    private static final Image ENEMY_IMAGE = new Image(Objects.requireNonNull(Enemy.class.
            getResourceAsStream("/images/junkrat.gif")));
    private static final int INITIAL_SPEED = 2;
    protected static double speed = INITIAL_SPEED;
    private boolean dead = false;

    public Enemy(final double xCoordinate, final double yCoordinate) {
        super(xCoordinate, yCoordinate, WIDTH, HEIGHT);
    }

    @Override
    public void update() {
        yCoordinate += speed;
    }

    @Override
    public void render(final GraphicsContext gc) {
        gc.drawImage(ENEMY_IMAGE, xCoordinate - (double) WIDTH / 2,
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

    public void setDead(final boolean dead) {
        this.dead = dead;
    }

    @Override
    public boolean isDead() {
        return dead;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Enemy enemy = (Enemy) object;
        return dead == enemy.dead;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dead);
    }

    @Override
    public String toString() {
        return "Enemy{" + "dead=" + dead + '}';
    }
}
