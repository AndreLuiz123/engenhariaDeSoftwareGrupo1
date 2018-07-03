package com.mygdx.game.Auxiliares;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Screens.ModoGiraRoleta;
import com.mygdx.game.Screens.PlayScreen;

/**
 * Created by Andre Luiz on 11/06/2018.
 */

public class Roleta extends Sprite {



    public World world;
    public Body b2body;
    public BodyDef bdef;

    public Texture texturaDaRoleta;
    private Animation personagem, paradoCostas, paradoLado;
    private int S;

    public Roleta(World world, ModoGiraRoleta screen) {

        super(screen.getAtlas().findRegion("personagensEngSoft"));

        S=64;
        this.world = world;

        defineRoleta();

  /*      texturaDaRoleta = new Texture("jogarOpcao.png");



        Array<TextureRegion> frames = new Array<TextureRegion>();

        for (int i = 0; i < 9; i++) {
            frames.add(new TextureRegion(getTexture(), S * i, S*10, S, S));

        }
        personagem = new Animation(0.1f, frames);
        frames.clear();
*/
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

    public void giraRoleta(int angularVelocity, int angularDamping){

        b2body.setAngularVelocity(angularVelocity);
        b2body.setAngularDamping(angularDamping);

    }

    public float getAngularPosition(){

        return b2body.getAngle();
    }


}