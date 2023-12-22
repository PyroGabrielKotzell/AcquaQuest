package com.sussy.acquaquest.render;

import java.util.Collection;
import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderer {
    private HashMap<String, GameObject> actors = new HashMap<>();

    public void add(String name, GameObject obj){
        actors.put(name, obj);
    }

    public void render(SpriteBatch batch){
        for (GameObject gameObj : actors.values()) {
            batch.draw(gameObj.getT(), gameObj.getX(), gameObj.getY(), gameObj.getWidth(), gameObj.getHeight());
        }
    }

    public Collection<GameObject> getGameObj(){
        return actors.values();
    }

    public GameObject getActor(String name) {
        return actors.get(name);
    }
}
