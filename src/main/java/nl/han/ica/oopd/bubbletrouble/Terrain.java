package nl.han.ica.oopd.bubbletrouble;

import java.util.ArrayList;
import java.util.Random;

import nl.han.ica.oopd.bubbletrouble.Bubble;
import nl.han.ica.oopg.objects.Sprite;

public class Terrain {
	private BubbleTrouble bubbleTrouble;
	private Player player;
	private Random random;

	private Bubble b;
	private ArrayList<Bubble> bubbles;

	public Terrain(BubbleTrouble bubbleTrouble, Player player) {
		bubbles = new ArrayList<Bubble>();
		this.player = player;
		random = new Random();
		this.bubbleTrouble = bubbleTrouble;
		addBubbles();
	}

	private void addBubbles() {
		for (int i = 0; i < 5; i++) {
			b = new Bubble(64, bubbleTrouble, new Sprite("src/main/resources/bubble-trouble/bubbleblue.png"), player);
			bubbles.add(b);
		}

		for (Bubble bubble : bubbles) {
			bubbleTrouble.addGameObject(bubble, random.nextInt(1020), 400);
		}
	}
}
