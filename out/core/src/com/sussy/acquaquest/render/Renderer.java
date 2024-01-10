package com.sussy.acquaquest.render;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderer {
    private HashMap<String, GameObject> actors;
    private SpriteBatch batch;
    private Texture[] background;
    private int backOffset = 0;
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
        batch.draw(background[backOffset], 0, cam.viewportHeight/2, cam.viewportWidth, cam.viewportHeight/2);
        for (GameObject g : actors.values()) {
            batch.draw(g.getT()[g.getS().offset], g.getX(), g.getY(), g.getWidth(), g.getHeight());
            g.getS().offset++;
            if(g.getS().offset>g.getS().getTexture().length-1) g.getS().offset = 0;
        }
        batch.end();
        backOffset++;
        if (backOffset > background.length-1) backOffset = 0; 
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

    public Texture[] animator(String s){
        File[] fs = new File(s).listFiles();
        Texture[] t = new Texture[fs.length];
        for(int i = 0; i < fs.length; i++) t[i] = new Texture(fs[i].getName());
        return t;
    }

    public void background(Texture[] t){
        background = t;
    }
}
