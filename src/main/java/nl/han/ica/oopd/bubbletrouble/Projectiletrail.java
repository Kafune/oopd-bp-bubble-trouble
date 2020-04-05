package nl.han.ica.oopd.bubbletrouble;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.Sprite;

public class Projectiletrail extends Projectile implements ICollidableWithGameObjects {
	private BubbleTrouble bubbleTrouble;
	
	public Projectiletrail(Sprite sprite,BubbleTrouble bubbleTrouble) {
		super(sprite, bubbleTrouble);
		this.bubbleTrouble = bubbleTrouble;
	}
	
	
	
}
