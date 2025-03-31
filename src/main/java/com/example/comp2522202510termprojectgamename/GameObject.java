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


}
