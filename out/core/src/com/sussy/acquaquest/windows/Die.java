package com.sussy.acquaquest.windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.sussy.acquaquest.render.Renderer;
import com.sussy.acquaquest.render.actors.Text;

public class Die {
    private Renderer renderer = new Renderer();
    boolean isLoaded = false;
    private int cycle = 0, maxCycle = 200;

    public void load(){
        isLoaded = true;
        renderer = new Renderer();
        renderer.init();
        renderer.add("text", new Text(WindowManager.getG().score, 1f, 1.2f, 2));
        renderer.add("text", new Text(new Texture("assets/deathText/deathText.png"), 0.5f, 2f, 3f));
        renderer.render();
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
        ScreenUtils.clear(Color.BLACK);
        renderer.render();
        cycle++;
        if (cycle >= maxCycle){
            cycle = 200;
            if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) WindowManager.changeWindow();
        }
    }
}
