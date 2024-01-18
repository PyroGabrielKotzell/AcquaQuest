package com.sussy.acquaquest.windows;

import com.sussy.acquaquest.render.actors.Fish;
import com.sussy.acquaquest.render.actors.Jelly;
import com.sussy.acquaquest.render.actors.Shark;

public class Level {
    private int multiplier, prevMult;
    private int cycle = 500, maxCycle = 500, jellyCycle = 37;
    
    public void update(){
        if (prevMult != multiplier) {
            prevMult = multiplier;
            WindowManager.getRenderer().add("shark", new Shark(5, 0.4f));
            System.out.println(multiplier);
        }
        jellyCycle++;
        cycle++;
        if (cycle >= maxCycle){
            cycle = (int)(Math.random()*61);
            maxCycle = (int)((Math.random()*10/5)*maxCycle);
            int spawnTimeMod = 30*multiplier;
            if (maxCycle < 300-spawnTimeMod) maxCycle = 400-spawnTimeMod;
            else if (maxCycle > 800-spawnTimeMod) maxCycle = 800-spawnTimeMod;
            if (Math.random() < 0.4*(multiplier == 0 ? 1 : multiplier)) WindowManager.getRenderer().add("fish", new Fish(5, 0.2f));
            if (jellyCycle >= maxCycle && Math.random() < 0.2*(multiplier == 0 ? 1 : multiplier)) {
                WindowManager.getRenderer().add("jelly", new Jelly(5, 0.2f));
                jellyCycle = (int)(Math.random()*61);
            }
        }
    }
    
    public int getMultiplier() {
        return multiplier;
    }
    
    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
