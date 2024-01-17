package com.sussy.acquaquest.render.actors;

import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.GameObject;
import com.sussy.acquaquest.windows.WindowManager;

public class Jelly extends GameObject{
    private int row;

    public Jelly(float x, float width) {
        super(ResourceLoader.getAnimation(ResourceEnum.Jelly), x, WindowManager.getRenderer().getActor("player").getY(), width, 20);
    }
    
}
