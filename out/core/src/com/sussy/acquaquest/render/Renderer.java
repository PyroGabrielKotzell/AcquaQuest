package com.sussy.acquaquest.render;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderer {
    private HashMap<String, GameObject> actors = new HashMap<>();

    public void add(String name, Texture texture, float x, float y, float width, float height){
        actors.put(name, new GameObject(texture, x, y, width, height));
    }

    public void render(SpriteBatch batch){
        for (GameObject gameObj : actors.values()) {
            batch.draw(gameObj.getT(), gameObj.getX(), gameObj.getY(), gameObj.getWidth(), gameObj.getHeight());
        }
    }

    public GameObject getSprite(String name) {
        return actors.get(name);
    }
}
