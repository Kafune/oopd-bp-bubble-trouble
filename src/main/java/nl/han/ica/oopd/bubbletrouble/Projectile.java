package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Projectile extends SpriteObject implements ICollidableWithGameObjects {
	private BubbleTrouble bubbleTrouble;
	

	public Projectile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Projectile) {
				bubbleTrouble.deleteGameObject(this);
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
