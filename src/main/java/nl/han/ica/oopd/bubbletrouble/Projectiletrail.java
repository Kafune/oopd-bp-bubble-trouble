package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

public class Projectiletrail extends Projectile implements ICollidableWithGameObjects {
	private BubbleTrouble bubbleTrouble;

	private Sprite sprite;
	private int trailWidth = 10;
	private int trailHeight = 30;
	private int trailSpeed = 5;
	
	public Projectiletrail(Sprite sprite,BubbleTrouble bubbleTrouble) {
		super(sprite, bubbleTrouble);
		this.sprite = sprite;
	}
	
	@Override
	public void update() {
		trailHeight += trailSpeed;
		sprite.resize(trailWidth, trailHeight);
	}
	
	
	
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		
	}

	
}
