package com.pmiron.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import model.Actor;

public class PlayerController extends InputAdapter {

    private Actor actor;

    public PlayerController(Actor p){
        this.actor = p;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.UP) {
            actor.move(0, 1);
        } else if (keycode == Input.Keys.DOWN){
            actor.move(0, -1);
        } else if (keycode == Input.Keys.LEFT){
            actor.move(-1, 0);
        } else if (keycode == Input.Keys.RIGHT){
            actor.move(1, 0);
        }


        return false;
    }


}
