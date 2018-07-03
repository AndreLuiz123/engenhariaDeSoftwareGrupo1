package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.MenuScreen;
import com.mygdx.game.Screens.ModoDescubraPalavra;
import com.mygdx.game.Screens.ModoGiraRoleta;

public class MyGdxGame extends Game {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 480;

	public SpriteBatch batch;


	@Override
	public void create () {
		batch = new SpriteBatch();
        setScreen(new ModoDescubraPalavra(this));

	}

	@Override
	public void render () {

            super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
