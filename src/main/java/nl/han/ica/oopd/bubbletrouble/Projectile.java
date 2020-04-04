package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Projectile extends SpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles {
	private BubbleTrouble bubbleTrouble;
	private Player player;
	private int tileSize = 60;

	public Projectile(Sprite sprite) {
		super(sprite);
		setySpeed(-5f);
		setHeight(15);
		setWidth(15);
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof FloorTile) {
				player.setCanFire(true);
				System.out.println("je kan weer vuren");
				bubbleTrouble.deleteGameObject(this);
			}
		}
	}
}
