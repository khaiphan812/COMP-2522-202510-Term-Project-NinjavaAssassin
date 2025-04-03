package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;
import java.util.Objects;

/**
 * Represents an object in the game.
 *
 * @author Khai Phan
 * @version 2025
 */
public abstract class GameObject {
    /**
     * xCoordinate is a double.
     */
    protected double xCoordinate;
    /**
     * xCoordinate is a double.
     */
    protected double yCoordinate;
    /**
     * width is a double.
     */
    protected double width;
    /**
     * height is a double.
     */
    protected double height;
    /**
     * Constructs a game object.
     *
     * @param xCoordinate the X coordinate of the object
     * @param yCoordinate the Y coordinate of the object
     * @param width the width of the object
     * @param height the height of the object
     */
    public GameObject(final double xCoordinate, final double yCoordinate,
                      final double width, final double height) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
    }
    /**
     * Updates the game object.
     */
    public abstract void update();
    /**
     * Renders the image of the game object.
     *
     * @param graphicsContext the graphics context of the object
     */
    public abstract void render(GraphicsContext graphicsContext);
    /**
     * Checks the life or death status game object.
     *
     * @return true if the game object is dead, otherwise false
     */
    public abstract boolean isDead();
    /**
     * Gets the Y coordinate of the game object.
     *
     * @return Y coordinate of the game object
     */
    public double getY() {
        return yCoordinate; }
    /**
     * Gets the boundaries of the game object.
     *
     * @return the boundaries of the game object
     */
    public Bounds getBounds() {
        return new Rectangle(xCoordinate - getWidth() / 2,
                yCoordinate - getHeight() / 2, getWidth(), getHeight()).getBoundsInLocal();
    }
    /**
     * Gets the width of the game object.
     *
     * @return the width of the game object
     */
    public abstract double getWidth();
    /**
     * Gets the height of the game object.
     *
     * @return the height of the game object
     */
    public abstract double getHeight();

    /**
     * Returns true if the argument is equal to this game object, else false.
     *
     * @param object an Object
     * @return true if the argument is equal to this game object, else false
     */
    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        GameObject that = (GameObject) object;
        return Double.compare(xCoordinate, that.xCoordinate) == 0
                && Double.compare(yCoordinate, that.yCoordinate) == 0
                && Double.compare(width, that.width) == 0
                && Double.compare(height, that.height) == 0;
    }

    /**
     * Returns a hashCode for this game object.
     *
     * @return hashCode as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, width, height);
    }

    /**
     * Returns a string representation of the game object.
     *
     * @return a string containing game object's contents
     */
    @Override
    public String toString() {
        return "GameObject{" + "xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate
                + ", width=" + width + ", height=" + height + '}';
    }
}
