package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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
import com.mygdx.game.Auxiliares.Personagem;
import com.mygdx.game.Auxiliares.Roleta;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Andre Luiz on 26/06/2018.
 */

public class ModoGiraRoleta implements Screen {


    MyGdxGame game;
    Viewport viewport;
    OrthographicCamera gameCam;

    private Skin skin;
    private Stage stage;
    private Texture background;
    private TextureAtlas atlas;

    private World world;
    private Box2DDebugRenderer b2dr;

    private Label perdeuTudo;
    private Button voltarMenu;

    private Roleta roleta;
    private MostradorPerguntas mostradorPerguntas;

    private boolean perdeu;
    private boolean ganhou;
    private boolean menu;
    private boolean podeGirarRoleta;

    private int pontuacao;

    private Personagem personagem;

    public ModoGiraRoleta(MyGdxGame game){


        //Coisas essenciais de um level
        this.game = game;
        world = new World(new Vector2(0, 0), true);
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),gameCam);
        stage = new Stage();
        b2dr = new Box2DDebugRenderer();
       gameCam = new OrthographicCamera();
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));


        atlas = new TextureAtlas("personagensES.atlas");
        personagem = new Personagem(this);

        //Coisas específicas do ModoGiraRoleta
        roleta = new Roleta(world,this);
        mostradorPerguntas = new MostradorPerguntas(world, stage);
        perdeu = false;


        Button giraRoleta = new TextButton("Gira a Roleta", skin, "small");
        giraRoleta.setSize((Gdx.graphics.getWidth() / 5), (Gdx.graphics.getHeight() / 10));
        giraRoleta.setPosition((Gdx.graphics.getWidth())/2 - giraRoleta.getWidth()/2, ((Gdx.graphics.getHeight() / 2) - (Gdx.graphics.getHeight() / 4)));
        giraRoleta.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(mostradorPerguntas.podeGirarRoleta){
                    roleta.giraRoleta(5,1);
                    mostradorPerguntas.trocando=true;
                    mostradorPerguntas.voltaPerguntasAoNormal();
                }

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

        mostradorPerguntas.criaBotao(roleta);

        perdeuTudo = new Label("PERDEU!", new Label.LabelStyle(new BitmapFont(), Color.WHITE));


        stage.addActor(giraRoleta);

    }


    public TextureAtlas getAtlas(){
        return  atlas;
    }

    @Override
    public void show() {Gdx.input.setInputProcessor(stage);}


    public void update(float delta){

    //Permite que a roleta gire
        world.step(1f / 60f, 6, 2);

    //Troca perguntas
      mostradorPerguntas.controlaPerguntas(roleta);
      mostradorPerguntas.mudaAltEscolhida();
      mostradorPerguntas.mudaPontuacao();
      mostradorPerguntas.acertouOuErrouResposta();

    //Acaba jogo
        if(mostradorPerguntas.getPontuacao()<0){
            perdeu = true;
        }else{
            if(mostradorPerguntas.pontuacaoObtida>=15){
                ganhou = true;
            }
        }
        perdeuTudo.setPosition(Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/2);

        perdeuTudo.setFontScaleX(5);
        perdeuTudo.setFontScaleY(5);

        if(menu) {
            game.setScreen(new MenuScreen(game));
            atlas.dispose();
            dispose();
            menu=false;
        }

        System.out.println(mostradorPerguntas.alternativa);

    personagem.update(delta);
    roleta.update();
   // personagem.rotate(roleta.b2body.getAngularVelocity() );
        roleta.rotate(roleta.b2body.getAngularVelocity());
       // roleta.rotate(roleta.b2body.getAngularVelocity());

    }

    @Override
    public void render(float delta) {
        update(delta);

        if(!perdeu && !ganhou){

            Gdx.gl.glClearColor(0, 0, 1, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            game.batch.begin();
            personagem.draw(game.batch);
            roleta.draw(game.batch);
            game.batch.end();
            b2dr.render(world, gameCam.combined);
            stage.act();
            stage.draw();
        }else{

            if(perdeu){
                Gdx.gl.glClearColor(0, 0, 1, 0);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

                stage.clear();
                stage.addActor(perdeuTudo);
                stage.addActor(voltarMenu);
                stage.act();
                stage.draw();
            }else{
                if(ganhou){
                    Gdx.gl.glClearColor(0, 0, 1, 0);
                    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

                    perdeuTudo.setText("GANHOU!!");

                    stage.clear();
                    stage.addActor(perdeuTudo);
                    stage.addActor(voltarMenu);
                    stage.act();
                    stage.draw();

                }
            }


        }






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
        stage.clear();
        b2dr.dispose();
        world.dispose();
    }

    public void disposeModoPreparado(){

    }

    /*
    *FUNÇÕES ADICIONAIS QUE TODOS OS NIVEIS POSSUIRÃO
    *criaBotao()
     */


}
