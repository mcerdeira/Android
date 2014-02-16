package com.me.mygdxgame.views;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.mygdxgame.model.*;

public class GameRenderer {
	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	private OrthographicCamera cam;
	private SpriteBatch spriteBatch;
	private StarShip starship;
	private AsteroidManager asteroidmanager;
	
	private int width;
	private int height;
	private float ppuX;	// pixels per unit on the X axis
	private float ppuY;	// pixels per unit on the Y axis
	
	public GameRenderer(StarShip starship, AsteroidManager asteroidmanager){
		this.asteroidmanager = asteroidmanager;
		this.starship = starship;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		spriteBatch = new SpriteBatch();
	}
	
	public void setSize (int w, int h) {
		this.width = w;
		this.height = h;
		ppuX = (float)width / CAMERA_WIDTH;
		ppuY = (float)height / CAMERA_HEIGHT;
	}
	
	public void render() {
		spriteBatch.begin();
		draw();
		spriteBatch.end();
	}
	
	private void draw() {			
		starship.draw(spriteBatch, ppuX, ppuY);
		for(Asteroid a : asteroidmanager.asteroids){
			a.draw(spriteBatch);
		}
	}
}
