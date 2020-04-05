package nl.han.ica.oopd.bubbletrouble;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.tile.TileMap;
import nl.han.ica.oopg.tile.TileType;
import nl.han.ica.oopg.view.View;
import nl.han.ica.oopg.dashboard.Dashboard;
import processing.core.PApplet;

public class BubbleTrouble extends GameEngine {

	private TextObject dashboardText;
	private FloorTile floorTile;
	private Bubble bubble;
	private Player player;
	private Terrain terrain;
	
	private final int START_SCREEN = 0;
	private final int GAME_SCREEN = 1;
	private int currentLevel;
	private int currentScreen;
	
	private int tileSize;

	public static String MEDIA_URL = "src/main/resources/bubble-trouble/";

	public static void main(String[] args) {
//		PApplet.main(new String[] { "nl.han.ica.oopd.bubbletrouble.BubbleTrouble" });
		String[] processingArgs = { "nl.han.ica.oopd.bubbletrouble.BubbleTrouble" };
		BubbleTrouble bubbleTrouble = new BubbleTrouble();

		PApplet.runSketch(processingArgs, bubbleTrouble);
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	@Override
	public void setupGame() {
		int worldWidth = 1080;
		int worldHeight = 720;

		createDashBoard(worldWidth, 100);
		initializeTileMap();
		terrain = new Terrain(this);

		createObjects();

		viewPortScreen(worldWidth, worldHeight);
		currentScreen = 0;
	}

	@Override
	public void update() {
		// Hierin komen de methodes die over tijd gebeuren. bubbels die uit elkaar
		// splitten bijv.
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
		dashboardText.setText("TODO"); // Score refresher.
	}

	private void createObjects() {
		player = new Player(this);
		addGameObject(player, 500, 720 - 180 - 60); // hoogte = schermhoogte - hudhoogte - playerhoogte
	}

	private void initializeTileMap() {
		// Load Sprites
		Sprite floorSprite = new Sprite(MEDIA_URL + "boards-tile.png");
		// Create tile types with the right Tile class and sprite
		TileType<FloorTile> floorTileType = new TileType<>(FloorTile.class, floorSprite);

		TileType[] tileTypes = { floorTileType };
		tileSize = 60;
		int tilesMap[][] = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
				{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, },
				{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, },
				{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, },
				{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, },
				{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, },
				{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, },
				{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, },
				{ 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
				{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, },
				{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, }, };
		tileMap = new TileMap(tileSize, tileTypes, tilesMap);
	}

	public Bubble getBubble() {
		return bubble;
	}

	public void setBubble(Bubble bubble) {
		this.bubble = bubble;
	}

}
