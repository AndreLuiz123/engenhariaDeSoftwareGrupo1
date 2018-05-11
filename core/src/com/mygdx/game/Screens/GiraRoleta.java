package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BancoDeDados.Pergunta;
import com.mygdx.game.BancoDeDados.PerguntasGiraRoleta;
import com.mygdx.game.Hud.Hud;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Andre Luiz on 10/05/2018.
 */

public class GiraRoleta implements Screen {

    private MyGdxGame game;
    private Hud hud;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private PerguntasGiraRoleta bancoDeDados;
    int i=0;


    public GiraRoleta(MyGdxGame game){

        i=0;

        this.game = game;

        this.gameCam = new OrthographicCamera();
        this.gamePort = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, gameCam);

        this.hud = new Hud(game.batch);

        bancoDeDados = new PerguntasGiraRoleta();

    }


    @Override
    public void show() {

    }

    public void handleInput(float dt){

        if(Gdx.input.justTouched()){
            i++;
        }
    }



    public void update(float dt){

        hud.modoGiraRoleta(bancoDeDados.getPergunta(i));

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
