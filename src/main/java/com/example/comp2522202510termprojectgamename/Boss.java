package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Boss extends GameObject {

    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    private static final double SPEED = 3.5;
    private boolean isDead = false;
    private static int hitCount = 5;

    private static final Image bossImage = new Image(Boss.class.getResourceAsStream("/images/hog.gif"));

    public Boss(double xCoordinate, double yCoordinate) {
        super(xCoordinate, yCoordinate, WIDTH, HEIGHT);
    }

    @Override
    public void update() {
        yCoordinate += SPEED;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(bossImage, xCoordinate - WIDTH / 2, yCoordinate - HEIGHT / 2, WIDTH, HEIGHT);
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
        if (hitCount <= 0) {
            setDead(true);
        }
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    public void setDead(boolean b) {
        this.isDead = b;
    }
}
