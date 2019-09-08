package com.pmiron.screen;

import com.badlogic.gdx.Screen;
import com.pmiron.game.PmIronMain;

public abstract class ScreenAbstract implements Screen{

    private PmIronMain app;

    public ScreenAbstract(PmIronMain app){
        this.app = app;
    }

    @Override
    public abstract void show();

    @Override
    public abstract void render(float delta);

    @Override
    public abstract void resize(int width, int height);

    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public abstract void hide();

    @Override
    public abstract void dispose();
}
