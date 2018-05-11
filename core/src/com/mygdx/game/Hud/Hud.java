package com.mygdx.game.Hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.BancoDeDados.Pergunta;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;

/**
 * Created by Andre Luiz on 09/05/2018.
 */

public class Hud implements Disposable {

    public Stage stage;
    private Viewport viewport;
    private Label letraA, letraB, letraC,letraD, pergunta;
    public Image logo, backgroundMenu, silvioSantos, jogarOption, instrucaoOption, creditosOption;
    public Image backgroundSelecao, suporte, suporte2, modoGiraRoletaOption, modoDescubraPalavraOption, seta;
    private Table table;



    public Hud(SpriteBatch sb){

        viewport = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());

        stage = new Stage(viewport, sb);

         pergunta= new Label(String.format(" "),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
         letraA= new Label(String.format(" "),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        letraB= new Label(String.format(" "),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        letraC= new Label(String.format(" "),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        letraD= new Label(String.format(" "),new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        logo = new Image(new Texture(Gdx.files.absolute("Sem título.png")));
        backgroundMenu = new Image(new Texture(Gdx.files.absolute("BackGroundMenu.png")));
        silvioSantos = new Image(new Texture(Gdx.files.absolute("SilvioSantos.png")));
        jogarOption = new Image(new Texture(Gdx.files.absolute("jogarOpcao.png")));
        instrucaoOption = new Image(new Texture(Gdx.files.absolute("InstrucoesOpcao.png")));
        creditosOption = new Image(new Texture(Gdx.files.absolute("CreditosOpcao.png")));

        backgroundSelecao = new Image(new Texture(Gdx.files.absolute("BackGroundSelecaoModoPersonagem.png")));
        modoGiraRoletaOption = new Image(new Texture(Gdx.files.absolute("GiraARoletaOpcao.png")));
        modoDescubraPalavraOption = new Image(new Texture(Gdx.files.absolute("DescubraAPalavraOpcao.png")));
        suporte = new Image(new Texture(Gdx.files.absolute("suporte.png")));
        suporte2 = new Image(new Texture(Gdx.files.absolute("suporte2.png")));

        seta = new Image(new Texture(Gdx.files.absolute("setinea.png")));




        table = new Table();

        table.top();
        table.setFillParent(true);

        stage.addActor(table);

    }


    public void opcoesMenu(){


        backgroundMenu.setSize(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT);
        logo.setSize(150,130);
        logo.setPosition((float)1.19*MyGdxGame.PPM, (float)0.90*MyGdxGame.PPM);
        silvioSantos.setSize(150,100);
        silvioSantos.setPosition((float)1.19*MyGdxGame.PPM, (float)0.0*MyGdxGame.PPM );
        jogarOption.setSize(100,50);
        jogarOption.setPosition((float)0.3*MyGdxGame.PPM, (float)1*MyGdxGame.PPM );
        instrucaoOption.setSize(100,50);
        instrucaoOption.setPosition((float)0.3*MyGdxGame.PPM, (float)0.0*MyGdxGame.PPM );
        creditosOption.setSize(100,50);
        creditosOption.setPosition((float)2.7*MyGdxGame.PPM, (float)0.50*MyGdxGame.PPM );



        table.add(backgroundMenu);
        table.add(logo);
        table.add(silvioSantos);
        table.add(jogarOption);
        table.add(instrucaoOption);
        table.add(creditosOption);

    }

    public void opcoesSelecaoPersonagemModo(){


        backgroundSelecao.setSize(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT);
        suporte.setSize(100,50);
        suporte.setPosition((float)1.5*MyGdxGame.PPM, (float)1.5*MyGdxGame.PPM);
        modoGiraRoletaOption.setSize(100,50);
        modoGiraRoletaOption.setPosition((float)0.3*MyGdxGame.PPM, (float)1*MyGdxGame.PPM );
        modoDescubraPalavraOption.setSize(100,50);
        modoDescubraPalavraOption.setPosition((float)2.7*MyGdxGame.PPM, (float)1*MyGdxGame.PPM );
        suporte2.setSize(100,50);
        suporte2.setPosition((float)0.3*MyGdxGame.PPM, (float)0.3*MyGdxGame.PPM);


        table.add(backgroundSelecao);
        table.add(suporte);
        table.add(modoGiraRoletaOption);
        table.add(modoDescubraPalavraOption);
        table.add(suporte2);

    }




    public void modoGiraRoleta(Pergunta pergunta){

        this.pergunta.setText(pergunta.getPergunta());
        this.letraA.setText("a)"+pergunta.getLetraA());
        this.letraB.setText("b)"+pergunta.getLetraB());
        this.letraC.setText("c)"+pergunta.getLetraC());
        this.letraD.setText("d)"+pergunta.getLetraD());

        table.clear();
        table.add(this.pergunta).top().expandX();
        table.row();
        table.add(this.letraA).left();
        table.row();
        table.add(this.letraB).left();
        table.row();
        table.add(this.letraC).left();
        table.row();
        table.add(this.letraD).left();

    }







    @Override
    public void dispose() {

    }
}
