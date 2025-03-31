package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.List;

public class Player extends GameObject {

    private static final int WIDTH = 55; // Player image width
    private static final int HEIGHT = 55; // Player image height
    private static final double SPEED = 5;
    private boolean moveLeft;
    private boolean moveRight;

    private static final Image playerImage = new Image(Player.class.getResourceAsStream("/images/ninja.gif"));




}
