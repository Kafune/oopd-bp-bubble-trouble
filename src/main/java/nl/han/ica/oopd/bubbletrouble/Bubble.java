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

public class Bubble extends SpriteObject implements ICollidableWithTiles {

	private BubbleTrouble bubbleTrouble;
//	private int bubbleSize;

	public Bubble(int bubbleSize, BubbleTrouble bubbleTrouble, Sprite sprite) {
		super(sprite);
		this.bubbleTrouble = bubbleTrouble;
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
						setDirection(340);
					}

					if (CollisionSide.TOP.equals(ct.getCollisionSide())) {
						vector = bubbleTrouble.getTileMap().getTilePixelLocation(ct.getTile());
						setY(vector.y - getHeight());
						setySpeed(-getySpeed());
						
						setDirection(45);
						System.out.println(getY());
					}

					if (CollisionSide.RIGHT.equals(ct.getCollisionSide())) {
						vector = bubbleTrouble.getTileMap().getTilePixelLocation(ct.getTile());
						setX(vector.x + getWidth());
						setxSpeed(-getxSpeed());
						setDirection(20);
					}

				} catch (TileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
