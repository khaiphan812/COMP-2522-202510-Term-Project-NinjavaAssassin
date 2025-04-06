package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

/**
 * Represents the shuriken in the game.
 *
 * @author Khai Phan
 * @version 2025
 */
public class Shuriken extends GameObject {
    /**
     * Width is an int.
     */
    protected static final int WIDTH = 25;
    /**
     * Height is an int.
     */
    protected static final int HEIGHT = 25;
    private static final double SPEED = 7;
    private static final Image SHURIKEN_IMAGE = new Image(Objects.requireNonNull(Shuriken.class.
            getResourceAsStream("/images/grey.gif")));
    private boolean dead = false;
    /**
     * Constructs a new shuriken.
     *
     * @param xCoordinate the X coordinate of the shuriken
     * @param yCoordinate the Y coordinate of the shuriken
     */
    public Shuriken(final double xCoordinate, final double yCoordinate) {
        super(xCoordinate, yCoordinate, WIDTH, HEIGHT);
    }
    /**
     * Gets the width of the shuriken.
     *
     * @return the width of the shuriken
     */
    @Override
    public double getWidth() {
        return WIDTH;
    }
    /**
     * Gets the height of the shuriken.
     *
     * @return the height of the shuriken
     */
    @Override
    public double getHeight() {
        return HEIGHT;
    }
    /**
     * Update the position of the shuriken when being thrown.
     */
    @Override
    public void update() {
        yCoordinate -= SPEED;
    }
    /**
     * Renders the GIF of the shuriken.
     */
    @Override
    public void render(final GraphicsContext graphicContext) {
        graphicContext.drawImage(SHURIKEN_IMAGE, xCoordinate - (double) WIDTH / 2,
                yCoordinate - (double) HEIGHT / 2, WIDTH, HEIGHT);
    }
    /**
     * Regulates the life/death status to the shuriken.
     *
     * @param dead a boolean value
     */
    public void setDead(final boolean dead) {
        this.dead = dead;
    }
    /**
     * Check if the shuriken is dead (needs to disappear).
     *
     * @return true if the shuriken is dead, otherwise false.
     */
    @Override
    public boolean isDead() {
        return dead;
    }
}
