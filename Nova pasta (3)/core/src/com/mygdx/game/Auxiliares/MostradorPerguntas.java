package com.mygdx.game.Auxiliares;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import org.w3c.dom.Text;
import org.w3c.dom.css.Rect;

import java.util.Random;

import javax.management.relation.Role;

/**
 * Created by Andre Luiz on 26/06/2018.
 */

public class MostradorPerguntas extends Sprite {


    public World world;
    public Texture textura;
    public Skin skin;
    public Stage stage;

    public Pergunta perg;
    public GerenciadorPerguntas gerenciadorPerguntas;
    public int resposta;

    public Label pergunta;
    public Button opA;
    public Button opB;
    public Button opC;
    public Button opD;
    public Button optSelecionadaBtn;
    public Button ajudaAmigo, pulaPergunta;
    public Label optA;
    public Label optB;
    public Label optC;
    public Label optD;
    public Label optSelecionada;
    public Label pontuacao;

    public String alternativa;
    public int pontuacaoObtida;
    public boolean respostaCerta;
    public int cat;

    public int aux50;
    public int auxpula;
    public int blockq1;
    public int blockq2;
    public int aux50perg;


    public boolean podeGirarRoleta;
    public boolean trocando;
    public TextureAtlas atlas;

    //teste

    public MostradorPerguntas(World world, Stage stage) {
        this.world = world;

        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        this.stage = stage;

        textura = new Texture("jogarOpcao.png");
        atlas = new TextureAtlas("personagensES.atlas");

        alternativa = "";
        respostaCerta = false;
        this.aux50 = 0;
        this.aux50perg = 0;
        this.blockq1 = -1;
        this.blockq2 = -1;
        this.auxpula = 0;

        gerenciadorPerguntas = new GerenciadorPerguntas();

        cat = 0;
        perg = gerenciadorPerguntas.geraPergunta(cat);
        while(perg.isFeita() && gerenciadorPerguntas.restaPergunta(cat)){
            perg = gerenciadorPerguntas.geraPergunta(cat);
        }

        if(perg == null || perg.isFeita()){
            perg = gerenciadorPerguntas.getPerguntaNeutra();
        }

        perg.marcarFeita();

        resposta = 10;
        pontuacaoObtida = 0;

        trocando = false;

        pergunta = new Label(perg.getTexto(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

            optA = new Label(perg.getAlta(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        optB = new Label(perg.getAltb(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        optC = new Label(perg.getAltc(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        optD = new Label(perg.getAltd(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));


        optSelecionada = new Label("Opção:" + alternativa, new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        pontuacao = new Label("Pontuação:" + pontuacaoObtida, new Label.LabelStyle(new BitmapFont(), Color.WHITE));


        opA = new TextButton("A", skin, "small");
        opB = new TextButton("B", skin, "small");
        opC = new TextButton("C", skin, "small");
        opD = new TextButton("D", skin, "small");
        optSelecionadaBtn = new TextButton("Confirmar Resposta", skin, "small");
        pulaPergunta = new TextButton("Pula pergunta", skin, "small");
        ajudaAmigo = new TextButton("50/50", skin, "small");
    }

    public void controlaPerguntas(Roleta roleta) {

        if (trocando) {
            if (roleta.b2body.getAngularVelocity() == 0) {
                podeGirarRoleta = false;
                if (roleta.getAngularPosition() > 0 && roleta.getAngularPosition() <= 90) {
                    perg = gerenciadorPerguntas.geraPergunta(cat);
                    while(perg.isFeita() && gerenciadorPerguntas.restaPergunta(cat)){
                        perg = gerenciadorPerguntas.geraPergunta(cat);
                    }

                    if(perg == null || perg.isFeita()){
                        perg = gerenciadorPerguntas.getPerguntaNeutra();
                    }
                    perg.marcarFeita();

                    mudaPergunta(perg.getTexto(), perg.getAlta(), perg.getAltb(), perg.getAltc(), perg.getAltd());

                } else {

                    if (roleta.getAngularPosition() > 90 && roleta.getAngularPosition() <= 180) {
                        perg = gerenciadorPerguntas.geraPergunta1();
                        mudaPergunta(perg.getTexto(), perg.getAlta(), perg.getAltb(), perg.getAltc(), perg.getAltd());
                    } else {
                        if (roleta.getAngularPosition() > 180 && roleta.getAngularPosition() <= 270) {
                            perg = gerenciadorPerguntas.geraPergunta2();
                            mudaPergunta(perg.getTexto(), perg.getAlta(), perg.getAltb(), perg.getAltc(), perg.getAltd());
                        } else {
                            if (roleta.getAngularPosition() > 270 && roleta.getAngularPosition() <= 360) {
                                perg = gerenciadorPerguntas.geraPergunta3();
                                mudaPergunta(perg.getTexto(), perg.getAlta(), perg.getAltb(), perg.getAltc(), perg.getAltd());

                            }
                        }
                    }
                }
                trocando = false;
            } else {
                perg = gerenciadorPerguntas.getPerguntaNeutra();
                mudaPergunta(perg.getTexto(), perg.getAlta(), perg.getAltb(), perg.getAltc(), perg.getAltd());
                alternativa="";
            }

        }

    }


    public void mudaPergunta(String pergunta, String A, String B, String C, String D) {
        this.pergunta.setText(pergunta);
        aux50perg = 0;
        optA.setText(A);
        optB.setText(B);
        optC.setText(C);
        optD.setText(D);

    }

    public void mudaAltEscolhida() {

        optSelecionada.setText("Opção:" + alternativa);

    }

    public void mudaPontuacao() {

        pontuacao.setText("Pontuação:" + pontuacaoObtida);

    }


    public void criaBotao(final Roleta roleta) {


        pergunta.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 3)));


        optA.setPosition(opA.getX() + opA.getWidth(), ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) + ((Gdx.graphics.getHeight() / 22)));
        opA.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opA.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)));
        opA.addListener(new InputListener() {


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (roleta.b2body.getAngularVelocity() == 0 && blockq1 != 0 && blockq2 != 0) {
                    resposta = 0;
                    alternativa = "A";
                }

                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });


        optB.setPosition(opB.getX() + opB.getWidth(), ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - Gdx.graphics.getHeight() / 20);
        opB.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opB.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - opB.getHeight());
        opB.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (roleta.b2body.getAngularVelocity() == 0 && blockq1 != 1 && blockq2 != 1) {
                    resposta = 1;
                    alternativa = "B";
                }
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });


