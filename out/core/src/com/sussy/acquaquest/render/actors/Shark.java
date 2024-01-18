package com.sussy.acquaquest.render.actors;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.GameObject;
import com.sussy.acquaquest.render.Sprite;
import com.sussy.acquaquest.windows.WindowManager;

public class Shark extends GameObject {
    private Sprite eat;
    private int row;
    private int cycle = 0, maxCycle = 4;
    private boolean reverse = false, attack = false;
    
    public Shark(float x, float width) {
        super(ResourceLoader.getAnimation(ResourceEnum.Shark), x, 0.7f, width, 10);
        eat = new Sprite(ResourceLoader.getAnimation(ResourceEnum.SharkAttack), WindowManager.getG().player.getWidth(), 10);
        init();
    }
    
    public void update(){
        if (!attack){
            cycle++;
            if (cycle >= maxCycle){
                cycle = 0;
                if (reverse) x+=0.02;
                else x-=0.02;
            }
        }
        if (x + getWidth() < 0 || x > 5.01) {
            x = (x > 5 ? 4.58f : 0.01f-getWidth());
            init();
            reverse = !reverse;
        }
        checkColl();
    }
    
    private void checkColl() {
        Player player = WindowManager.getG().player;
        if (attack || player.ismoving()) return;
        if(row != WindowManager.getG().player.getRow()) return;
        float pL = player.getX()+player.getWidth();
        float sL = x+getWidth();
        boolean isTouching = (sL>=pL&&x<=pL)||(sL<=pL&&sL>=player.getX());
        if (isTouching) {
            attack = true;
            x = player.getX();
        }
    }
    
    @Override
    public void draw(SpriteBatch sb){
        if (attack){
            eat.draw(sb, x, y);
            if (eat.getOffset() == 2){
                eat.setOffset(0);
                Player player = WindowManager.getG().player;
                player.getHurt();
                attack = false;
                if (reverse) x = player.getX() + player.getWidth() + 0.01f;
                else x = player.getX() - getWidth() - 0.01f;
            }
        } else {
            if (row == 0){
                if (x<2 || x>3.8) {
                    if (reverse) base.drawFlipped(sb, x, y, true, false);
                    else base.draw(sb, x, y);
                }
            }else{
                if (reverse) base.drawFlipped(sb, x, y, true, false);
                else base.draw(sb, x, y);
            }
        }
    }
    
    private void init(){
        if (Math.random() < 0.5){
            Random r = new Random();
            row = r.nextInt(3);
        } else row = WindowManager.getG().player.getRow();
        if (row == 2){
            while(y > 0.21){
                x -= 0.003;
                y -= 0.01;
                setWidth(getWidth()+0.003f);
            }
        }else if (row == 0){
            while(y < 1.1){
                x += 0.003;
                y += 0.01;
                setWidth(getWidth()-0.003f);
            }
        }else{
            while(y > 0.7){
                x -= 0.003;
                y -= 0.01;
                setWidth(getWidth()+0.003f);
            }
            while(y < 0.7){
                x += 0.003;
                y += 0.01;
                setWidth(getWidth()-0.003f);
            }
        }
    }
}
