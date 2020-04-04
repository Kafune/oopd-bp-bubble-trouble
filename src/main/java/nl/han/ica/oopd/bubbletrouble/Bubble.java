package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PConstants;
import processing.core.PGraphics;

public class Bubble extends SpriteObject implements ICollidableWithGameObjects {

	private BubbleTrouble bubbleTrouble;
	private int bubbleSize;

	public Bubble(int bubbleSize, BubbleTrouble bubbleTrouble, Sprite sprite) {
		super(sprite);
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
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Projectile) {
				bubbleTrouble.deleteGameObject(this);
			}
		}
	}
}
