package nl.han.ica.oopd.bubbletrouble;

import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PConstants;

public class Player extends AnimatedSpriteObject  {
	private BubbleTrouble bubbleTrouble;
	private Projectile projectile;
//	private Powerup powerupMoveSpeed;
	private ProjectileTrail trail;

	final int tileSize = 60;
	final int size = 20;


	private float speedMultiplier = 1f;
	private boolean canFire = true;

	public Player(BubbleTrouble bubbleTrouble) {
		super(new Sprite(bubbleTrouble.MEDIA_URL.concat("player.png")), 3);
		this.bubbleTrouble = bubbleTrouble;
		
		setFriction(0.10f);
	}

	@Override
	public void update() {
        if (getX() <= tileSize) {
            setxSpeed(0);
            setX(tileSize);
        }
        if (getX() >= bubbleTrouble.width - size -tileSize) {
            setxSpeed(0);
            setX(bubbleTrouble.width - size - tileSize);
        }        
	}
    @Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        if (keyCode == PConstants.LEFT) { 
             setDirectionSpeed(270, speed*speedMultiplier);
            setCurrentFrameIndex(2);
        }
        if (keyCode == PConstants.RIGHT) {
            setDirectionSpeed(90, speed*speedMultiplier);
            setCurrentFrameIndex(1);
        }
        if (key == ' ' && canFire) {
            System.out.println(canFire);
            setCurrentFrameIndex(0);
            projectile = new Projectile(new Sprite("src/main/resources/bubble-trouble/projectile.png"), bubbleTrouble, this);
    		trail = new ProjectileTrail(new Sprite("src/main/resources/bubble-trouble/projectiletrail.png"), bubbleTrouble);
    		
    		
            bubbleTrouble.addGameObject(projectile, getX(), getY() + 10);
    		bubbleTrouble.addGameObject(trail, getX() + (getWidth() / 2), projectile.getY() - (getHeight()));
    		System.out.println(trail.getHeight());

            canFire = false;
        }
    }
        
	public boolean getCanFire() {
		return canFire;
	}

	public void setCanFire(boolean canFire) {
		this.canFire = canFire;
	}
	
	public void addSpeedMultiplier() {
		this.speedMultiplier += 0.25f;
	}

	public Projectile getProjectile() {
		return projectile;
	}

	public ProjectileTrail getTrail() {
		return trail;
	}
}
