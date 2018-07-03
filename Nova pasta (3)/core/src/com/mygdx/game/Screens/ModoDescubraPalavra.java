package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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
import com.mygdx.game.Auxiliares.Palavra;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;
import java.util.Random;

public class ModoDescubraPalavra implements Screen{

    MyGdxGame game;
    Viewport viewport;
    OrthographicCamera gameCam;

    private Skin skin;
    private Stage stage;
    private Texture background;
    private World world;
    private Box2DDebugRenderer b2dr;

    private boolean perdeu = false;
    private boolean menu = false;
    private String palavra;
    private Label perdeuTudo;
    private Button voltarMenu;
    private int palavrasDescobertas;
    private int pontuacao = 3;
    private Label dica;
    private Label texto;
    private Label pontos;
    private String textoSemEspaco = "";
    private Palavra resposta;



    public ModoDescubraPalavra(MyGdxGame game){

        //Coisas essenciais de um level
        this.game = game;
        world = new World(new Vector2(0, 0), true);
        b2dr = new Box2DDebugRenderer();
        gameCam = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),gameCam);
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        stage = new Stage();

        pontuacao = 0;
        mudaNivel();
    }

    public void criaBotao(final String letra, int posicao){

        final Button opA = new TextButton(letra,skin);
        opA.setSize(Gdx.graphics.getWidth()/10.5f,Gdx.graphics.getHeight()/10.5f);
        int margem = 45;
        float tamanho = opA.getWidth();
        if(posicao>=8){
            opA.setPosition(margem*(posicao-7)+tamanho*(posicao-8),Gdx.graphics.getWidth()/13);
        }
        else{
            opA.setPosition(margem*(posicao+1)+tamanho*(posicao),Gdx.graphics.getWidth()/7);
        }
        opA.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(palavra.contains(letra)){
                    adicionaLetra(letra);
                }
                else{
                    pontuacao--;
                }
                desabilitaBotao(opA);
                return super.touchDown(event, x, y, pointer, button);
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });
        stage.addActor(opA);
    }

    public void desabilitaBotao (Button botao){
        botao.setDisabled(true);
    }

    public void criaLetras(){
        Random random = new Random();
        char[] word;
        word = palavra.toCharArray();
        String alfabeto = "abcdefghijklmnopkrstuvwxyz";
        int aleatorios = 16-palavra.length();
        for(int i = 0, j = 0; i<16;i++){
            int al = random.nextInt(2);
            if((aleatorios !=0 && al == 0)|| j == palavra.length()){
                al= random.nextInt(alfabeto.length());
                String caracter = ""+ alfabeto.charAt(al);
                criaBotao(caracter,i);
                aleatorios--;
            }
            else{
                String caracter = ""+word[j];
                criaBotao(caracter,i);
                j++;
            }
        }
    }

    public void mudarTexto(String letra){
        letra = letra.replaceAll ("(.)", "$1 ");
        int tamanho = letra.length();
        String tracos = "";
        for(int i = letra.length()/2; i<resposta.getTamanho();i++){
            tracos = tracos + " _";
        }
        letra = letra +tracos;
        texto.setText(letra);
    }

    public void adicionaLetra(String letra){
        pontuacao++;
        letra = textoSemEspaco + letra;
        textoSemEspaco = letra;
        mudarTexto(letra);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    public void update(float delta){

        if(pontuacao ==0){
            perdeu = true;
        }
        if(resposta.palavraCorreta(textoSemEspaco)){
            palavrasDescobertas++;
            mudaNivel();
        }
    }

    public void mudaNivel(){

        geraPalavra();
        palavra = resposta.getPalavra();
        criaLetras();
        dica = new Label("dica: " +resposta.getDica(),skin,"big");
        dica.setPosition(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        stage.addActor(dica);

        texto = new Label("",skin,"big");
        mudarTexto("");
        texto.setFontScale(2);
        texto.setPosition(Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/3 ,Gdx.graphics.getHeight()-(dica.getHeight()*6));
        stage.addActor(texto);

    }

    public void geraPalavra(){
        ArrayList<Palavra> palavras;
        palavras= new ArrayList<Palavra>();
        palavras.add(new Palavra ("staruml","ferramenta case de uml"));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));
        palavras.add(new Palavra ("",""));

        Random random= new Random();
        int al= random.nextInt(palavras.size());
        resposta = palavras.get(al);
    }

    @Override
    public void render(float delta) {
        update(delta);

        if(!perdeu){

            Gdx.gl.glClearColor(0, 0, 1, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            game.batch.begin();
            game.batch.end();
            b2dr.render(world, gameCam.combined);

            stage.act();
            stage.draw();
        }else{

            Gdx.gl.glClearColor(0, 0, 1, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            stage.clear();
            stage.addActor(perdeuTudo);
            stage.addActor(voltarMenu);
            stage.act();
            stage.draw();

        }
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
        skin.dispose();
        stage.dispose();
    }
}

