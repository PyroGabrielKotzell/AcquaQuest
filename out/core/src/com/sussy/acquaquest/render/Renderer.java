package com.sussy.acquaquest.render;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sussy.acquaquest.render.actors.Player;

public class Renderer {
    private HashMap<String, GameObject> actors;
    private SpriteBatch batch;
    private Texture[] background;
    private int backOffset = 0, cycle = 0;
    public Camera cam;
    public Player player;

    public void init(){
        batch = new SpriteBatch();
        cam = new OrthographicCamera(4, 4);
        cam.position.set(2f, 2f, 0f);
        actors = new HashMap<>();
    }
    
    public void add(String name, GameObject obj){
        if (name.equals(player)) player = (Player) obj;
        if (!actors.containsKey(name)) actors.put(name, obj);
        else actors.put(name + obj.toString(), obj);
    }
    
    public void render(){
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(background[backOffset], 0, 0, cam.viewportWidth, cam.viewportHeight);
        for (GameObject g : actors.values()) {
            g.draw(batch);
            g.update();
        }
        batch.end();
        cycle++;
        if (cycle > 7) {
            cycle = 0;
            backOffset++;
            if (backOffset > background.length-1) backOffset = 0;
        }
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
    
    public void removeActor(String name) {
        actors.get(name).dispose();
        actors.remove(name);
    }
    
    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public float getWidth(){
        return cam.viewportWidth;
    }

    public float getHeight(){
        return cam.viewportHeight;
    }
    
    public void setBackground(Texture[] t){
        background = t;
    }

    public Set<String> getKeyset() {
        return actors.keySet();
    }
}
