package com.sussy.acquaquest.render;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderer {
    private ConcurrentHashMap<String, CopyOnWriteArrayList<GameObject>> actors;
    private SpriteBatch batch;
    private Texture[] background = null;
    private int backOffset = 0, cycle = 0;
    public Camera cam;
    
    public void init(){
        batch = new SpriteBatch();
        cam = new OrthographicCamera(4, 4);
        cam.position.set(2f, 2f, 0f);
        actors = new ConcurrentHashMap<>();
    }
    
    public void add(String name, GameObject obj){
        if (!actors.containsKey(name)) actors.put(name, new CopyOnWriteArrayList<GameObject>());
        actors.get(name).add(obj);
    }
    
    public void render(){
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        if (background != null) {
            batch.draw(background[backOffset], 0, 0, cam.viewportWidth, cam.viewportHeight);
            cycle++;
            if (cycle > 7) {
                cycle = 0;
                backOffset++;
                if (backOffset > background.length-1) backOffset = 0;
            }
        }
        for (CopyOnWriteArrayList<GameObject> list : actors.values()) {
            for (GameObject g : list){
                g.draw(batch);
                g.update();
            }
        }
        batch.end();
    }
    
    public void dispose(){
        batch.dispose();
        for (CopyOnWriteArrayList<GameObject> list : actors.values()) for (GameObject g : list) g.dispose();
    }
    
    public GameObject getActor(String name, int index) {
        CopyOnWriteArrayList<GameObject> list = actors.get(name);
        if (list != null) return list.get(index);
        return null;
    }
    
    public CopyOnWriteArrayList<GameObject> getActors(String name) {
        return actors.get(name);
    }
    
    public void removeActors(String name) {
        actors.remove(name);
    }
    
    public void removeActor(String name, GameObject obj) {
        actors.get(name).remove(obj);
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
