package com.sussy.acquaquest.render.actors;

import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.GameObject;

public class Text extends GameObject {

    public Text(float x, float y, float width) {
        super(ResourceLoader.getAnimation(ResourceEnum.Menutxt), x, y, width, 15);
    }
}
