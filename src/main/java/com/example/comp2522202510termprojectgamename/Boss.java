package com.example.comp2522202510termprojectgamename;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

public class Boss extends GameObject {

    protected static final int WIDTH = 120;
    protected static final int HEIGHT = 120;
    private static final double SPEED = 3;
    private static final Image BOSS_IMAGE = new Image(Objects.requireNonNull(Boss.class.
            getResourceAsStream("/images/hog.gif")));
    private static final int INITIAL_HIT_COUNT = 5;
    private int hitCount = INITIAL_HIT_COUNT;
    private boolean isDead = false;

    public Boss(final double xCoordinate, final double yCoordinate) {
        super(xCoordinate, yCoordinate, WIDTH, HEIGHT);
    }

    @Override
    public void update() {
        yCoordinate += SPEED;
    }

    @Override
    public void render(final GraphicsContext gc) {
        gc.drawImage(BOSS_IMAGE, xCoordinate - (double) WIDTH / 2,
                yCoordinate - (double) HEIGHT / 2, WIDTH, HEIGHT);
    }

    @Override
    public double getWidth() {
        return WIDTH;
    }

    @Override
    public double getHeight() {
        return HEIGHT;
    }

    public void takeHit() {
        hitCount--;
        if (hitCount == 0) {
            setDead(true);
        }
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    public void setDead(final boolean dead) {
        this.isDead = dead;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Boss boss = (Boss) object;
        return hitCount == boss.hitCount && isDead == boss.isDead;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitCount, isDead);
    }

    @Override
    public String toString() {
        return "Boss{" + "hitCount=" + hitCount + ", isDead=" + isDead + '}';
    }
}
