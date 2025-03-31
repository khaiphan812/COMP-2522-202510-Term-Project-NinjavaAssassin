package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Boss extends GameObject {

    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    private static final double SPEED = 5;

    private static final Image bossImage = new Image(Boss.class.getResourceAsStream("/images/hog.gif"));


}
