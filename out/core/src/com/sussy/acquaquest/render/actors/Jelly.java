package com.sussy.acquaquest.render.actors;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.GameObject;
import com.sussy.acquaquest.windows.WindowManager;

public class Jelly extends GameObject{
    private int row;
    private int cycle = 0, maxCycle = 4;

    public Jelly(float x, float width) {
        super(ResourceLoader.getAnimation(ResourceEnum.Jelly), x, 0.7f, width, 20);
        init();
    }

    public void update(){
        cycle++;
        if (cycle >= maxCycle){
            cycle = 0;
            x-=0.017;
        }
        if (x + getWidth() < 0) WindowManager.getRenderer().removeActors("jelly" + this.toString());
        checkColl();
    }
    
    private void checkColl() {
        if(row != WindowManager.getG().player.getRow()) return;
        GameObject bait = WindowManager.getRenderer().getActor("bait", 0);
        if (bait != null){
            float bL = bait.getX()+bait.getWidth();
            float jL = x+getWidth();
            boolean isTouching = (jL>=bL&&x<=bL)||(jL<=bL&&jL>=bait.getX());
            if (isTouching) {
                WindowManager.getRenderer().removeActor("jelly", this);
                WindowManager.getG().player.getHurt();
                x = 5;
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
