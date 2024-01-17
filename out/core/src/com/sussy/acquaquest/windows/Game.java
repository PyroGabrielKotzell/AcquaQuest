package com.sussy.acquaquest.windows;

import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.Renderer;

public class Game {
    boolean isLoaded = false;
    private Renderer renderer;

    public void load(){
        isLoaded = true;
        renderer = new Renderer();
        renderer.init();
        renderer.background(ResourceLoader.getAnimation(ResourceEnum.Background));
    }

    public void unload(){
        isLoaded = false;
        renderer.dispose();
    }

    public void update(){
        renderer.render();
    }
}
