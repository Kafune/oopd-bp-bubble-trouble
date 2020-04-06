package nl.han.ica.oopd.bubbletrouble;

import java.util.List;
import java.util.Random;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.GameObject;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;
import processing.core.PVector;

public class Bubble extends SpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects {

	private BubbleTrouble bubbleTrouble;
	private Powerup powerupMovespeed;
	private Powerup powerupProjectilespeed;
	private Projectile projectile;
	private Player player;
	private Random random;
	private int bubbleSize;

	public Bubble(int bubbleSize, BubbleTrouble bubbleTrouble, Sprite sprite, Player player, Projectile projectile) {
		super(sprite);
		this.bubbleTrouble = bubbleTrouble;
		this.player = player;
		this.projectile = projectile;
		powerupMovespeed = new PowerupMoveSpeed(new Sprite("src/main/resources/bubble-trouble/movespeedpowerup.png"),
				bubbleTrouble, player);
		powerupProjectilespeed = new PowerupProjectileSpeed(
				new Sprite("src/main/resources/bubble-trouble/projectilespeedpowerup.png"), bubbleTrouble, player, projectile);
		this.bubbleSize = bubbleSize;
		random = new Random();
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
						System.out.println(bubbleSize);
						if (bubbleSize == 64) {
							setX(vector.x + getWidth());
						} else if (bubbleSize == 32) {
							setX(vector.x + getWidth()+32);
						} else if (bubbleSize == 16) {
							setX(vector.x + getWidth()+64);
						}
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
//				Projectile projectile = (Projectile) g;
				// bubbleTrouble.deleteGameObject(this);

				if (bubbleSize > 16) {
					System.out.println("Bubble groter dan 16: splitsen");
					int smallerBubbleSize = bubbleSize / 2;
					Bubble newBubble1 = new Bubble(smallerBubbleSize, bubbleTrouble,
							new Sprite("src/main/resources/bubble-trouble/bubbleblue.png"), player, player.getProjectile());
					newBubble1.setxSpeed(-getxSpeed());

					// De twee nieuwe bubbles moeten verplaatst om te voorkomen dat ze direct weer
					// botsen.
					// En wellicht daardoor direct verdwijnen, omdat projectiel niet direct
					// verdwijnt bij botsing.
					// TODO: Mooier om in plaats hiervan nieuwe bubbels na aanmaken even tijdje
					// 'onbotsbaar te maken'
					// Dit via ander stukje bubble logica, dan verschieten ze niet opeens.
					final int VERPLAATSEN_BIJ_BOTSING = 40;
					newBubble1.setX(getX() + VERPLAATSEN_BIJ_BOTSING);
					newBubble1.setY(getY());
					newBubble1.setySpeed(getySpeed());
					bubbleTrouble.addGameObject(newBubble1);

					// Maak ook de huidige bubbel kleiner.
					this.bubbleSize = smallerBubbleSize;
					setWidth(bubbleSize);
					setX(getX() - VERPLAATSEN_BIJ_BOTSING);

					setHeight(bubbleSize);
				} else {
					bubbleTrouble.deleteGameObject(this);
				}

				int powerupRoll = random.nextInt(4);
				System.out.println(powerupRoll);
				if (powerupRoll == 0) {
					if (bubbleTrouble.isProjectilePowerupSpawned() == false) {
						bubbleTrouble.addGameObject(powerupProjectilespeed, getX(), getY() + 10);
						bubbleTrouble.setProjectilePowerupSpawned(true);
					}
				} else if (powerupRoll == 1) {
					if (bubbleTrouble.isMovespeedPowerupSpawned() == false) {
						bubbleTrouble.addGameObject(powerupMovespeed, getX(), getY() + 10);
						bubbleTrouble.setMovespeedPowerupSpawned(true);
					}
				}

			} else if (g instanceof Bubble) {
				// bubble
			}
		}
	}

	@Override
	public void draw(PGraphics g) {
		// g.fill(120, 120, 230);
		// g.ellipse(x, y, bubbleSize, bubbleSize);
		g.image(getImage(), x, y, getWidth(), getHeight());
	}
}
