package com.mygdx.game.Auxiliares;

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
    public World world;
    private Animation personagem, paradoCostas, paradoLado;
    private int S=64;

    public Personagem(ModoGiraRoleta screen) {

        super(screen.getAtlas().findRegion("personagensEngSoft"));

        Array<TextureRegion> frames = new Array<TextureRegion>();

        for (int i = 0; i < 9; i++) {
            frames.add(new TextureRegion(getTexture(), S * i, S*10, S, S));

        }
        personagem = new Animation(0.1f, frames);
        frames.clear();

        this.world = world;
    }
}
