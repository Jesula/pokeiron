package model;

import com.badlogic.gdx.math.Interpolation;

public class Actor {

    private TileMap map;
    private int x;
    private int y;

    private float worldX, worldY;
// Variables for animation
    private int srcX, srcY;
    private int desX, desY;
    private float animTimer;
    private float ANIM_TIME = 0.5f;

    private ACTOR_STATE state;

    public Actor(TileMap map, int x, int y){
        this.map = map;
        this.x = x;
        this.y = y;
        this.worldX = x;
        this.worldY = y;
        map.getTile(x, y).setActor(this);
        this.state = ACTOR_STATE.STANDING;
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
            worldX = Interpolation.linear.apply(srcX, desX, animTimer/ANIM_TIME);
            worldY = Interpolation.linear.apply(srcY, desY, animTimer/ANIM_TIME);
            if (animTimer > ANIM_TIME){
                finishMove();
            }
        }
    }

    public boolean move(int dx, int dy){
        if (state != ACTOR_STATE.STANDING){
            return false;
        }
        if (x+dx >= map.getWidth() || x+dx < 0 || y+dy >= map.getHeight() || y+dy < 0){
            return false;
        }
        if (map.getTile(x+dx, y+dy).getActor() != null){
            return false;
        }
       initMove(x, y, dx, dy);
        map.getTile(x, y).setActor(null);
        x += dx;
        y += dy;
        map.getTile(x, y).setActor(this);
        return true;
    }

    private void initMove(int oldX, int oldY, int dx, int dy){
        this.srcX = oldX;
        this.srcY = oldY;
        this.desX = oldX+dx;
        this.desY = oldY+dy;
        this.worldX = oldX;
        this.worldY = oldY;
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
}
