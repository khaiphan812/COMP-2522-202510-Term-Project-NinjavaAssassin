package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public abstract class GameObject {

    protected double xCoordinate;
    protected double yCoordinate;
    protected double width;
    protected double height;

    public GameObject(double xCoordinate, double yCoordinate, double width, double height) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
    }

    public abstract void update();

    public abstract void render(GraphicsContext gc);

    public abstract boolean isDead();

    public double getX() {
        return xCoordinate;
    }
    public double getY() { return yCoordinate; }

    public Bounds getBounds() {
        return new Rectangle(xCoordinate - getWidth() / 2, yCoordinate - getHeight() / 2, getWidth(), getHeight()).getBoundsInLocal();
    }

    public abstract double getWidth();

    public abstract double getHeight();
}
