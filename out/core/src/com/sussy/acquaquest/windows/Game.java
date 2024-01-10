package com.sussy.acquaquest.windows;

import com.sussy.acquaquest.render.GameObject;
import com.sussy.acquaquest.render.Renderer;

public class Game {
    boolean isLoaded = false;
    private Renderer renderer;

    public void load(){
        isLoaded = true;
        renderer = new Renderer();
        renderer.init();
        renderer.background(renderer.animator("gameBackground/"));
    }

    public void unload(){
        isLoaded = false;
        renderer.dispose();
    }

    public void update(){
        renderer.render();
        for(GameObject g : renderer.getGameObj()) g.update();
    }
}
