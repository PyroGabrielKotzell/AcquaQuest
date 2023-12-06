package com.sussy.acquaquest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class AcquaQuest extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float imgx = 1, imgy = 0, speed = 1.1f;
	Camera cam;
	
	@Override
	public void create () {
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		img = new Texture("jelly/Idle.png");
	}

	// https://forums.getpaint.net/topic/17516-sprite-animation-helper-v-1013-updated-april-30-2022/

	@Override
	public void render () {
		ScreenUtils.clear(0.3f, 0.55f, 1f, 1);
		cam.update();
		batch.setProjectionMatrix(cam.projection);
		batch.begin();
		batch.draw(img, imgx, imgy);
		batch.end();
		imgx += speed;
		speed += Math.log(speed);
		if (speed > 900) speed = 1.1f;
		if (imgx > 600) imgx = -img.getWidth();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
