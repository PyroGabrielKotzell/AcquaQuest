package com.sussy.acquaquest.render;

import java.util.Collection;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderer {
    private HashMap<String, GameObject> actors;
    private SpriteBatch batch;
    public Camera cam;

    public void init(){
        batch = new SpriteBatch();
        float asRatio2 = Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();
        cam = new OrthographicCamera(4, 4 * asRatio2);
        cam.position.set(2f, 4f * asRatio2 * 0.5f, 0f);
        actors = new HashMap<>();
    }

    public void add(String name, GameObject obj){
        actors.put(name, obj);
    }

    public void render(){
        cam.update();
		batch.setProjectionMatrix(cam.combined);
        batch.begin();
        for (GameObject gameObj : actors.values()) {
            batch.draw(gameObj.getT(), gameObj.getX(), gameObj.getY(), gameObj.getWidth(), gameObj.getHeight());
        }
        batch.end();
    }

    public void dispose(){
        batch.dispose();
        for (GameObject gameObj : actors.values()) {
            gameObj.dispose();
        }
    }

    public Collection<GameObject> getGameObj(){
        return actors.values();
    }

    public GameObject getActor(String name) {
        return actors.get(name);
    }

    public GameObject removeActor(String name) {
        return actors.remove(name);
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }
}
