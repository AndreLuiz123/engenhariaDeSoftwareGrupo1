package com.mygdx.game.Auxiliares;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Screens.ModoGiraRoleta;
import com.mygdx.game.Screens.PlayScreen;

/**
 * Created by Andre Luiz on 02/07/2018.
 */

public class Personagem extends Sprite {

    //private Animation personagem, paradoCostas, paradoLado;
    private int S=100;
    private float stateTimer=0;
    private TextureRegion personagem;

    public Personagem(ModoGiraRoleta screen) {

        super(screen.getAtlas().findRegion("personagensEngSoft"));

        personagem = new TextureRegion(getTexture(), 0, 0, S-30, S);

    }

    public void update(float dt){
        setRegion(personagem);
        setBounds(Gdx.graphics.getWidth() - personagem.getRegionWidth()*3,0,150,150);

        //setRotation(40);

    }
}