        optC.setPosition(opC.getX() + opC.getWidth(), ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - 2.5f * opD.getHeight());
        opC.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opC.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - 2 * opC.getHeight());
        opC.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (roleta.b2body.getAngularVelocity() == 0 && blockq1 != 2 && blockq2 != 2) {
                    resposta = 2;
                    alternativa = "C";
                }
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });


        optD.setPosition(opD.getX() + opD.getWidth(), ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - Gdx.graphics.getHeight() / 4);
        opD.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opD.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - 3 * opD.getHeight());
        opD.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (roleta.b2body.getAngularVelocity() == 0 && blockq1 != 3 && blockq2 != 3) {
                    resposta = 3;
                    alternativa = "D";
                }
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        optSelecionada.setPosition(opD.getX(), opD.getY() - 2 * opD.getHeight());
        optSelecionada.setFontScaleX(3);
        optSelecionada.setFontScaleY(3);
        optSelecionadaBtn.setPosition(opD.getX() + opD.getWidth() / 2, optD.getY() - 4 * opD.getHeight());
        optSelecionadaBtn.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (alternativa != "") {
                    podeGirarRoleta = true;
                    respostaCerta = true;
                }
                blockq2 = -1;
                blockq1 = -1;

                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        pulaPergunta.setPosition(Gdx.graphics.getWidth() - 2 * pontuacao.getWidth(), ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - opB.getHeight() / 2);
        pulaPergunta.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        pulaPergunta.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (auxpula < 2) {
                    perg = gerenciadorPerguntas.pulaPergunta(cat);
                    mudaPergunta(perg.getTexto(), perg.getAlta(), perg.getAltb(), perg.getAltc(), perg.getAltd());
                    //pontuacaoObtida--;
                }
                auxpula++;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        ajudaAmigo.setPosition(Gdx.graphics.getWidth() - 2 * pontuacao.getWidth(), ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - 3 * opC.getHeight() / 2);
        ajudaAmigo.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        ajudaAmigo.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (aux50 <= 3 && aux50perg ==0) {
                    coloreRespostaErrada();
                }
                aux50++;
                aux50perg = 1;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });


        pontuacao.setPosition(Gdx.graphics.getWidth() - 4 * pontuacao.getWidth(), Gdx.graphics.getHeight() - 2 * pontuacao.getHeight());

        pontuacao.setFontScaleX(3);
        pontuacao.setFontScaleY(3);


        stage.addActor(pergunta);
        stage.addActor(opA);
        stage.addActor(optA);
        stage.addActor(opB);
        stage.addActor(optB);
        stage.addActor(opC);
        stage.addActor(optC);
        stage.addActor(opD);
        stage.addActor(optD);
        stage.addActor(optSelecionada);
        stage.addActor(optSelecionadaBtn);
        stage.addActor(pontuacao);
        stage.addActor(ajudaAmigo);
        stage.addActor(pulaPergunta);
    }

    public void acertouOuErrouResposta() {

        if (respostaCerta) {

            if (perg.eRespostaCorreta(resposta)) {
                acertouResposta(resposta);
                pontuacaoObtida++;

            } else {

                acertouResposta(perg.getAltcorreta());
                errouResposta(resposta);
                pontuacaoObtida--;

            }

            respostaCerta = false;

        }
    }



    public void acertouResposta(int respostaC){
        switch (respostaC) {
            case 0:
                optA.setStyle(new Label.LabelStyle(new BitmapFont(), Color.GREEN));
                break;
            case 1:
                optB.setStyle(new Label.LabelStyle(new BitmapFont(), Color.GREEN));
                break;
            case 2:
                optC.setStyle(new Label.LabelStyle(new BitmapFont(), Color.GREEN));
                break;
            case 3:
                optD.setStyle(new Label.LabelStyle(new BitmapFont(), Color.GREEN));
                break;
        }
    }

    public void coloreRespostaErrada(){

        int respostaC;
        int respD;

        respostaC = gerenciadorPerguntas.retornaRespostaErrada(perg.getAltcorreta());
        respD = gerenciadorPerguntas.retornaRespostaErrada(perg.getAltcorreta());
        while(respostaC == respD){
            respD = gerenciadorPerguntas.retornaRespostaErrada(perg.getAltcorreta());
        }

        switch (respostaC) {
            case 0:
                optA.setStyle(new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
                blockq1 = 0;
                break;
            case 1:
                optB.setStyle(new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
                blockq1 = 1;
                break;
            case 2:
                optC.setStyle(new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
                blockq1 = 2;
                break;
            case 3:
                optD.setStyle(new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
                blockq1 = 3;
                break;
        }

        switch (respD) {
            case 0:
                optA.setStyle(new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
                blockq2 = 0;
                break;
            case 1:
                optB.setStyle(new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
                blockq2 = 1;
                break;
            case 2:
                optC.setStyle(new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
                blockq2 = 2;
                break;
            case 3:
                optD.setStyle(new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
                blockq2 = 3;
                break;
        }
    }

    public void errouResposta(int respostaE){
        switch (respostaE) {
            case 0:
                optA.setStyle(new Label.LabelStyle(new BitmapFont(), Color.RED));
                break;
            case 1:
                optB.setStyle(new Label.LabelStyle(new BitmapFont(), Color.RED));
                break;
            case 2:
                optC.setStyle(new Label.LabelStyle(new BitmapFont(), Color.RED));
                break;
            case 3:
                optD.setStyle(new Label.LabelStyle(new BitmapFont(), Color.RED));
                break;
        }
    }

    public void voltaPerguntasAoNormal(){
        for(int alternativa=0; alternativa<4 ; alternativa++){
            switch (alternativa) {
                case 0:
                    optA.setStyle(new Label.LabelStyle(new BitmapFont(), Color.WHITE));
                    break;
                case 1:
                    optB.setStyle(new Label.LabelStyle(new BitmapFont(), Color.WHITE));
                    break;
                case 2:
                    optC.setStyle(new Label.LabelStyle(new BitmapFont(), Color.WHITE));
                    break;
                case 3:
                    optD.setStyle(new Label.LabelStyle(new BitmapFont(), Color.WHITE));
                    break;
            }
        }

    }

    public int getPontuacao(){
        return this.pontuacaoObtida;
    }


}
