package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.Auxiliares.GerenciadorPerguntas;
import com.mygdx.game.Auxiliares.Pergunta;
import com.mygdx.game.Auxiliares.Roleta;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;

/**
 * Created by Andre Luiz on 10/06/2018.
 */

public class PlayScreen  implements Screen {

    private MyGdxGame game;
    private Texture background;
    private Skin skin;
    private Stage stage;

    private int personagem, modo;

    private OrthographicCamera gameCam;

    private World world;
    private Box2DDebugRenderer b2dr;

    private Roleta roleta;
    private boolean girando;
    private float var;

    private GerenciadorPerguntas gerPerg;

    private Pergunta perg;
    private int resppergunta;
    private int catpergunta;

    Label pergunta, optA, optB, optC, optD;

    PlayScreen(MyGdxGame game) {

        this.game = game;

        girando = false;


        gameCam = new OrthographicCamera();
        //BOX2D
        world = new World(new Vector2(0, 0), true);
        b2dr = new Box2DDebugRenderer();
        roleta = new Roleta(world);


        //BOTOES
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        stage = new Stage();

        //Modo Gira Roleta
        gerPerg = new GerenciadorPerguntas();


        this.background = new Texture("BackgroundSelecaoDePersonagens.png");

        Button pedrao = new TextButton("Pedrao", skin, "small");
        pedrao.setSize((Gdx.graphics.getWidth() / 8), (Gdx.graphics.getHeight() / 20));
        pedrao.setPosition(((Gdx.graphics.getWidth() / 2) - pedrao.getWidth() / 2), (3 * (Gdx.graphics.getHeight() / 4)) - pedrao.getHeight() / 2);
        pedrao.addListener(new InputListener() {

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

        Button pingpong = new TextButton("Ping-Pong", skin, "small");
        pingpong.setSize((Gdx.graphics.getWidth() / 8), (Gdx.graphics.getHeight() / 20));
        pingpong.setPosition((Gdx.graphics.getWidth() / 2) + 1.1f * (Gdx.graphics.getWidth() / 4), (3 * (Gdx.graphics.getHeight() / 4)) - pingpong.getHeight() / 2);
        pingpong.addListener(new InputListener() {

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

        Button jorge = new TextButton("Jorge", skin, "small");
        jorge.setSize((Gdx.graphics.getWidth() / 8), (Gdx.graphics.getHeight() / 20));
        jorge.setPosition((Gdx.graphics.getWidth() / 8), (3 * (Gdx.graphics.getHeight() / 4)) - jorge.getHeight() / 2);
        jorge.addListener(new InputListener() {

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

        Button leonarda = new TextButton("Eleonora", skin, "small");
        leonarda.setSize((Gdx.graphics.getWidth() / 8), (Gdx.graphics.getHeight() / 20));
        leonarda.setPosition((Gdx.graphics.getWidth() / 4) - leonarda.getWidth() / 4, ((Gdx.graphics.getHeight() / 2)) - 1.2f * leonarda.getHeight());
        leonarda.addListener(new InputListener() {

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

        Button ricardo = new TextButton("Ricardo", skin, "small");
        ricardo.setSize((Gdx.graphics.getWidth() / 8), (Gdx.graphics.getHeight() / 20));
        ricardo.setPosition((Gdx.graphics.getWidth() / 2) + (Gdx.graphics.getWidth() / 4) - ricardo.getWidth() + ricardo.getWidth() / 4, ((Gdx.graphics.getHeight() / 2)) - 1.2f * ricardo.getHeight());
        ricardo.addListener(new InputListener() {

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

        Button giraRoleta = new TextButton("Gira a Roleta", skin, "small");
        giraRoleta.setSize((Gdx.graphics.getWidth() / 5), (Gdx.graphics.getHeight() / 10));
        giraRoleta.setPosition((Gdx.graphics.getWidth()) - giraRoleta.getWidth(), ((Gdx.graphics.getHeight() / 2) - (Gdx.graphics.getHeight() / 4)));
        giraRoleta.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                modo = 1;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button descubraPalavra = new TextButton("Descubra a Palavra", skin, "small");
        descubraPalavra.setSize((Gdx.graphics.getWidth() / 5), (Gdx.graphics.getHeight() / 10));
        descubraPalavra.setPosition((Gdx.graphics.getWidth()) - descubraPalavra.getWidth() * 1.5f, giraRoleta.getY() - giraRoleta.getHeight() * 2);
        descubraPalavra.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                modo = 2;
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

    public void update(float delta) {
        world.step(1f / 60f, 6, 2);
        System.out.println(roleta.b2body.getAngularVelocity());


        if (modo == 2) {

            disposeSelecaoPersonagem();
            montaModoGiraRoleta();
            modo = 4;
        } else {
            if (modo == 1) {
                disposeSelecaoPersonagem();
                montaModoGiraRoleta();
                modo = 3;
            }
        }

        if (modo == 3) {











            if(perg.eRespostaCorreta(resppergunta)){
                switch (resppergunta){
                    case 0: optA.setStyle(new Label.LabelStyle(new BitmapFont(), Color.BLUE));break;
                    case 1: optB.setStyle(new Label.LabelStyle(new BitmapFont(), Color.BLUE));break;
                    case 2: optC.setStyle(new Label.LabelStyle(new BitmapFont(), Color.BLUE)); break;
                    case 3: optD.setStyle(new Label.LabelStyle(new BitmapFont(), Color.BLUE)); break;
                }
            }else{
                switch (resppergunta){
                    case 0: optA.setStyle(new Label.LabelStyle(new BitmapFont(), Color.RED));break;
                    case 1: optB.setStyle(new Label.LabelStyle(new BitmapFont(), Color.RED));break;
                    case 2: optC.setStyle(new Label.LabelStyle(new BitmapFont(), Color.RED)); break;
                    case 3: optD.setStyle(new Label.LabelStyle(new BitmapFont(), Color.RED)); break;
                }
            }

        }


    }

    @Override
    public void render(float delta) {
        update(delta);
        if (modo == 0) {
            Gdx.gl.glClearColor(0, 1, 0, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            game.batch.begin();
            game.batch.draw(background, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
            game.batch.end();

            stage.act();
            stage.draw();
        } else {
            if (modo == 3) {
                Gdx.gl.glClearColor(0, 1, 0, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                stage.act();
                stage.draw();
            } else {
                if (modo == 4) {
                    Gdx.gl.glClearColor(1, 0, 0, 0);
                    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                    stage.act();
                    stage.draw();
                }
            }
        }



        b2dr.render(world, gameCam.combined);



    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
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

    public void montaModoGiraRoleta() {


        resppergunta = 5;
        final Button opA = new TextButton("A", skin, "small");
        opA.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opA.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)));
        opA.addListener(new InputListener() {


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                resppergunta = 0;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        final Button opB = new TextButton("B", skin, "small");
        opB.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opB.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - opB.getHeight());
        opB.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                resppergunta = 1;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        final Button opC = new TextButton("C", skin, "small");
        opC.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opC.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - 2 * opC.getHeight());
        opC.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                resppergunta = 2;

                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        final Button opD = new TextButton("D", skin, "small");
        opD.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opD.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - 3 * opD.getHeight());
        opD.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                resppergunta = 3;

                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        catpergunta = 1;

        switch (catpergunta){
            case 0 : perg = gerPerg.geraPergunta0(); break;
            case 1 : perg = gerPerg.geraPergunta1(); break;
            case 2 : perg = gerPerg.geraPergunta2(); break;
            case 3 : perg = gerPerg.geraPergunta3(); break;
            default: break;
        }

        pergunta = new Label(perg.getTexto(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        pergunta.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 3)));
        optA = new Label(perg.getAlta(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        optA.setPosition(opA.getWidth(), ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)));
        optB = new Label(perg.getAltb(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        optB.setPosition(opB.getWidth(), ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - opB.getHeight());
        optC = new Label(perg.getAltc(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        optC.setPosition(opC.getWidth(), ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - opC.getHeight() * 2);
        optD = new Label(perg.getAltd(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        optD.setPosition(opD.getWidth(), ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - opD.getHeight() * 3);

        if(perg.eRespostaCorreta(resppergunta)){
            switch (resppergunta){
                case 0: opA.setColor(0,0,1,1); break;
                case 1: opB.setColor(0,0,1,1);break;
                case 2: opC.setColor(0,0,1,1); break;
                case 3: opD.setColor(0,0,1,1); break;
            }
        }else{
            switch (resppergunta){
                case 0: opA.setColor(1,0,0,1); break;
                case 1: opB.setColor(1,0,0,1);break;
                case 2: opC.setColor(1,0,0,1); break;
                case 3: opD.setColor(1,0,0,1); break;
            }
        }

        Button giraRoleta = new TextButton("Gira a Roleta", skin, "small");
        giraRoleta.setSize((Gdx.graphics.getWidth() / 8), (Gdx.graphics.getHeight()) / 5);
        giraRoleta.setPosition((Gdx.graphics.getWidth() / 2) - giraRoleta.getWidth() / 2, ((Gdx.graphics.getHeight() / 2)) - Gdx.graphics.getHeight() / 2);
        giraRoleta.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                girando = true;
                roleta.giraRoleta(15, 1);
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });



        stage.addActor(giraRoleta);
        stage.addActor(opA);
        stage.addActor(opB);
        stage.addActor(opC);
        stage.addActor(opD);
        stage.addActor(pergunta);
        stage.addActor(optA);
        stage.addActor(optB);
        stage.addActor(optC);
        stage.addActor(optD);

    }


    public void disposeSelecaoPersonagem() {
        stage.clear();
    }
}