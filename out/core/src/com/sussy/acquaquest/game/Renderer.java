package com.sussy.acquaquest.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderer {
    private ArrayList<Sprite> sprites = new ArrayList<>();

    public void add(Sprite s){
        sprites.add(s);
    }

    public void add(Texture t, float x, float y){
        sprites.add(new Sprite(t, x, y));
    }

    public void add(String path, float x, float y){
        sprites.add(new Sprite(new Texture(path), x, y));
    }

    public void render(SpriteBatch batch){
        for (Sprite s : sprites) {
            batch.draw(s.getTexture(), s.getX(), s.getY(), s.getWidth()*s.getAsRatio(), s.getHeight()*s.getAsRatio());
        }
    }

    public Sprite getSprite(int i) {
        return sprites.get(i);
    }
}
