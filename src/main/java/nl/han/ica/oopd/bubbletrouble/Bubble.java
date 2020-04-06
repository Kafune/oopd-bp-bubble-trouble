package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopd.waterworld.BubbleSpawner;
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
	private int bubbleSize;
	static Sprite bubbleSprite = new Sprite("src/main/resources/bubble-trouble/bubbleblue.png");

	public Bubble(int bubbleSize, BubbleTrouble bubbleTrouble) {
		super(bubbleSprite);
		this.bubbleTrouble = bubbleTrouble;
		this.bubbleSize = bubbleSize;
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
			if (g instanceof Projectile) {
				Projectile projectile = (Projectile) g;
				// bubbleTrouble.deleteGameObject(this);
				
				if(bubbleSize>16) {
					System.out.println("Bubble groter dan 16: splitsen");
					int smallerBubbleSize = bubbleSize/2;
					Bubble newBubble1 = new Bubble(smallerBubbleSize, bubbleTrouble);
					newBubble1.setxSpeed(-getxSpeed());
					
					// De twee nieuwe bubbles moeten verplaatst om te voorkomen dat ze direct weer botsen.
					// En wellicht daardoor direct verdwijnen, omdat projectiel niet direct verdwijnt bij botsing.
					// TODO: Mooier om in plaats hiervan nieuwe bubbels na aanmaken even tijdje 'onbotsbaar te maken'
					// Dit via ander stukje bubble logica, dan verschieten ze niet opeens.
					final int VERPLAATSEN_BIJ_BOTSING = 40;
					newBubble1.setX(getX()+VERPLAATSEN_BIJ_BOTSING);
					newBubble1.setY(getY());
					newBubble1.setySpeed(getySpeed());
					bubbleTrouble.addGameObject(newBubble1);

					// Maak ook de huidige bubbel kleiner.
					bubbleSize = smallerBubbleSize;
					setWidth(bubbleSize);
					setX(getX()-VERPLAATSEN_BIJ_BOTSING);

					setHeight(bubbleSize);
				} else {
					projectile.disappear();
				}
			}
		}
	}

	@Override
	public void draw(PGraphics g) {
		//g.fill(120, 120, 230);
		//g.ellipse(x, y, bubbleSize, bubbleSize);
		g.image(getImage(), x, y, getWidth(), getHeight());

	}
}
