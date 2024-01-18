package com.sussy.acquaquest.render.actors;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sussy.acquaquest.logic.ResourceEnum;
import com.sussy.acquaquest.logic.ResourceLoader;
import com.sussy.acquaquest.render.GameObject;
import com.sussy.acquaquest.windows.WindowManager;

public class Bait extends GameObject {
    private float charge;
    private GameObject string;
    private GameObject player;
    private boolean reverse = false;
    private int cycle = 0, maxCycle = 20;
    
    public Bait(float x, float y, float width, float charge) {
        super(ResourceLoader.getTexture(ResourceEnum.Bait), x, y, width);
        this.charge = charge;
        player = WindowManager.getG().player;
        string = new FishinString(ResourceLoader.getTexture(ResourceEnum.String), player.getX()+player.getWidth(), player.getY(), 0);
        string.getBase().setUnchangingHeight(player.getHeight()/1.5f);
        string.getBase().setUnchangingWidth(getX()+getWidth()/2-(player.getX()+player.getWidth()));
    }
    
    public void update(){
        if (charge > 0){
            x+=charge;
            charge-=0.1;
            y-=0.01;
            if (y < player.getY()-0.01f || (charge <= 0 && y != player.getY()-0.01f)) y = player.getY()-0.1f;
            string.getBase().setUnchangingHeight(player.getHeight()/1.5f);
            string.getBase().setUnchangingWidth(getX()+getWidth()/2-(player.getX()+player.getWidth()));
        }
        cycle++;
        if (cycle >= maxCycle){
            cycle = 0;
            if (reverse) {
                y += 0.01;
                reverse = false;
            } else {
                y -= 0.01;
                reverse = true;
            }
        }
    }
    
    @Override
    public void draw(SpriteBatch sb){
        string.draw(sb);
        base.draw(sb, x, y);
    }
}
