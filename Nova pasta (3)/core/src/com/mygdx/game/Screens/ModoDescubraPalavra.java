package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Auxiliares.MostradorPerguntas;
import com.mygdx.game.Auxiliares.Roleta;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Andre Luiz on 01/07/2018.
 */

public class ModoDescubraPalavra implements Screen {


    MyGdxGame game;
    Viewport viewport;
    OrthographicCamera gameCam;

    private Skin skin;
    private Stage stage;
    private Texture background;
    private World world;
    private Box2DDebugRenderer b2dr;

    private Label perdeuTudo;
    private Button voltarMenu;

    private Roleta roleta;
    private MostradorPerguntas mostradorPerguntas;

    private boolean perdeu;
    private boolean menu;

    private int pontuacao;


    public ModoDescubraPalavra(MyGdxGame game){


        //Coisas essenciais de um level
        this.game = game;
        world = new World(new Vector2(0, 0), true);
        b2dr = new Box2DDebugRenderer();
        gameCam = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),gameCam);
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        stage = new Stage();


        //Coisas específicas do ModoGiraRoleta

        mostradorPerguntas = new MostradorPerguntas(world, stage);
        perdeu = false;


        Button giraRoleta = new TextButton("Gira a Roleta", skin, "small");
        giraRoleta.setSize((Gdx.graphics.getWidth() / 5), (Gdx.graphics.getHeight() / 10));
        giraRoleta.setPosition((Gdx.graphics.getWidth())/2 - giraRoleta.getWidth()/2, ((Gdx.graphics.getHeight() / 2) - (Gdx.graphics.getHeight() / 4)));
        giraRoleta.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                roleta.giraRoleta(5,1);
                mostradorPerguntas.trocando=true;
                mostradorPerguntas.voltaPerguntasAoNormal();
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        voltarMenu = new TextButton("Voltar ao menu principal", skin, "small");
        voltarMenu.setPosition((Gdx.graphics.getWidth())/2 - giraRoleta.getWidth()/2, ((Gdx.graphics.getHeight() / 2) - (Gdx.graphics.getHeight() / 4)));
        voltarMenu.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                menu=true;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

      //  mostradorPerguntas.criaBotao();

        perdeuTudo = new Label("PERDEU!", new Label.LabelStyle(new BitmapFont(), Color.WHITE));


        stage.addActor(giraRoleta);

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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

    public void criaTecla(char letra){

    }
}
