package nl.han.ica.oopd.bubbletrouble;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.view.View;
import nl.han.ica.oopg.dashboard.Dashboard;
import processing.core.PApplet;

public class BubbleTrouble extends GameEngine {
	
	private TextObject dashboardText;
	
	public static void main(String[] args) {
		PApplet.main(new String[] { "nl.han.ica.oopd.bubbletrouble.BubbleTrouble" });

	}

	@Override
	public void setupGame() {
        int worldWidth = 1080;
        int worldHeight = 720;
        
        createDashBoard(worldWidth, 100);
        
        viewPortScreen(worldWidth, worldHeight);
	}

	@Override
	public void update() {
		
	}
	
	public void createDashBoard(int dashboardWidth, int dashboardHeight) {
		Dashboard dashboard = new Dashboard(0, 620, dashboardWidth, dashboardHeight);
	}
	
	public void viewPortScreen(int screenWidth, int screenHeight) {
		View view = new View(screenWidth, screenHeight);
		view.setBackground(loadImage("src/main/resources/bubble-trouble/startscreen.jpg"));
		setView(view);
		size(screenWidth, screenHeight);
	}
	
}
