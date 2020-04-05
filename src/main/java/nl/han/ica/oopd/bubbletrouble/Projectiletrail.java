package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

public class Projectiletrail extends Projectile implements ICollidableWithGameObjects {
	private Sprite sprite;
	private BubbleTrouble bubbleTrouble;
	private Projectile projectile;
	private int trailWidth = 10;
	private int trailHeight = 30;
	private float trailSpeed = 5f;

	public Projectiletrail(Sprite sprite, BubbleTrouble bubbleTrouble) {
		super(sprite, bubbleTrouble);
		this.bubbleTrouble = bubbleTrouble;
		this.sprite = sprite;
	}

	@Override
	public void update() {
		trailHeight += trailSpeed;
		sprite.resize(trailWidth, trailHeight);
		setHeight(trailHeight);
	}

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Bubble) {
				bubbleTrouble.deleteGameObject(this);
				bubbleTrouble.deleteGameObject(projectile);
			}
		}
	}

}
