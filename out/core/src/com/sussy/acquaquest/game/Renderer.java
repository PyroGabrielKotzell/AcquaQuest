package com.sussy.acquaquest.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Renderer {
    public void render(SpriteBatch batch){
        for (Sprite s : sprites) {
            batch.draw(s, s.x, x.y, s.w, s.h);
        }
    }
}
