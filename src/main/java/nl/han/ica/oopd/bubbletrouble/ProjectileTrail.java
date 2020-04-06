package nl.han.ica.oopd.bubbletrouble;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PGraphics;

public class ProjectileTrail extends SpriteObject implements ICollidableWithGameObjects {
	private Sprite sprite;
	private BubbleTrouble bubbleTrouble;
	private Projectile projectile;
	private int trailWidth = 10;
	private int trailHeight = 30;

	public ProjectileTrail(Sprite sprite, Projectile projectile, BubbleTrouble bubbleTrouble) {
		super(sprite);

		this.bubbleTrouble = bubbleTrouble;
		this.projectile = projectile;
		this.sprite = sprite;
	}

	@Override
	public void update() {
		if (isVisible()) {
			// Maak trail sprite langer zodat hij van eigen vast positie tot aan positie van projectiel reikt.
			trailHeight = (int) (getY() - projectile.getY());
			sprite.resize(trailWidth, trailHeight);
			setHeight(trailHeight);
			setWidth(trailWidth);
			
			System.out.println("Projectiel info: " + this);
		}
	}

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject g : collidedGameObjects) {
			if (g instanceof Bubble) {
				setVisible(false);
				setySpeed(0);
				// bubbleTrouble.deleteGameObject(this);
				// bubbleTrouble.deleteGameObject(projectile);
			}
		}
	}

	@Override
	public String toString() {
		return "ProjectileTrail [sprite=" + sprite + ", bubbleTrouble=" + bubbleTrouble + ", projectile=" + projectile
				+ ", trailWidth=" + trailWidth + ", trailHeight=" + trailHeight + ", x="
				+ x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}

	@Override
	public void draw(PGraphics g) {
		g.image(getImage(), x, y-trailHeight);
	}
	
}
