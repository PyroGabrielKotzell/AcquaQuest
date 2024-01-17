package com.sussy.acquaquest.windows;

import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.Renderer;
import com.sussy.acquaquest.render.actors.Player;

public class Game {
    boolean isLoaded = false;
    private Renderer renderer;

    public void load(){
        isLoaded = true;
        renderer = new Renderer();
        renderer.init();
        renderer.setBackground(ResourceLoader.getAnimation(ResourceEnum.Background));
        renderer.add("player", new Player(0.5f, 0.65f, 0.7f));
    }

    public void unload(){
        isLoaded = false;
        renderer.dispose();
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void update(){
        renderer.render();
    }
}
