package com.pmiron.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pmiron.game.PmIronMain;

public class ScreenGame extends ScreenAbstract {

    private SpriteBatch spriteBatch;
    private Texture playerSprite;

    public ScreenGame(PmIronMain app) {
        super(app);

        playerSprite = new Texture(Gdx.files.local("res/test.png"));
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        spriteBatch.begin();
        spriteBatch.draw(playerSprite, 0, 0, 56, 56);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
