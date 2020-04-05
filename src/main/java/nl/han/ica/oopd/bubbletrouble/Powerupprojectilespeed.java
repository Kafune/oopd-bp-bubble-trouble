package nl.han.ica.oopd.bubbletrouble;

import java.util.List;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

public class Powerupprojectilespeed extends Powerup{

	public Powerupprojectilespeed(Sprite sprite, BubbleTrouble bubbleTrouble) {
		super(sprite, bubbleTrouble);
		this.bubbleTrouble = bubbleTrouble;
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
