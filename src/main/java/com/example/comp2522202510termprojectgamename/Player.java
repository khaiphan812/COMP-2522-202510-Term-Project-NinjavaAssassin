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
    private boolean dead = false;

    private static final Image playerImage = new Image(Player.class.getResourceAsStream("/images/ninja.gif"));

    public Player(double xCoordinate, double yCoordinate) {
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
        if (moveRight && xCoordinate + WIDTH <= GameState.WIDTH) {
            xCoordinate += SPEED;
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(playerImage, xCoordinate - WIDTH / 2, yCoordinate - HEIGHT / 2, WIDTH, HEIGHT);
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void shoot(List<GameObject> newObjects) {
        Shuriken shuriken = new Shuriken(xCoordinate, yCoordinate - HEIGHT / 2 - Shuriken.HEIGHT);
        newObjects.add(shuriken);
    }

    @Override
    public boolean isDead() {
        return dead;
    }
}
