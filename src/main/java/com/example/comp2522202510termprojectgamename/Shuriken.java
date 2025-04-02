package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

public class Shuriken extends GameObject {

    protected static final int WIDTH = 25;
    protected static final int HEIGHT = 25;
    private static final double SPEED = 7;
    private static final Image SHURIKEN_IMAGE = new Image(Objects.requireNonNull(Shuriken.class.
            getResourceAsStream("/images/grey.gif")));

    public Shuriken(final double xCoordinate, final double yCoordinate) {
        super(xCoordinate, yCoordinate, WIDTH, HEIGHT);
    }

    @Override
    public double getWidth() {
        return WIDTH;
    }

    @Override
    public double getHeight() {
        return HEIGHT;
    }

    @Override
    public void update() {
        yCoordinate -= SPEED;
    }

    @Override
    public void render(final GraphicsContext gc) {
        gc.drawImage(SHURIKEN_IMAGE, xCoordinate - (double) WIDTH / 2,
                yCoordinate - (double) HEIGHT / 2, WIDTH, HEIGHT);
    }

    private boolean dead = false;

    public void setDead(final boolean dead) {
        this.dead = dead;
    }

    @Override
    public boolean isDead() {
        return dead;
    }
}
