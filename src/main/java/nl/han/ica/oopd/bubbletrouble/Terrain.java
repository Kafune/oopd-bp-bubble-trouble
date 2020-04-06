package nl.han.ica.oopd.bubbletrouble;

import java.util.ArrayList;
import java.util.Random;

import nl.han.ica.oopd.bubbletrouble.Bubble;
import nl.han.ica.oopg.objects.Sprite;

public class Terrain {
	private BubbleTrouble bubbleTrouble;
	private Random random;

	private Bubble b;
	private ArrayList<Bubble> bubbles;

	public Terrain(BubbleTrouble bubbleTrouble) {
		bubbles = new ArrayList<Bubble>();
		random = new Random();
		this.bubbleTrouble = bubbleTrouble;
		addBubbles();
	}

	private void addBubbles() {
		for (int i = 0; i < 5; i++) {
			b = new Bubble(64, bubbleTrouble);
			bubbles.add(b);
		}

		for (Bubble bubble : bubbles) {
			bubbleTrouble.addGameObject(bubble, random.nextInt(1020), 400);
		}
	}
}
