package com.heritagegame;

import javafx.scene.image.Image;

public class Sprite {
    
    public final Image image;
    public double x, y;

    /** Load image from resource and set initial coordinates. */
    public Sprite(String resourcePath, double x, double y) {
        this.image = new Image(getClass().getResourceAsStream(resourcePath));
        this.x = x;  this.y = y;
    }
    
}