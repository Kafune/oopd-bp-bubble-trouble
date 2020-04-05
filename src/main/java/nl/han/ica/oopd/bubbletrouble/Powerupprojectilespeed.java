package nl.han.ica.oopd.bubbletrouble;

import java.util.List;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

public class Powerupprojectilespeed extends Powerup{
	private Projectile projectile;
	private Player player; 
	public Powerupprojectilespeed(Sprite sprite, BubbleTrouble bubbleTrouble, Player player) {
		super(sprite, bubbleTrouble);
		this.bubbleTrouble = bubbleTrouble;
		this.player = player;
		
		projectile = new Projectile(sprite, bubbleTrouble, player);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				enhanceProjectileSpeed();
			}
		}
	}

	@Override
	public void update() {
	}
	private void enhanceProjectileSpeed() {
		projectile.addSpeedMultiplier();
		bubbleTrouble.deleteGameObject(this);
	}

}
