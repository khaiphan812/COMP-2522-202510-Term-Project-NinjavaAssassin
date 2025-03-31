package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Enemy extends GameObject {

    protected static final int WIDTH = 65;
    protected static final int HEIGHT = 65;
    public static double SPEED = 2;

    private static final Image enemyImage = new Image(Enemy.class.getResourceAsStream("/images/junkrat.gif"));

    public Enemy(double xCoordinate, double yCoordinate) {
        super(xCoordinate, yCoordinate, WIDTH, HEIGHT);
    }
}
