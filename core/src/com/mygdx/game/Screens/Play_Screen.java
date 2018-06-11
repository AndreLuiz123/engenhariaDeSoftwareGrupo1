package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.Game;


/**
 * Created by Andre Luiz on 10/06/2018.
 */

public class Play_Screen  implements Screen {

    Game game;
    Texture background;
    Skin skin;
    Stage stage;

    private int personagem;

    Play_Screen(Game game){

        this.game = game;

        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        stage = new Stage();

        this.background = new Texture("BackgroundSelecaoDePersonagens.png");

        Button pedrao = new TextButton("Pedrao",skin,"small");
        pedrao.setSize((Gdx.graphics.getWidth()/8),(Gdx.graphics.getHeight()/20));
        pedrao.setPosition(((Gdx.graphics.getWidth()/2)-pedrao.getWidth()/2),(3*(Gdx.graphics.getHeight()/4))-pedrao.getHeight()/2);
        pedrao.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                personagem = 2;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button pingpong = new TextButton("Ping-Pong",skin,"small");
        pingpong.setSize((Gdx.graphics.getWidth()/8),(Gdx.graphics.getHeight()/20));
        pingpong.setPosition((Gdx.graphics.getWidth()/2)+1.1f*(Gdx.graphics.getWidth()/4),(3*(Gdx.graphics.getHeight()/4))-pingpong.getHeight()/2);
        pingpong.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                personagem = 3;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button jorge = new TextButton("Jorge",skin,"small");
        jorge.setSize((Gdx.graphics.getWidth()/8),(Gdx.graphics.getHeight()/20));
        jorge.setPosition((Gdx.graphics.getWidth()/8),(3*(Gdx.graphics.getHeight()/4))-jorge.getHeight()/2);
        jorge.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                personagem = 1;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button leonarda = new TextButton("Leonarda",skin,"small");
        leonarda.setSize((Gdx.graphics.getWidth()/8),(Gdx.graphics.getHeight()/20));
        leonarda.setPosition((Gdx.graphics.getWidth()/4)-leonarda.getWidth()/4,((Gdx.graphics.getHeight()/2))-1.2f*leonarda.getHeight());
        leonarda.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                personagem = 4;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button ricardo = new TextButton("Ricardo",skin,"small");
        ricardo.setSize((Gdx.graphics.getWidth()/8),(Gdx.graphics.getHeight()/20));
        ricardo.setPosition((Gdx.graphics.getWidth()/2)+(Gdx.graphics.getWidth()/4)-ricardo.getWidth()+ricardo.getWidth()/4,((Gdx.graphics.getHeight()/2))-1.2f*ricardo.getHeight());
        ricardo.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                personagem = 5;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button giraRoleta = new TextButton("Gira a Roleta",skin,"small");
        giraRoleta.setSize((Gdx.graphics.getWidth()/5),(Gdx.graphics.getHeight()/10));
        giraRoleta.setPosition((Gdx.graphics.getWidth())-giraRoleta.getWidth(),((Gdx.graphics.getHeight()/2)-(Gdx.graphics.getHeight()/4)));
        giraRoleta.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button descubraPalavra = new TextButton("Descubra a Palavra",skin,"small");
        descubraPalavra.setSize((Gdx.graphics.getWidth()/5),(Gdx.graphics.getHeight()/10));
        descubraPalavra.setPosition((Gdx.graphics.getWidth())-descubraPalavra.getWidth()*1.5f,giraRoleta.getY() - giraRoleta.getHeight()*2);
        descubraPalavra.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });


        stage.addActor(pedrao);
        stage.addActor(pingpong);
        stage.addActor(jorge);
        stage.addActor(leonarda);
        stage.addActor(ricardo);
        stage.addActor(giraRoleta);
        stage.addActor(descubraPalavra);
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    public void update(float delta){
        System.out.println(personagem);

    }

    @Override
    public void render(float delta) {

        update(delta);


        Gdx.gl.glClearColor(0,1,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(background,0,0,Game.WIDTH, Game.HEIGHT);
        game.batch.end();

        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height);
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
