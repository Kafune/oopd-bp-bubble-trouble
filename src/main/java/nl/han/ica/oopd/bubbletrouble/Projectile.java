package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Projectile extends SpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles {
	private BubbleTrouble bubbleTrouble;
	private ProjectileTrail trail;
	private float speedMultiplier = 1f;

	public Projectile(Sprite sprite, BubbleTrouble bubbleTrouble) {
		super(sprite);
		Sprite trailSprite = new Sprite("src/main/resources/bubble-trouble/projectiletrail.png");
		trail = new ProjectileTrail(trailSprite, this, bubbleTrouble);

		this.bubbleTrouble = bubbleTrouble;
		bubbleTrouble.addGameObject(trail);

		setHeight(15);
		setWidth(15);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Bubble) {
				// bubbleTrouble.deleteGameObject(this);
				// bubbleTrouble.deleteGameObject(trail);
				// System.out.println("Projectiel is gebotst met bubbel -> verdwijnt weer");
				// disappear();
				// getPlayer().setCanFire(true);
			}
		}
	}

	private Player getPlayer() {
		return bubbleTrouble.getPlayer();
	}

	/**
	 * Afvuren van projectiel vanaf de opgegeven coordinaten, met vaste snelheid (en zichtbaar maken).
	 * @param x
	 * @param y
	 */
	public void fire() {
		float projectileX = getPlayer().getX();
        float projectileY = getPlayer().getY();
        
        float trailX = x + getWidth()/2+10;
        float trailY = projectileY;
		
        trail.setX(trailX);
        trail.setY(trailY);
        setX(projectileX);
        setY(projectileY);

        setVisible(true);
		trail.setVisible(true);

		setySpeed(-5f*speedMultiplier);
		
		System.out.println("Projectiel met trail afgevuurd vanaf (" + x + ", " + y + ") "
				+ "met snelheid (" + getxSpeed() + ", " + getSpeed() + ").");
	}

	public void disappear() {
		setVisible(false);
		trail.setVisible(false);
		setySpeed(0);

		// Zet projectiel weer op plek van de speler om te voorkomen dat onnodige tile collissions gebeuren (ivm performance).
		setY(getPlayer().getY());
		setX(getPlayer().getX());
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof FloorTile) {
				try {
					// bubbleTrouble.deleteGameObject(this);
					// bubbleTrouble.deleteGameObject(trail);
					// getPlayer().setCanFire(true);
					System.out.println("Projectiel botst met tegel. Projectiel info: " + this);
					disappear();
				} catch (TileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void addSpeedMultiplier() {
		this.speedMultiplier += 0.25f;
	}

	@Override
	public void update() {
		// Doe niets.
	}
}
