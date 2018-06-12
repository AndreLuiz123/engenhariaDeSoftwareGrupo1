package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
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
import com.mygdx.game.MyGdxGame;


public class MenuScreen implements Screen {

    MyGdxGame game;
    Skin skin;
    Stage stage = new Stage();
    Viewport viewport;
    boolean trocaFase = false;

    public MenuScreen(MyGdxGame game){
        this.game = game;
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Label nome = new Label("Show dos Milhoes",skin,"big");
        Button jogar = new TextButton("Jogar",skin,"small");
        nome.setSize(300,Gdx.graphics.getHeight()/2);
        nome.setPosition(Gdx.graphics.getWidth()/2 - nome.getWidth()/1.3f,Gdx.graphics.getHeight()/2);

        jogar.setSize(100,50);
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
        comoJogar.setSize(100,50);
        comoJogar.setPosition(((Gdx.graphics.getWidth()/2)-comoJogar.getWidth()/2),((Gdx.graphics.getHeight()/2)-comoJogar.getHeight()-10));
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
        creditos.setSize(100,50);
        creditos.setPosition(((Gdx.graphics.getWidth()/2)-creditos.getWidth()/2),((Gdx.graphics.getHeight()/2)-creditos.getHeight()-70));
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

<<<<<<< HEAD
        private void fecharApp() {
            AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
            builder.setMessage("Você deseja fechar o aplicativo?");
            builder.setCancelable(true);
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    System.exit(0);

                }
            });
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }

=======
>>>>>>> 5e7da2a4ee2060311043bd0575454238c1e06dd9
        Button sair = new TextButton("Sair",skin,"small");
        sair.setSize(100,50);
        sair.setPosition(((Gdx.graphics.getWidth()/2)-sair.getWidth()/2),((Gdx.graphics.getHeight()/2)-creditos.getHeight()-130));
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
            game.setScreen(new PlayScreen(game));
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
        Gdx.gl.glClearColor(0,1,1,0);
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
