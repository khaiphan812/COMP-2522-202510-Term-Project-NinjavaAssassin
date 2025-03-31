package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Enemy extends GameObject {

    protected static final int WIDTH = 65;
    protected static final int HEIGHT = 65;
    public static double SPEED = 2;
    private boolean dead = false;

    private static final Image enemyImage = new Image(Enemy.class.getResourceAsStream("/images/junkrat.gif"));

    public Enemy(double xCoordinate, double yCoordinate) {
        super(xCoordinate, yCoordinate, WIDTH, HEIGHT);
    }

    @Override
    public void update() {
        yCoordinate += SPEED;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(enemyImage, xCoordinate - WIDTH / 2, yCoordinate - HEIGHT / 2, WIDTH, HEIGHT);
    }

    @Override
    public double getWidth() {
        return WIDTH;
    }

    @Override
    public double getHeight() {
        return HEIGHT;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    @Override
    public boolean isDead() {
        return dead;
    }
}
