package com.sussy.acquaquest.render.actors;

import com.badlogic.gdx.graphics.Texture;
import com.sussy.acquaquest.render.GameObject;

public class Text extends GameObject {

    public Text(Texture t, float x, float y, float width) {
        super(t, x, y, width);
    }

    public Text(Texture[] t, float x, float y, float width) {
        super(t, x, y, width, 15);
    }
}
