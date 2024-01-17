package com.sussy.acquaquest.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.Renderer;
import com.sussy.acquaquest.render.actors.Text;

public class Die {
    private Renderer renderer = new Renderer();
    boolean isLoaded = false;

    public void load(){
        isLoaded = true;
        renderer = new Renderer();
        renderer.init();
        ScreenUtils.clear(new Color(0, 0, 0, 1));
        renderer.setBackground(ResourceLoader.getAnimation(ResourceEnum.Background));
        renderer.add("text", new Text(ResourceLoader.getAnimation(ResourceEnum.Menutxt), 0, 0, renderer.getWidth()));
        renderer.render();
    }

    public void unload(){
        isLoaded = false;
        renderer.dispose();
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) WindowManager.changeWindow();
    }
}
