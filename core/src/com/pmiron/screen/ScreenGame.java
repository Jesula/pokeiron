package com.pmiron.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pmiron.controller.PlayerController;
import com.pmiron.game.PmIronMain;
import com.pmiron.game.Settings;
import model.Actor;
import model.Camera;
import model.TERRAIN;
import model.TileMap;

public class ScreenGame extends ScreenAbstract {

    private PlayerController playerController;

    private Camera camera;
    private Actor player;
    private TileMap map;
    private SpriteBatch spriteBatch;
    private Texture playerSprite;
    private Texture grassOne;



    public ScreenGame(PmIronMain app) {
        super(app);
        playerSprite = new Texture(Gdx.files.local("res/kris_sprite_front.png"));
        grassOne = new Texture(Gdx.files.local("res/grass_1.png"));
        spriteBatch = new SpriteBatch();

        map = new TileMap(10, 10);
        player = new Actor(map, 0, 0);
        camera = new Camera();

        playerController = new PlayerController(player);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(playerController);
    }

    @Override
    public void render(float delta) {
        player.update(delta);
        camera.updateCamera(player.getWorldX() + 0.5f, player.getWorldY() + 0.5f);
        spriteBatch.begin();

        float worldStartX = Gdx.graphics.getWidth()/2 - camera.getCameraX()*Settings.SCALED_TILE_SIZE;
        float worldStartY = Gdx.graphics.getHeight()/2 - camera.getCameraY()*Settings.SCALED_TILE_SIZE;

        for (int x = 0; x < map.getWidth(); x++){
            for(int y = 0; y < map.getHeight(); y++){
                Texture render;
                if (map.getTile(x, y).getTerrain() == TERRAIN.GRASS_1){
                    render = grassOne;
                } else {
                    render = null;
                }
                spriteBatch.draw(render,
                        worldStartX+x*Settings.SCALED_TILE_SIZE,
                        worldStartY+y*Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE,
                        Settings.SCALED_TILE_SIZE);
            }
        }

        spriteBatch.draw(playerSprite,
                worldStartX+player.getWorldX()*Settings.SCALED_TILE_SIZE,
                worldStartY+player.getWorldY()*Settings.SCALED_TILE_SIZE,
                Settings.PLAYER_SPRITE_SIZE,
                Settings.PLAYER_SPRITE_SIZE);
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
