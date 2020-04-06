package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PVector;


public abstract class Powerup extends SpriteObject
		implements IAlarmListener, ICollidableWithTiles, ICollidableWithGameObjects {

	protected BubbleTrouble bubbleTrouble;
	
	private Alarm alarm;
	
	public Powerup(Sprite sprite, BubbleTrouble bubbleTrouble) {

		super(sprite);
		this.bubbleTrouble = bubbleTrouble;
		setGravity(0.1f);
		setHeight(24);
		setWidth(16);
		alarm = new Alarm("vanish", 3);
	}

	@Override
	public void triggerAlarm(String alarmName) {
		bubbleTrouble.deleteGameObject(this);
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		PVector vector;
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof FloorTile) {
				if (CollisionSide.TOP.equals(ct.getCollisionSide())) {
					vector = bubbleTrouble.getTileMap().getTilePixelLocation(ct.getTile());
					setY(vector.y - getHeight());
					setySpeed(0);
					setGravity(0);
					alarm.start();
				}
			}
		}
	}
}
