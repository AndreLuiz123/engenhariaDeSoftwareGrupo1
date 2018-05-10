package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Hud.Hud;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Andre Luiz on 10/05/2018.
 */

public class SelecaoDePersonagemModo implements Screen {


    private MyGdxGame game;
    private Hud hud;
    private OrthographicCamera gameCam;
    private Viewport gamePort;


    public SelecaoDePersonagemModo(MyGdxGame game){

        this.game = game;

        this.gameCam = new OrthographicCamera();
        this.gamePort = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gameCam);

        this.hud = new Hud(game.batch);



    }


    @Override
    public void show() {

    }

    public void handleInput(float dt){
        if(Gdx.input.justTouched() && Gdx.input.getX()>(float)0.4*MyGdxGame.PPM && Gdx.input.getX()<((float)0.3*MyGdxGame.PPM + 180)
                && Gdx.input.getY()>(float)1.3*MyGdxGame.PPM  && Gdx.input.getY()<(float)2.5*MyGdxGame.PPM
                ){
            System.out.println("Deu certo");
        }

    }


    public void update(float dt){

        hud.opcoesSelecaoPersonagemModo();

        handleInput(dt);

    }


    @Override
    public void render(float delta) {

        update(delta);

        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

        game.batch.setProjectionMatrix(gameCam.combined);
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
