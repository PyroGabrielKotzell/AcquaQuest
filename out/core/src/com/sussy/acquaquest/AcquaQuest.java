package com.sussy.acquaquest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class AcquaQuest extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float imgx = 1, imgy = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("jelly/Idle.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0.15f, 0.75f, 1);
		batch.begin();
		batch.draw(img, imgx, imgy);
		batch.end();
		imgx += imgx/5;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
