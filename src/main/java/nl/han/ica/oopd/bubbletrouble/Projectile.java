package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Projectile extends SpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles {
	private BubbleTrouble bubbleTrouble;
	private Player player;
	private ProjectileTrail trail;
	private float speedMultiplier = 1f;

	public Projectile(Sprite sprite, BubbleTrouble bubbleTrouble, Player player, ProjectileTrail trail) {
		super(sprite);
		this.bubbleTrouble = bubbleTrouble;
		this.player = player;
		this.trail = trail;
		setySpeed(-5f*speedMultiplier);
		setHeight(15);
		setWidth(15);
	}

	@Override
	public void update() {

	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Bubble) {
				bubbleTrouble.deleteGameObject(this);
				bubbleTrouble.deleteGameObject(trail);
				player.setCanFire(true);
			}
		}
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof FloorTile) {
				try {
					bubbleTrouble.deleteGameObject(this);
					bubbleTrouble.deleteGameObject(trail);
					player.setCanFire(true);
				} catch (TileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void addSpeedMultiplier() {
		this.speedMultiplier += 0.25f;
	}
}
