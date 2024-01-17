package com.sussy.acquaquest.windows;

import com.sussy.acquaquest.render.actors.Fish;
import com.sussy.acquaquest.render.actors.Jelly;
import com.sussy.acquaquest.render.actors.Shark;

public class Level {
    private int multiplier, prevMult;
    private int cycle = 0, maxCycle = 20;

    public void update(){
        if (prevMult != multiplier) {
            prevMult = multiplier;
            WindowManager.getRenderer().add("shark", new Shark(4, WindowManager.getRenderer().getActor("player").getY(), 0.4f));
        }
        cycle++;
        if (cycle >= maxCycle){
            cycle = 0;
            if (Math.random() < 0.3*(multiplier == 0 ? 1 : multiplier)) WindowManager.getRenderer().add("fish", new Fish(5, 0.2f));
            if (Math.random() < 0.2*(multiplier == 0 ? 1 : multiplier)) WindowManager.getRenderer().add("jelly", new Jelly(5, 0.2f));
        }
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
