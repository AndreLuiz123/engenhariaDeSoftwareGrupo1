package com.mygdx.game.Auxiliares;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
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

import javax.management.relation.Role;

/**
 * Created by Andre Luiz on 26/06/2018.
 */

public class MostradorPerguntas extends Sprite {


    public World world;
    public Texture textura;
    public Skin skin;

    public Pergunta perg;
    public GerenciadorPerguntas gerenciadorPerguntas;
    public int resposta;


    public MostradorPerguntas(World world) {

        this.world = world;

        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        textura = new Texture("jogarOpcao.png");

        gerenciadorPerguntas = new GerenciadorPerguntas();

        perg = gerenciadorPerguntas.getPerguntaNeutra();

        resposta = 10;

    }

    public void controlaPerguntas(Roleta roleta){

        if(roleta.b2body.getAngularVelocity() == 0){
            if(roleta.getAngularPosition()>0 && roleta.getAngularPosition()<=90){
                perg = gerenciadorPerguntas.geraPergunta0();
            }else{
                if(roleta.getAngularPosition()>90 && roleta.getAngularPosition()<=180){
                    perg = gerenciadorPerguntas.geraPergunta1();
                }else{
                    if(roleta.getAngularPosition()>180 && roleta.getAngularPosition()<=270){
                        perg = gerenciadorPerguntas.geraPergunta2();
                    }else{
                        if(roleta.getAngularPosition()>270 && roleta.getAngularPosition()<=360){
                            perg = gerenciadorPerguntas.geraPergunta3();
                        }else{

                        }
                    }
                }
            }
        }else{
            perg = gerenciadorPerguntas.getPerguntaNeutra();
        }

    }

    public void criaBotao(Stage stage){

        Label pergunta = new Label(perg.getTexto(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        pergunta.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 3)));

        final Button opA = new TextButton("A", skin, "small");
        Label optA = new Label(perg.getAlta(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        optA.setPosition(opA.getX()+opA.getWidth()/2,((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) + opA.getHeight()/4);
        opA.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opA.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)));
        opA.addListener(new InputListener() {


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                resposta = 1;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        final Button opB = new TextButton("B", skin, "small");
        Label optB = new Label(perg.getAltb(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        optB.setPosition(opB.getX()+opB.getWidth()/2, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - opB.getHeight()/2);
        opB.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opB.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - opB.getHeight());
        opB.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                resposta = 2;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        final Button opC = new TextButton("C", skin, "small");
        Label optC = new Label(perg.getAltc(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        optC.setPosition(opC.getX()+opC.getWidth()/2, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - 2.5f*opC.getHeight()/2);
        opC.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opC.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - 2 * opC.getHeight());
        opC.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                resposta = 3;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        final Button opD = new TextButton("D", skin, "small");
        Label optD = new Label(perg.getAltd(), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        optD.setPosition(opD.getX()+opD.getWidth()/2, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - 4* opD.getHeight()/2);
        opD.setSize((Gdx.graphics.getWidth() / 15), (Gdx.graphics.getHeight()) / 10);
        opD.setPosition(0, ((Gdx.graphics.getHeight() / 2)) + ((Gdx.graphics.getHeight() / 5)) - 3 * opD.getHeight());
        opD.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                resposta = 4;
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        stage.addActor(pergunta);
        stage.addActor(opA);
        stage.addActor(optA);
        stage.addActor(opB);
        stage.addActor(optB);
        stage.addActor(opC);
        stage.addActor(optC);
        stage.addActor(opD);
        stage.addActor(optD);
    }




}
