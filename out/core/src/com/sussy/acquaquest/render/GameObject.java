package com.sussy.acquaquest.render;

import com.badlogic.gdx.graphics.Texture;

public class GameObject{
    private float x, y;
    private Sprite s;

    public GameObject(Texture t, float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        s = new Sprite(t, width, height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Sprite getS() {
        return s;
    }

    public void setS(Sprite s) {
        this.s = s;
    }

    public Texture getT(){
        return s.getTexture();
    }

    public void setT(Texture t){
        s.setTexture(t);
    }

    public float getWidth(){
        return s.getWidth();
    }

    public void setWidth(float width){
        s.setWidth(width);
    }

    public float getHeight(){
        return s.getHeight();
    }

    public void setHeight(float height){
        s.setHeight(height);
    }
}