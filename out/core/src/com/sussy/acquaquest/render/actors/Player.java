package com.sussy.acquaquest.render.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.GameObject;
import com.sussy.acquaquest.render.Sprite;
import com.sussy.acquaquest.windows.WindowManager;

public class Player extends GameObject{
    private Sprite bait;
    private int hp = 3, row;
    private float charge = 0;
    private boolean movingUp = false, movingDown = false, launching = false;

    public Player( float x, float y, float width) {
        super(ResourceLoader.getAnimation(ResourceEnum.PlayerIdle), x, y, width, 8);
        bait = new Sprite(ResourceLoader.getAnimation(ResourceEnum.PlayerBait), width, 10);
        row = 1;
    }

    public void update(){
        if (hp == 0) WindowManager.changeWindow();
        if(Gdx.input.isKeyPressed(Input.Keys.W) && !movingUp && !movingDown && !launching && row > 0) {
            movingUp = true;
            row -= 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) && !movingUp && !movingDown && !launching && row < 2) {
            movingDown = true;
            row += 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.K) && !movingUp && !movingDown) {
            charge += 0.01;
            if (charge > 4) launching = true;
        }else if (Gdx.input.isKeyJustPressed(Input.Keys.K)){
            launching = true;
        }
        if (launching) {
            if (base.getOffset() > 9) launching = false;
            generateBait();
        }
        if (movingUp){
            x += 0.004;
            y += 0.01;
            setWidth(getWidth()-0.005f);
            if ((row == 0 && y > 1) || (row == 1 && y > 0.65)) movingUp = false;
        }else if (movingDown){
            x -= 0.004;
            y -= 0.01;
            setWidth(getWidth()+0.005f);
            if ((row == 1 && y < 0.65) || (row == 2 && y < 0.2)) movingDown = false;
        }
    }
    
    private void generateBait(){
        WindowManager.getG().getRenderer().add(, null);
    }
}
