package com.mygdx.game.Auxiliares;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Screens.PlayScreen;

/**
 * Created by Andre Luiz on 11/06/2018.
 */

public class Roleta extends Sprite {



    public World world;
    public Body b2body;
    public BodyDef bdef;


    public Roleta(World world){


        this.world = world;

        defineRoleta();

    }

    public void defineRoleta() {

        bdef = new BodyDef();
        bdef.position.set(0,0);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(0.3f);


        fdef.shape = shape;

        b2body.createFixture(fdef);


    }

    public void giraRoleta(int angularVelocity){

        b2body.setAngularVelocity(angularVelocity);

    }



}
