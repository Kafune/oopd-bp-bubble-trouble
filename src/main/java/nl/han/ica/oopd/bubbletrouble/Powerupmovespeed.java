package nl.han.ica.oopd.bubbletrouble;

import java.util.List;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

public class Powerupmovespeed extends Powerup {
	private Player player;
	public Powerupmovespeed(Sprite sprite, BubbleTrouble bubbleTrouble) {
		super(sprite, bubbleTrouble);
		this.bubbleTrouble = bubbleTrouble;
		player = new Player(bubbleTrouble);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				enhancePlayerSpeed();
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
	public void enhancePlayerSpeed() {
		player.addSpeedMultiplier();
		bubbleTrouble.deleteGameObject(this);
	}
}
