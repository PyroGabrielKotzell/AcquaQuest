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
	float imgx = 0, imgy = 0, speed = 0.01f, asRatio, asRatio2;
	Camera cam;
	
	@Override
	public void create () {
		asRatio = Gdx.graphics.getWidth()/(float)Gdx.graphics.getHeight();
		asRatio2 = Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();
		cam = new OrthographicCamera(4, 4 * asRatio2);
		cam.position.set(2f, 4f * asRatio2 * 0.5f, 0f);
		batch = new SpriteBatch();
		img = new Texture("jelly/Idle.png");
	}
	
	// https://forums.getpaint.net/topic/17516-sprite-animation-helper-v-1013-updated-april-30-2022/
	
	@Override
	public void render () {
		ScreenUtils.clear(0.3f, 0.55f, 1f, 1);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(img, imgx, imgy, 1.5f, 0.5f);
		batch.end();
		imgx += speed;
		speed += 0.01f;
		if (speed > 0.25f) speed = 0.25f;
		if (imgx > 4) {
			imgx = -1.5f;
			speed = 0.01f;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
