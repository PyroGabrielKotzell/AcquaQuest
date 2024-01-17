package com.sussy.acquaquest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.sussy.acquaquest.windows.WindowManager;

public class AcquaQuest extends ApplicationAdapter {

	@Override
	public void create () {
		WindowManager.init();
	}
	
	@Override
	public void render () {
		ScreenUtils.clear(new Color(0.35f, 0.61f, 0.76f, 1));
		WindowManager.update();
	}
	
	@Override
	public void dispose () {
		WindowManager.dispose();
	}
}