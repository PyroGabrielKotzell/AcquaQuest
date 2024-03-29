package com.sussy.acquaquest.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.Renderer;
import com.sussy.acquaquest.render.actors.Text;

public class Menu {
    boolean isLoaded = false;
    private Renderer renderer;

    public void load(){
        isLoaded = true;
        renderer = new Renderer();
        renderer.init();
        renderer.setBackground(ResourceLoader.getAnimation(ResourceEnum.Background));
        renderer.add("Text", new Text(ResourceLoader.getAnimation(ResourceEnum.Menutxt), 0, 0, renderer.getWidth()));
    }

    public void unload(){
        isLoaded = false;
    }

    public void dispose(){
        renderer.dispose();
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void update(){
        renderer.render();
        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) WindowManager.changeWindow();
    }
}
