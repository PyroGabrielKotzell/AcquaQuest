package com.sussy.acquaquest.render;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite {
    private Texture[] texture;
    private int offset, cycle, maxCycle = 0;
    private float width, height;

    public Sprite(Texture texture, float width, float height) {
        this.texture = new Texture[1];
        this.texture[0] = texture;
        this.width = width;
        this.height = height;
    }

    public Sprite(Texture[] texture, float width, float height, int cycle) {
        this.texture = texture;
        this.width = width;
        this.height = height;
        offset = 0;
        this.cycle = 0;
        maxCycle = cycle;
    }

    public Texture[] getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture[0] = texture;
    }

    public void setTexture(Texture[] texture) {
        this.texture = texture;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
        height = width * texture[0].getHeight()/(float)texture[0].getWidth();
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        width = height * texture[0].getWidth()/(float)texture[0].getHeight();
    }

    public void draw(SpriteBatch sb, float x, float y){
        sb.draw(texture[offset], x, y, width, height);
        if (maxCycle != 0){
            cycle++;
            if (cycle > maxCycle) {
                cycle = 0;
                offset++;
                if (offset > texture.length-1) offset = 0;
            }
        }
    }

    public void dispose() {
        for(Texture t : texture) t.dispose();
    }
}