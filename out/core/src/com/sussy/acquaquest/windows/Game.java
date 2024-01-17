package com.sussy.acquaquest.windows;

import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.Renderer;
import com.sussy.acquaquest.render.actors.Player;

public class Game {
    boolean isLoaded = false;
    private Renderer renderer;
    private Level l;
    public int score = 0;

    public void load(){
        isLoaded = true;
        l = new Level();
        renderer = new Renderer();
        renderer.init();
        renderer.setBackground(ResourceLoader.getAnimation(ResourceEnum.Background));
        renderer.add("player", new Player(0.5f, 0.7f, 0.7f));
    }

    public void unload(){
        score = 0;
        isLoaded = false;
        renderer.dispose();
    }

    public void addScore() {
        score++;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void update(){
        renderer.render();
        l.setMultiplier(score > 3 ? (score > 10 ? (score > 15 ? 3 : 2) : 1) : 0);
        l.update();
    }
}
