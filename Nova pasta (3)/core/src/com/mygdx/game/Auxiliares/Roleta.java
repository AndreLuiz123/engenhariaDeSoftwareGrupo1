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
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ObjectMap;

/**
 * Created by Andre Luiz on 11/06/2018.
 */

public class Roleta extends Sprite {

    public static final float ppratio = 100f;
    private float x = 0, y = 0;             // position
    private float diametro = 1000f;         // diameter of wheel
    private int nPinos = 5;        // numero de pinos
    private boolean girou = false;      // so pode girar uma vez

    private static final float STANDARD_SIZE = 512F;
    private static final short BIT_PEG = 4;
    private static final short BIT_NEEDLE = 8;
    private static final short BIT_B1 = 16;
    private static final short BIT_B2 = 32;

    public World world;
    public Body centroRoleta;
    private BodyDef bdef;

    private FixtureDef fdef;                       // general fixture definition.
    private Body needle;        // polygon shape.
    private Body B0, B1, B2;    // three bodies to constrain and keep the needle in the place.


    public Roleta(World world){


        this.world = world;

        defineRoleta();

    }

    public void defineRoleta() {

        bdef = new BodyDef();
        //bdef.position.set(0,0);
        //bdef.type = BodyDef.BodyType.DynamicBody;
        //b2body = world.createBody(bdef);

        fdef = new FixtureDef();

        //FixtureDef fdef = new FixtureDef();
        //CircleShape shape = new CircleShape();
        //shape.setRadius(0.3f);


        //fdef.shape = shape;

        //b2body.createFixture(fdef);


        base_roleta();
        centro_roleta();
        pinos_roleta();

    }

    private void base_roleta() {
        PolygonShape polygon = new PolygonShape();
        // Define The Base Of Wheel
        bdef.type = BodyType.StaticBody;

        // set The Base Position
        bdef.position.set(x, y);

        // Create The Base Body
        centroRoleta = world.createBody(bdef);

        // set The Shape of Base
        polygon.setAsBox(32 / ppratio, 32 / ppratio);
        fdef.shape = polygon;

        // Create The Base Fixture
        centroRoleta.createFixture(fdef);

        // Dispose The Shape
        polygon.dispose();
    }

    private void centro_roleta() {
        CircleShape circle = new CircleShape();
        // Define The Base Of Wheel
        bdef.type = BodyType.DynamicBody;

        // To Stop after spinning
        bdef.angularDamping = 0.25f;
        bdef.position.set(x, y);

        // Create The Core Body
        centroRoleta = world.createBody(bdef);

        // set The Shape of Base
        circle.setRadius(diametro / 2);
        fdef.shape = circle;

        // set The physics properties of The Shape
        fdef.density = 0.25f;
        fdef.friction = 0.25f;

        // Create The Base Fixture
        centroRoleta.createFixture(fdef);

        // Dispose The Shape
        circle.dispose();
    }

    private void pinos_roleta() {
        if (nPinos == 0)
            return;

        CircleShape circle = new CircleShape();
        // Define The Pegs Of Wheel
        bdef.type = BodyType.DynamicBody;
        bdef.position.set(x, y);

        // set The physics properties of The Shape
        fdef.density = 0.0f;
        fdef.friction = 0.0f;

        // set categoryBits To allow collide with (needle)
        fdef.filter.categoryBits = BIT_PEG;
        fdef.filter.maskBits = BIT_NEEDLE;

        for (int i = 0; i < nPinos; i++) {
            double theta = Math.toRadians((360 / nPinos) * i);
            float x = (float) Math.cos(theta);
            float y = (float) Math.sin(theta);

            // set The Peg Position
            circle.setPosition(circle.getPosition().set(x * diametro / 2, y * diametro / 2).scl(0.90f));

            // set The Shape of Pegs
            circle.setRadius(12 * (diametro / STANDARD_SIZE) / 2);
            fdef.shape = circle;

            // Create The Base Fixture
            Fixture fixture = centroRoleta.createFixture(fdef);

            // set user data as a number of peg to indecator to lucky win element.
            fixture.setUserData((i + 1));
        }

        // the shape is no longer used.
        circle.dispose();
    }

    public void giraRoleta(int angularVelocity, int angularDamping){

        centroRoleta.setAngularVelocity(MathUtils.clamp(angularVelocity, 0, 30));
        centroRoleta.setAngularDamping(angularDamping);
        girou = true;

    }



}