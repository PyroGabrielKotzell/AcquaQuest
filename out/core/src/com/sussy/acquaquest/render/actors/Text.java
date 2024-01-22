package com.sussy.acquaquest.render.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.GameObject;
import com.sussy.acquaquest.render.Sprite;

public class Text extends GameObject {
    private boolean isN = false;
    private int score;
    private Texture[] numbers = ResourceLoader.getAnimation(ResourceEnum.Numbers);
    
    public Text(int score, float x, float y, float width) {
        super(new Texture("assets/null.png"), x, y, width);
        this.score = score;
        isN = true;
    }
    
    public Text(Texture t, float x, float y, float width) {
        super(t, x, y, width);
    }
    
    public Text(Texture[] t, float x, float y, float width) {
        super(t, x, y, width, 15);
    }
    
    @Override
    public void draw(SpriteBatch sb){
        if (!isN) base.draw(sb, x, y);
        else {
            int scoreCopy = score;
            for (int i = 5; i > -1; i--) {
                Sprite number = new Sprite(numbers[scoreCopy%10], getWidth()/6);
                scoreCopy = scoreCopy/10;
                number.draw(sb, x + getWidth()/6*i, y);
            }
        }
    }
}
