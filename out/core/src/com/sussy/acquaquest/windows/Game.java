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
    public Player player;

    public void load(){
        score = 0;
        isLoaded = true;
        l = new Level();
        renderer = new Renderer();
        renderer.init();
        renderer.setBackground(ResourceLoader.getAnimation(ResourceEnum.Background));
        player = new Player(0.5f, 0.7f, 0.7f);
        renderer.add("player", player);
    }

    public void unload(){
        isLoaded = false;
    }

    public void dispose(){
        renderer.dispose();
    }

    public void addScore() {
        score++;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void update(){
        //addScore();
        renderer.render();
        l.setMultiplier(score > 2 ? (score > 9 ? (score > 14 ? 3 : 2) : 1) : 0);
        l.update();
    }
}
