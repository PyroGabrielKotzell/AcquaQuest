package com.sussy.acquaquest.render.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.GameObject;
import com.sussy.acquaquest.render.Sprite;
import com.sussy.acquaquest.windows.WindowManager;

public class Player extends GameObject{
    private Sprite bait, idle, fish;
    private int hp = 3, row, cycle = 10, maxCycle = 20, maxupndown = 30, upndown = 0;
    private float charge = 0;
    private boolean movingUp = false, movingDown = false, launching = false, fishing = false, reverse;
    
    public Player(float x, float y, float width) {
        super(ResourceLoader.getAnimation(ResourceEnum.PlayerIdle), x, y, width, 12);
        idle = new Sprite(ResourceLoader.getAnimation(ResourceEnum.PlayerIdle), width, 15);
        bait = new Sprite(ResourceLoader.getAnimation(ResourceEnum.PlayerBait), width, 17);
        fish = new Sprite(ResourceLoader.getTexture(ResourceEnum.PlayerFishing), width);
        row = 1;
    }
    
    public void update(){
        if (hp == 0) WindowManager.dieScreen();
        boolean canmove = !movingDown && !movingUp && !fishing && !launching;
        if(Gdx.input.isKeyPressed(Input.Keys.W) && canmove && row > 0) {
            movingUp = true;
            row -= 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) && canmove && row < 2) {
            movingDown = true;
            row += 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.K) && !movingDown && !movingUp) {
            if (cycle >= maxCycle)
                if (fishing) {
                    fishing = false;
                    charge = 0;
                    cycle = 0;
                    bait.setOffset(0);
                    removeBait();
                } else {
                    launching = true;
                    charge += 0.01;
                    if (charge > 0.4){
                        charge = 0;
                        generateBait();
                    }
                }
            else cycle++;
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.K) && launching) generateBait();
        if (fishing) {
            if (idle.getOffset() > 9) {
                Sprite tmp = idle;
                idle = bait;
                bait = tmp;
                generateBait();
            }
        }
        if (movingUp){
            x += 0.003;
            y += 0.01;
            setWidth(getWidth()-0.005f);
            if ((row == 0 && y > 1.2) || (row == 1 && y > 0.7)) movingUp = false;
        }else if (movingDown){
            x -= 0.003;
            y -= 0.01;
            setWidth(getWidth()+0.005f);
            if ((row == 1 && y < 0.7) || (row == 2 && y < 0.2)) movingDown = false;
        }
        upndown++;
        if (upndown >= maxupndown){
            upndown = 0;
            if (reverse) {
                y += 0.01;
                reverse = false;
            } else {
                y -= 0.01;
                reverse = true;
            }
        }
    }

    public void getHurt(){
        hp--;
    }

    @Override
    public void draw(SpriteBatch sb){
        bait.setWidth(getWidth());
        fish.setWidth(getWidth());
        if (launching){
            bait.draw(sb, x, y);
        }else if(fishing) fish.draw(sb, x, y);
        else idle.draw(sb, x, y);
    }

    public float getWidth(){
        return idle.getWidth();
    }

    public int getRow(){
        return row;
    }

    public void setWidth(float width){
        idle.setWidth(width);
    }

    public float getHeight(){
        return idle.getHeight();
    }

    public void setHeight(float height){
        idle.setHeight(height);
    }
    
    private void removeBait() {
        WindowManager.getG().getRenderer().removeActor("bait");
    }

    private void generateBait(){
        launching = false;
        fishing = true;
        WindowManager.getG().getRenderer().add("bait", new Bait(x+getWidth(), y+getHeight()/2, getWidth()/7, charge));
    }

    public boolean ismoving(){
        return movingDown || movingUp;
    }
}
