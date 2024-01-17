package com.sussy.acquaquest.render;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject{
    protected float x, y;
    protected Sprite base;

    public GameObject(Texture t, float x, float y, float width) {
        this.x = x;
        this.y = y;
        base = new Sprite(t, width);
    }

    public GameObject(Texture[] t, float x, float y, float width, int cycle) {
        this.x = x;
        this.y = y;
        base = new Sprite(t, width, cycle);
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

    public Sprite getBase() {
        return base;
    }

    public void setBase(Sprite s) {
        this.base = s;
    }

    public Texture[] getT(){
        return base.getTexture();
    }

    public void setT(Texture t){
        base.setTexture(t);
    }

    public void setT(Texture[] t){
        base.setTexture(t);
    }

    public float getWidth(){
        return base.getWidth();
    }

    public void setWidth(float width){
        base.setWidth(width);
    }

    public float getHeight(){
        return base.getHeight();
    }

    public void setHeight(float height){
        base.setHeight(height);
    }
    
    public void dispose(){
        base.dispose();
    }

    public void update(){
    }

    public void draw(SpriteBatch sb){
        base.draw(sb, x, y);
    }
}