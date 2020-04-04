package nl.han.ica.oopd.bubbletrouble;

import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;
import processing.core.PConstants;

public class Player extends AnimatedSpriteObject{
	private BubbleTrouble bubbleTrouble;
	final int size = 20;
	public Player(BubbleTrouble bubbleTrouble) {
		super(new Sprite(bubbleTrouble.MEDIA_URL.concat("player.png")), 3);
		this.bubbleTrouble = bubbleTrouble;
		setFriction(0.10f);
	}

	@Override
	public void update() {
        if (getX() <= 0) {
            setxSpeed(0);
            setX(0);
        }
        if (getX() >= bubbleTrouble.width - size) {
            setxSpeed(0);
            setX(bubbleTrouble.width - size);
        }	
        
	}
    @Override
    public void keyPressed(int keyCode, char key) {
        final int speed = 5;
        if (keyCode == PConstants.LEFT) {
            setDirectionSpeed(270, speed);
            setCurrentFrameIndex(2);
        }
        if (keyCode == PConstants.RIGHT) {
            setDirectionSpeed(90, speed);
            setCurrentFrameIndex(1);
        }
        if (key == ' ') {
            System.out.println("pew");
            setCurrentFrameIndex(0);
        }
    }
}
