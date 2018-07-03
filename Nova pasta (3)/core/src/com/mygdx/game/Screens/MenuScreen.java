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

//teste
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
        sound.dispose();
    }

    public void mostrarCreditos(){

        Label texto2 = new Label("Andre Luiz Vasconcelos Ferreira\n" +
                "Jose Santos Sa Carvalho\n" +
                "Leonardo Nunes Aragao \n" +
                "Matheus Franklin Rodrigues Silva \n"
               ,skin,"big");
        texto2.setFontScale(0.45f);
        texto2.setSize(300,Gdx.graphics.getHeight()/2);
        texto2.setPosition(50,Gdx.graphics.getHeight()/2);

        Button voltar2 = new TextButton("voltar ao menu",skin,"small");
        voltar2.setSize(200,100);
        voltar2.setPosition(((Gdx.graphics.getWidth()/2)-voltar2.getWidth()/2),((Gdx.graphics.getHeight()/2)-voltar2.getHeight()-130));

        voltar2.addListener(new InputListener(){

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

        stage.addActor(texto2);
        stage.addActor(voltar2);
    }

    public void mostrarAjuda(){
        Label texto = new Label("   1. Selecione um personagem;\n" +
                "2. Selecione um Modo; \n" +
                "2.1 Gira a Roleta: Selecione as respostas corretas, e confirme usando o botao.\n" +
                "-- Voce comeca com 5 pontos\n" +
                "-- Gire a Roleta para selecionar a categoria da proxima pergunta. \n" +
                "-- Ganhe 1 ponto por resposta correta e perca 1 por resposta errada.  \n" +
                "-- Se nao souber a resposta, pode pular a pergunta (so pode pular 2 vezes). \n" +
                "-- Peca ajuda a amigos, apagando duas respostas erradas. So pode usar 3 vezes durante o jogo. \n" +
                "-- Atinja 10 pontos para ganhar; Se chegar a 0, voce perde.",skin,"big");

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
