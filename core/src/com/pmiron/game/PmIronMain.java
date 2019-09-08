package com.pmiron.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.pmiron.screen.ScreenGame;

public class PmIronMain extends Game {

	private ScreenGame screenGame;

	@Override
	public void create() {
		screenGame = new ScreenGame(this);

		this.setScreen(screenGame);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
}
