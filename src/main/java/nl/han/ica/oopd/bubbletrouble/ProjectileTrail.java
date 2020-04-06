package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class ProjectileTrail extends SpriteObject implements ICollidableWithGameObjects {
	private Sprite sprite;
	private BubbleTrouble bubbleTrouble;
	private Projectile projectile;
	private int trailWidth = 10;
	private int trailHeight = 30;
	private float trailSpeed = -5f;

	public ProjectileTrail(Sprite sprite, BubbleTrouble bubbleTrouble) {
		super(sprite);  
		this.bubbleTrouble = bubbleTrouble;
		this.sprite = sprite;
		setHeight(trailHeight);
		setY(getY()+trailHeight);
		setySpeed(trailSpeed);
	}

	@Override
	public void update() {
		trailHeight -= trailSpeed;
		sprite.resize(trailWidth, trailHeight);
		setHeight(-trailHeight);
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
