package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.Menu;

public class Game extends com.badlogic.gdx.Game {
	SpriteBatch batch;
	Texture img;

	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new Menu(this));
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
