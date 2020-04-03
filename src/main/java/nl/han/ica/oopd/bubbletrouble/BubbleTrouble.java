package nl.han.ica.oopd.bubbletrouble;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.view.View;
import nl.han.ica.oopg.dashboard.Dashboard;
import processing.core.PApplet;

public class BubbleTrouble extends GameEngine {
	
	private TextObject dashboardText;
	private Bubble bubble;
	private Player player;
	
	public static String MEDIA_URL = "src/main/resources/bubble-trouble/";
	
	public static void main(String[] args) {
//		PApplet.main(new String[] { "nl.han.ica.oopd.bubbletrouble.BubbleTrouble" });
		String[] processingArgs = {"nl.han.ica.oopd.bubbletrouble.BubbleTrouble"};
		BubbleTrouble bubbleTrouble = new BubbleTrouble();
		
		PApplet.runSketch(processingArgs, bubbleTrouble);
	}

	@Override
	public void setupGame() {
        int worldWidth = 1080;
        int worldHeight = 720;
        
        createDashBoard(worldWidth, 100);
        
        createObjects();
        
        viewPortScreen(worldWidth, worldHeight);
	}

	@Override
	public void update() {
		// Hierin komen de methodes die over tijd gebeuren. bubbels die uit elkaar splitten bijv.
	}
	
	public void createDashBoard(int dashboardWidth, int dashboardHeight) {
		Dashboard dashboard = new Dashboard(0, 620, dashboardWidth, dashboardHeight);
		dashboardText = new TextObject("Testtext", 14);
		refreshDashboardText();
		dashboard.addGameObject(dashboardText);
		addDashboard(dashboard);
	}
	
	public void viewPortScreen(int screenWidth, int screenHeight) {
		View view = new View(screenWidth, screenHeight);
		view.setBackground(loadImage(MEDIA_URL + "startscreen.jpg"));
		setView(view);
		size(screenWidth, screenHeight);
	}
	
	private void refreshDashboardText() {
		dashboardText.setText("TODO"); //Score refresher.
	}
	
	private void createObjects() {
		player = new Player(this);
		addGameObject(player, 200, 200);
	}
	
}
