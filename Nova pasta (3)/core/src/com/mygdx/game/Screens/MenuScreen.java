package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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

import java.util.logging.Handler;


public class MenuScreen implements Screen {

    MyGdxGame game;
    Skin skin;
    Stage stage = new Stage();
    Viewport viewport;
    boolean trocaFase = false;
    boolean credits = false;
    boolean menu = false;
    boolean ajuda = false;

    Sound sound = Gdx.audio.newSound(Gdx.files.internal("musica/force.mp3"));


    public MenuScreen(MyGdxGame game){
        this.game = game;
        sound.play(1.0f);
        sound.setLooping(500,true);
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        stageMenu();
    }

    public void stageMenu(){
        Label nome = new Label("Show dos MilhoES",skin,"big");
        nome.setSize(200,Gdx.graphics.getHeight()/2);
        nome.setPosition(Gdx.graphics.getWidth()/2 - nome.getWidth()/0.80f,Gdx.graphics.getHeight()/2);

        Button jogar = new TextButton("Jogar",skin,"small");
        jogar.setSize(Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/10);
        jogar.setPosition(((Gdx.graphics.getWidth()/2)-jogar.getWidth()/2),Gdx.graphics.getHeight()/2-jogar.getHeight()/10);
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
        comoJogar.setSize(Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/10);
        comoJogar.setPosition(((Gdx.graphics.getWidth()/2)-comoJogar.getWidth()/2),((Gdx.graphics.getHeight()/2)-comoJogar.getHeight()-20));
        comoJogar.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                ajuda = true;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button creditos = new TextButton("Creditos",skin,"small");
        creditos.setSize(Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/10);
        creditos.setPosition(((Gdx.graphics.getWidth()/2)-creditos.getWidth()/2),((Gdx.graphics.getHeight()/2)-creditos.getHeight()*2-30));
        creditos.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                credits = true;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button sair = new TextButton("Sair",skin,"small");
        sair.setSize(Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/10);
        sair.setPosition(((Gdx.graphics.getWidth()/2)-sair.getWidth()/2),((Gdx.graphics.getHeight()/2)-sair.getHeight()*3-40));
        sair.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.exit(0);
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
        if(trocaFase) {
            game.setScreen(new PlayScreen(game));
            dispose();
            trocaFase=false;
        }
        if(credits){
            stage.clear();
            mostrarCreditos();
            credits = false;
        }
        if(menu){
            stage.clear();
            stageMenu();
            menu = false;
        }
        if(ajuda){
            stage.clear();
            mostrarAjuda();
            ajuda = false;
        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0,0,0,0);
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

    public void mostrarCreditos(){
        Label texto = new Label("Andre Luiz Vasconcelos Ferreira\n" +
                "Jose Santos Sa Carvalho\n" +
                "Leonardo Nunes Aragao \n" +
                "Matheus Franklin Rodrigues Silva \n"
               ,skin,"big");
     //   texto.setStyle( new Label.LabelStyle(new BitmapFont(), Color.GOLD));
        texto.setFontScale(0.45f);
        texto.setSize(300,Gdx.graphics.getHeight()/2);
        texto.setPosition(50,Gdx.graphics.getHeight()/2);

        Button voltar = new TextButton("voltar ao menu",skin,"small");
        voltar.setSize(200,100);
        voltar.setPosition(((Gdx.graphics.getWidth()/2)-voltar.getWidth()/2),((Gdx.graphics.getHeight()/2)-voltar.getHeight()-130));
        voltar.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                menu = true;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        stage.addActor(texto);
        stage.addActor(voltar);
    }

    public void mostrarAjuda(){
        Label texto = new Label("   Lorem ipsum dolor sit amet, consectetur adipisicing elit,\n" +
                "sed do eiusmod tempor incididunt ut labore et dolore \n" +
                "magna aliqua. Ut enim ad minim veniam, quis nostrud \n" +
                "exercitation ullamco laboris nisi ut aliquip ex ea \n" +
                "commodo consequat. Duis aute irure dolor in reprehenderit \n" +
                "in voluptate velit esse cillum dolore eu fugiat nulla \n" +
                "pariatur. Excepteur sint occaecat cupidatat non proident,\n" +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.",skin,"big");
        texto.setFontScale(0.45f);
        texto.setSize(300,Gdx.graphics.getHeight()/2);
        texto.setPosition(50,Gdx.graphics.getHeight()/2);

        Button voltar = new TextButton("voltar ao menu",skin,"small");
        voltar.setSize(200,100);
        voltar.setPosition(((Gdx.graphics.getWidth()/2)-voltar.getWidth()/2),((Gdx.graphics.getHeight()/2)-voltar.getHeight()-130));
        voltar.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                menu = true;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        stage.addActor(texto);
        stage.addActor(voltar);
    }
}
