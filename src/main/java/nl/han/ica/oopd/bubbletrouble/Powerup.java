package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.alarm.IAlarmListener;
import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public abstract class Powerup extends SpriteObject implements IAlarmListener , ICollidableWithTiles, ICollidableWithGameObjects{

	public Powerup(Sprite sprite) {
		super(sprite);
		setGravity(0.1f);
		setHeight(24);
		setWidth(16);
	}
	
	@Override
	public void triggerAlarm(String alarmName) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		// TODO Auto-generated method stub
		
	}

}
