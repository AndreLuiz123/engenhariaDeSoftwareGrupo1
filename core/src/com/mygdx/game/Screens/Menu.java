package com.mygdx.game.Screens;

import com.mygdx.game.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Menu implements Screen {

    Game game;
    Skin skin;
    Stage stage = new Stage();
    Viewport viewport;
    boolean trocaFase = false;

    public Menu(Game game){
        this.game = game;
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        skin = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));
        Label nome = new Label("Show dos Milhões",skin,"big");
        nome.setSize(300,Gdx.graphics.getHeight()/2);
        nome.setPosition(0,0);
        Button jogar = new TextButton("Jogar",skin,"small");
        jogar.setSize(200,100);
        jogar.setPosition(((Gdx.graphics.getWidth()/2)-jogar.getWidth()/2),(Gdx.graphics.getHeight()/2));
        jogar.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                trocaFase = true;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button comoJogar = new TextButton("Como jogar",skin,"small");
        comoJogar.setSize(200,100);
        comoJogar.setPosition(((Gdx.graphics.getWidth()/2)-comoJogar.getWidth()/2),((Gdx.graphics.getHeight()/2)-comoJogar.getHeight()-50));
        comoJogar.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button creditos = new TextButton("Creditos",skin,"small");
        creditos.setSize(200,100);
        creditos.setPosition(((Gdx.graphics.getWidth()/2)-creditos.getWidth()/2),((Gdx.graphics.getHeight()/2)-creditos.getHeight()-200));
        creditos.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button sair = new TextButton("Sair",skin,"small");
        sair.setSize(200,100);
        sair.setPosition(((Gdx.graphics.getWidth()/2)-sair.getWidth()/2),((Gdx.graphics.getHeight()/2)-creditos.getHeight()-350));
        sair.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        stage.addActor(nome);
        stage.addActor(jogar);
        stage.addActor(comoJogar);
        stage.addActor(creditos);
        stage.addActor(sair);

    }

    public void update(float delta) {
        if(trocaFase == true) {
            game.setScreen(new Play_Screen(game));
            dispose();
            trocaFase=false;
        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
        skin.dispose();
        stage.dispose();
    }
}
