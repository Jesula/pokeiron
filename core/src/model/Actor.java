package model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.pmiron.util.AnimationSet;

public class Actor {

    private TileMap map;
    private int x;
    private int y;
    private DIRECTION facing;

    private float worldX, worldY;
// Variables for animation
    private int srcX, srcY;
    private int desX, desY;
    private float animTimer;
    private float ANIM_TIME = 0.3f;

    private float walkTimer;
    private boolean moveRequestThisFrame;

    private ACTOR_STATE state;

    private AnimationSet animationSet;

    public Actor(TileMap map, int x, int y, AnimationSet animationSet){
        this.map = map;
        this.x = x;
        this.y = y;
        this.worldX = x;
        this.worldY = y;
        this.animationSet = animationSet;
        map.getTile(x, y).setActor(this);
        this.state = ACTOR_STATE.STANDING;
        this.facing = DIRECTION.SOUTH;
    }

    private enum ACTOR_STATE {
        WALKING,
        STANDING,
        BIKING,
        SURFING;
    }

    public void update(float delta){
        if (state == ACTOR_STATE.WALKING){
            animTimer += delta;
            walkTimer += delta;
            worldX = Interpolation.linear.apply(srcX, desX, animTimer/ANIM_TIME);
            worldY = Interpolation.linear.apply(srcY, desY, animTimer/ANIM_TIME);
            if (animTimer > ANIM_TIME){
                float leftOverTime = animTimer =ANIM_TIME;
                walkTimer -= leftOverTime;
                finishMove();
                if (moveRequestThisFrame){
                    move(facing);
                } else {
                    walkTimer = 0f;
                }
            }
        }
        moveRequestThisFrame = false;
    }

    public boolean move(DIRECTION direction){
        if (state == ACTOR_STATE.WALKING){
            if(facing == direction){
                moveRequestThisFrame = true;
            }
            return false;
        }
        if (x+direction.getDx() >= map.getWidth() || x+direction.getDx() < 0 || y+direction.getDy() >= map.getHeight() || y+direction.getDy() < 0){
            return false;
        }
        if (map.getTile(x+direction.getDx(), y+direction.getDy()).getActor() != null){
            return false;
        }
       initMove(direction);
        map.getTile(x, y).setActor(null);
        x += direction.getDx();
        y += direction.getDy();
        map.getTile(x, y).setActor(this);
        return true;
    }

    private void initMove(DIRECTION direction){
        this.facing = direction;
        this.srcX = x;
        this.srcY = y;
        this.desX = x+direction.getDx();
        this.desY = y+direction.getDy();
        this.worldX = x;
        this.worldY = y;
        state = ACTOR_STATE.WALKING;

    }

    private void finishMove(){
        state = ACTOR_STATE.STANDING;
        this.worldX = desX;
        this.worldY = desY;
        this.srcX = 0;
        this.srcY = 0;
        this.desX = 0;
        this.desY = 0;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public float getWorldX() {
        return worldX;
    }

    public float getWorldY() {
        return worldY;
    }

    public TextureRegion getSprite(){
        if (state == ACTOR_STATE.WALKING){
            return animationSet.getWalking(facing);
        } else if (state == ACTOR_STATE.STANDING){
            return animationSet.getStanding(facing);
        }
        return animationSet.getStanding(DIRECTION.SOUTH);
    }
}
