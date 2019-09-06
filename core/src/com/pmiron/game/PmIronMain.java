package com.pmiron.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PmIronMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	float x = 0;
	float y = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("scalder_test2.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.isKeyPressed(Input.Keys.W)){
			y = y + 2;
		} else if (Gdx.input.isKeyPressed(Input.Keys.S)){
			y = y - 2;
		} else if (Gdx.input.isKeyPressed(Input.Keys.A)){
			x = x - 2;
		} else if (Gdx.input.isKeyPressed(Input.Keys.D)){
			x = x + 2;
		}

		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
