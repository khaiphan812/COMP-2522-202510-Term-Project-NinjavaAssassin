package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;
import java.util.Objects;

public abstract class GameObject {

    protected double xCoordinate;
    protected double yCoordinate;
    protected double width;
    protected double height;

    public GameObject(final double xCoordinate, final double yCoordinate,
                      final double width, final double height) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
    }

    public abstract void update();

    public abstract void render(GraphicsContext gc);

    public abstract boolean isDead();

    public double getY() {
        return yCoordinate; }

    public Bounds getBounds() {
        return new Rectangle(xCoordinate - getWidth() / 2,
                yCoordinate - getHeight() / 2, getWidth(), getHeight()).getBoundsInLocal();
    }
    public abstract double getWidth();

    public abstract double getHeight();

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

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, width, height);
    }

    @Override
    public String toString() {
        return "GameObject{" + "xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate
                + ", width=" + width + ", height=" + height + '}';
    }
}
