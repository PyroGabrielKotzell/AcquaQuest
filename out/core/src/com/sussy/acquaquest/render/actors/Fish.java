package com.sussy.acquaquest.render.actors;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.GameObject;
import com.sussy.acquaquest.windows.WindowManager;

public class Fish extends GameObject{
    private int row;
    private int cycle = 0, maxCycle = 4;

    public Fish(float x, float width) {
        super(ResourceLoader.getTexture(ResourceEnum.Fish), x, 0.7f, width);
        init();
    }

    public void update(){
        cycle++;
        if (cycle >= maxCycle){
            cycle = 0;
            x-=0.01;
        }
        if (x + getWidth() < 0) WindowManager.getRenderer().removeActor("fish" + this.toString());
        checkColl();
    }
    
    private void checkColl() {
        GameObject bait = WindowManager.getRenderer().getActor("bait");
        if (bait != null){
            boolean isTouching = (x<=bait.getX()+bait.getWidth()||x+getWidth()>=bait.getX()) && row == WindowManager.getRenderer().player.getRow();
            if (isTouching) {
                WindowManager.getRenderer().removeActor("fish" + this.toString());
                WindowManager.getG().addScore();
            }
        }
    }

    @Override
    public void draw(SpriteBatch sb){
        if (row == 0){
            if (x<2 || x>3.8) base.draw(sb, x, y);
        }else{
            base.draw(sb, x, y);
        }
    }

    private void init(){
        Random r = new Random();
        row = r.nextInt(3);
        if (row == 2){
            while(y > 0.21){
                x -= 0.003;
                y -= 0.01;
                setWidth(getWidth()+0.002f);
            }
        }else if (row == 0){
            while(y < 1.1){
                x += 0.003;
                y += 0.01;
                setWidth(getWidth()-0.002f);
            }
        }
    }
}
