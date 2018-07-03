package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Andre Luiz on 03/07/2018.
 */

public class Pause {


    MyGdxGame game;
    Skin skin;
    Stage stage = new Stage();
    Viewport viewport;
    boolean trocaFase = false;
    boolean credits = false;
    boolean voltarJogo,voltarMenu;

    Button jogar;
    Button menu;
    boolean ajuda = false;

    Pause(){

        this.game = game;

        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        stageMenu();



    }

    public void stageMenu(){
        Button jogar = new TextButton("Voltar ao jogo",skin,"small");
        jogar.setSize(Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/10);
        jogar.setPosition(((Gdx.graphics.getWidth()/2)-jogar.getWidth()/2),Gdx.graphics.getHeight()/2-jogar.getHeight()/10);
        jogar.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                voltarJogo=true;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        menu = new TextButton("Voltar ao menu",skin,"small");
        menu.setSize(Gdx.graphics.getWidth()/8,Gdx.graphics.getHeight()/10);
        menu.setPosition(((Gdx.graphics.getWidth()/2)-jogar.getWidth()/2),Gdx.graphics.getHeight()/2-jogar.getHeight()/10);
        menu.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                voltarMenu=true;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        stage.addActor(menu);
        stage.addActor(jogar);
    }


    public void update(){



        if(voltarMenu){
            game.setScreen(new MenuScreen(game));
            dispose();
        }

        if(voltarJogo){
            stage.dispose();
        }


    }

    public void dispose(){
        stage.clear();
        stage.dispose();
    }

}
