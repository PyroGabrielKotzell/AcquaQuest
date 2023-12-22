package com.sussy.acquaquest.render;

import com.badlogic.gdx.graphics.Texture;

public class Sprite {
    private Texture texture;
    private float width, height;

    public Sprite(Texture texture, float width, float height) {
        this.texture = texture;
        this.width = width;
        this.height = texture.getHeight()/(float)texture.getWidth();
    }

    public Sprite(Texture texture) {
        this.texture = texture;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
        height = width * texture.getHeight()/(float)texture.getWidth();
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        width = height * texture.getWidth()/(float)texture.getHeight();
    }
}