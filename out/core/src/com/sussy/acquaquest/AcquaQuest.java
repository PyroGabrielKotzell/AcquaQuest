package com.sussy.acquaquest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.sussy.acquaquest.render.*;
import com.sussy.acquaquest.render.actors.Player;

public class AcquaQuest extends ApplicationAdapter {
	Renderer r = new Renderer();
	float w = 1;
	boolean reverse = false;

	@Override
	public void create () {
		r.init();
		r.add("Jelly", new Player(new Texture("jelly/Idle.png"), 0, 0, 1, 1));
		r.getActor("Jelly").setWidth(1);
	}
	
	@Override
	public void render () {
		ScreenUtils.clear(0.3f, 0.55f, 1f, 1);
		r.render();
		r.getActor("Jelly").setWidth(w);
		w += !reverse ? 0.01 : -0.01;
		if (w < 1 || w > 2) reverse = !reverse;
	}
	
	@Override
	public void dispose () {
		r.dispose();
	}
}
