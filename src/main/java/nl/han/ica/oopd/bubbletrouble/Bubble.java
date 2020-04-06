package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.GameObject;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PVector;

public class Bubble extends SpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects {

	private BubbleTrouble bubbleTrouble;
	private Powerup powerupMovespeed;
	private Powerup powerupProjectilespeed;
	private Player player;
//	private int bubbleSize;

	public Bubble(int bubbleSize, BubbleTrouble bubbleTrouble, Sprite sprite, Player player) {
		super(sprite);
		this.bubbleTrouble = bubbleTrouble;
		this.player = player;
		powerupMovespeed = new PowerupMoveSpeed(new Sprite("src/main/resources/bubble-trouble/movespeedpowerup.png"),
				bubbleTrouble, player);
		powerupProjectilespeed = new PowerupProjectileSpeed(new Sprite("src/main/resources/bubble-trouble/projectilespeedpowerup.png"), bubbleTrouble, player);
//		this.bubbleSize = bubbleSize;
		setGravity(0.20f);
		setySpeed(-bubbleSize / 10f);
		setxSpeed(-bubbleSize / 8f);
		setHeight(bubbleSize);
		setWidth(bubbleSize);
	}

	@Override
	public void update() {

	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		PVector vector;
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof FloorTile) {
				try {
					if (CollisionSide.BOTTOM.equals(ct.getCollisionSide())) {
						vector = bubbleTrouble.getTileMap().getTilePixelLocation(ct.getTile());
						setY(vector.y - getHeight());
						setySpeed(-getySpeed());
						setDirection(225);
					}
					if (CollisionSide.LEFT.equals(ct.getCollisionSide())) {
						vector = bubbleTrouble.getTileMap().getTilePixelLocation(ct.getTile());
						setX(vector.x - getWidth());
						setxSpeed(-getxSpeed());
						setDirection(345);
					}

					if (CollisionSide.TOP.equals(ct.getCollisionSide())) {
						vector = bubbleTrouble.getTileMap().getTilePixelLocation(ct.getTile());
						setY(vector.y - getHeight());
						setySpeed(-getySpeed());
						if (getDirection() <= 180) {
							setDirection(15);
						} else {
							setDirection(345);
						}
					}

					if (CollisionSide.RIGHT.equals(ct.getCollisionSide())) {
						vector = bubbleTrouble.getTileMap().getTilePixelLocation(ct.getTile());
						setX(vector.x + getWidth());
						setxSpeed(-getxSpeed());
						setDirection(15);
					}

				} catch (TileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Projectile || g instanceof ProjectileTrail) {
				bubbleTrouble.deleteGameObject(this);
//				if (bubbleTrouble.isMovespeedPowerupSpawned() == false) {
//					bubbleTrouble.addGameObject(powerupMovespeed, getX(), getY() + 10);
//					bubbleTrouble.setMovespeedPowerupSpawned(true);
//				}
				if (bubbleTrouble.isProjectilePowerupSpawned() == false) {
					bubbleTrouble.addGameObject(powerupProjectilespeed, getX(), getY() + 10);
					bubbleTrouble.setProjectilePowerupSpawned(true);
				}
			} else if (g instanceof Bubble) {
				// bubble
			}
		}
	}
}
