package nl.han.ica.oopd.waterworld;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

/**
 * @author Ralph Niels
 * Een zwaardvis is een spelobject dat zelfstandig
 * door de wereld beweegt
 */
public class Swordfish extends SpriteObject {

    private GameEngine world;

    /**
     * Constructor
     *
     * @param world Referentie naar de wereld
     */
    public Swordfish(GameEngine world) {
        this(new Sprite("src/main/resources/swordfish.png"));
        this.world = world;
    }

    /**
     * Maak een Swordfish aan met een sprite
     *
     * @param sprite De sprite die aan dit object gekoppeld moet worden
     */
    private Swordfish(Sprite sprite) {
        super(sprite);
        setxSpeed(-1);
    }

    @Override
    public void update() {
        if (getX() + getWidth() <= 0) {
            setX(world.width);
        }

    }
}
