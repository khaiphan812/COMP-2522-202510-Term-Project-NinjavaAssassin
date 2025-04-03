package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.List;
import java.util.Objects;

/**
 * Represents the player in the game.
 *
 * @author Khai Phan
 * @version 2025
 */
public class Player extends GameObject {

    private static final int WIDTH = 55; // Player image width
    private static final int HEIGHT = 55; // Player image height
    private static final double SPEED = 5;
    private static final Image PL_IMAGE = new Image(Objects.requireNonNull(Player.class.
                    getResourceAsStream("/images/ninja.gif")));
    private boolean moveLeft;
    private boolean moveRight;
    private boolean moveUp;
    private boolean moveDown;
    /**
     * Constructs a new player.
     *
     * @param xCoordinate the X coordinate of the player
     * @param yCoordinate the Y coordinate of the player
     */
    public Player(final double xCoordinate, final double yCoordinate) {
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
        if (moveLeft && xCoordinate - SPEED > 0) {
            xCoordinate -= SPEED;
        }
        if (moveRight && xCoordinate + (double) WIDTH / 2 <= GameState.WIDTH) {
            xCoordinate += SPEED;
        }
        if (moveUp && yCoordinate - SPEED > 0) {
            yCoordinate -= SPEED;
        }
        if (moveDown && yCoordinate + HEIGHT <= GameState.HEIGHT) {
            yCoordinate += SPEED;
        }
    }

    @Override
    public void render(final GraphicsContext gc) {
        gc.drawImage(PL_IMAGE, xCoordinate - (double) WIDTH / 2,
                yCoordinate - (double) HEIGHT / 2, WIDTH, HEIGHT);
    }

    public void setMoveLeft(final boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setMoveRight(final boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void setMoveUp(final boolean moveUp) {
        this.moveUp = moveUp;
    }

    public void setMoveDown(final boolean moveDown) {
        this.moveDown = moveDown;
    }

    public void shoot(final List<GameObject> newObjects) {
        Shuriken shuriken = new Shuriken(xCoordinate,
                yCoordinate - (double) HEIGHT / 2 - Shuriken.HEIGHT);
        newObjects.add(shuriken);
    }

    @Override
    public boolean isDead() {
        return false;
    }

    /**
     * Returns true if the argument is equal to this player, else false.
     *
     * @param object an Object
     * @return true if the argument is equal to this player, else false
     */
    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        Player player = (Player) object;
        return moveLeft == player.moveLeft && moveRight == player.moveRight && moveUp == player.moveUp && moveDown == player.moveDown;
    }

    /**
     * Returns a hashCode for this player.
     *
     * @return hashCode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), moveLeft, moveRight, moveUp, moveDown);
    }

    /**
     * Returns a string representation of the player.
     *
     * @return a string containing player's contents
     */
    @Override
    public String toString() {
        return "Player{" + "moveLeft=" + moveLeft
                + ", moveRight=" + moveRight
                + ", moveUp=" + moveUp
                + ", moveDown=" + moveDown + '}';
    }
}
