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
import com.mygdx.game.MyGdxGame;

/**
 * Created by Andre Luiz on 09/05/2018.
 */

public class Hud implements Disposable {

    public Stage stage;
    private Viewport viewport;
    private Label teste;
    public Image logo, background, silvioSantos, jogarOption, instrucaoOption, creditosOption;
    private Table table;


    public Hud(SpriteBatch sb){

        viewport = new FitViewport(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT, new OrthographicCamera());

        stage = new Stage(viewport, sb);

        teste = new Label(String.format("TESTEEEEE"),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        logo = new Image(new Texture(Gdx.files.absolute("Sem título.png")));
        background = new Image(new Texture(Gdx.files.absolute("BackGroundMenu.png")));
        silvioSantos = new Image(new Texture(Gdx.files.absolute("SilvioSantos.png")));
        jogarOption = new Image(new Texture(Gdx.files.absolute("jogarOpcao.png")));
        instrucaoOption = new Image(new Texture(Gdx.files.absolute("InstrucoesOpcao.png")));
        creditosOption = new Image(new Texture(Gdx.files.absolute("CreditosOpcao.png")));






        table = new Table();

        table.top();
        table.setFillParent(true);

        stage.addActor(table);

    }


    public void opcoesMenu(){


        background.setSize(MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT);
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



        table.add(background);
        table.add(logo);
        table.add(silvioSantos);
        table.add(jogarOption);
        table.add(instrucaoOption);
        table.add(creditosOption);

    }



    @Override
    public void dispose() {

    }
}
