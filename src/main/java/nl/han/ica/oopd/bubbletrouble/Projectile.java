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
	private Projectiletrail trail;

	public Projectile(Sprite sprite, BubbleTrouble bubbleTrouble) {
		super(sprite);
		this.bubbleTrouble = bubbleTrouble;
		player = new Player(bubbleTrouble);
		setySpeed(-5f);
		setHeight(15);
		setWidth(15);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Bubble) {
				bubbleTrouble.deleteGameObject(this);
				player.setCanFire(true);
			}
		}
	}

	@Override
	public void update() {

	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof FloorTile) {
				try {
					bubbleTrouble.deleteGameObject(this);
					bubbleTrouble.deleteGameObject(trail);
					player.setCanFire(true);
					System.out.println(player.getCanFire());

				} catch (TileNotFoundException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
