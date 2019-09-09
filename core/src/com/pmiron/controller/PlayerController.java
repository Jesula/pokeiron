package com.pmiron.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import model.Actor;
import model.DIRECTION;

public class PlayerController extends InputAdapter {

    private Actor actor;
    private boolean up, down, left, right;

    public PlayerController(Actor p){
        this.actor = p;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.UP) {
            up = true;
        } else if (keycode == Input.Keys.DOWN){
            down = true;
        } else if (keycode == Input.Keys.LEFT){
            left = true;
        } else if (keycode == Input.Keys.RIGHT){
            right = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.UP) {
            up = true;
        } else if (keycode == Input.Keys.DOWN){
            down = true;
        } else if (keycode == Input.Keys.LEFT){
            left = true;
        } else if (keycode == Input.Keys.RIGHT){
            right = true;
        }
        return false;
    }

    public void update(float delta){
        if (up){actor.move(DIRECTION.NORTH); return;}
        if (down){actor.move(DIRECTION.SOUTH); return;}
        if (right){actor.move(DIRECTION.EAST); return;}
        if (left){actor.move(DIRECTION.WEST); return;}

    }
}
