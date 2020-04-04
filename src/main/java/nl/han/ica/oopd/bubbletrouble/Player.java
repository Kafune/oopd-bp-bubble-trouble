package nl.han.ica.oopd.bubbletrouble;

import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;

public class Player extends AnimatedSpriteObject{
	private BubbleTrouble bubbleTrouble;
	
	public Player(BubbleTrouble bubbleTrouble) {
		super(new Sprite(bubbleTrouble.MEDIA_URL.concat("player.png")), 3);
		this.bubbleTrouble = bubbleTrouble;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
