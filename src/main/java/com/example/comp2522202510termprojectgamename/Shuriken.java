package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Shuriken extends GameObject {

    public static final int WIDTH = 25;
    public static final int HEIGHT = 25;
    private static final double SPEED = 7;

    private static final Image shurikenImage = new Image(Shuriken.class.getResourceAsStream("/images/grey.gif"));

    public Shuriken(double xCoordinate, double yCoordinate) {
        super(xCoordinate, yCoordinate, WIDTH, HEIGHT);
    }
}
