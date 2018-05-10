package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Hud.Hud;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Andre Luiz on 09/05/2018.
 */

public class Menu implements Screen {

    private MyGdxGame game;
    private Hud hud;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private Texture cenario;


    public Menu(MyGdxGame game){

        this.game = game;

        this.gameCam = new OrthographicCamera();
        this.gamePort = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gameCam);

        this.hud = new Hud(game.batch);

        this.cenario = new Texture("BackGroundMenu.png");


    }



    @Override
    public void show() {

    }

    public void handleInput(float dt){


        if(Gdx.input.justTouched() && Gdx.input.getX()>(float)0.4*MyGdxGame.PPM && Gdx.input.getX()<((float)0.3*MyGdxGame.PPM + 180)
             && Gdx.input.getY()>(float)1.7*MyGdxGame.PPM  && Gdx.input.getY()<(float)2.5*MyGdxGame.PPM
                ){
            game.setScreen(new SelecaoDePersonagemModo(game));
        }

        if(Gdx.input.justTouched() && Gdx.input.getX()>(float)0.4*MyGdxGame.PPM && Gdx.input.getX()<((float)0.3*MyGdxGame.PPM + 180)
                && Gdx.input.getY()>(float)3.3*MyGdxGame.PPM  && Gdx.input.getY()<(float)4.2*MyGdxGame.PPM
                ){
            System.out.println("Deu certo");
        }

        if(Gdx.input.justTouched() && Gdx.input.getX()>(float)4.3*MyGdxGame.PPM && Gdx.input.getX()<(float)4.3*MyGdxGame.PPM +170
                && Gdx.input.getY()>(float)2.5*MyGdxGame.PPM  && Gdx.input.getY()<(float)2.5*MyGdxGame.PPM + 75

                )
        {
            System.out.println("Deu certo");
        }

    }


    public void update(float dt){


        handleInput(dt);

        hud.opcoesMenu();


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
        gamePort.update(width,height);

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
