package nl.han.ica.oopd.bubbletrouble;

import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;

public class Player extends AnimatedSpriteObject{
	private BubbleTrouble bubbletrouble;
	
	public Player(BubbleTrouble bubbletrouble) {
		super(new Sprite(bubbletrouble.MEDIA_URL.concat("player.png")), 3);
		this.bubbletrouble = bubbletrouble;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
