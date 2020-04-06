package nl.han.ica.oopd.bubbletrouble;

import java.util.List;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;

public class PowerupProjectileSpeed extends Powerup{
	private Projectile projectile;
	private ProjectileTrail trail;
	private Player player; 
	
	public PowerupProjectileSpeed(Sprite sprite, BubbleTrouble bubbleTrouble, Player player) {
		super(sprite, bubbleTrouble);
		this.bubbleTrouble = bubbleTrouble;
		this.player = player;
		
		projectile = new Projectile(sprite, bubbleTrouble, player, trail);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Player) {
				enhanceSpeed();
			}
		}
	}

	@Override
	public void update() {
	}
	private void enhanceSpeed() {
		projectile.addSpeedMultiplier();
		bubbleTrouble.deleteGameObject(this);
	}

}
