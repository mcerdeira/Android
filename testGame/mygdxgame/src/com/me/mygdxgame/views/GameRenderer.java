package com.me.mygdxgame.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.mygdxgame.model.Block;

public class GameRenderer {
	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	private OrthographicCamera cam;
	private SpriteBatch spriteBatch;
	private Block block;
	private Texture blockTexture;
	
	private int width;
	private int height;
	private float ppuX;	// pixels per unit on the X axis
	private float ppuY;	// pixels per unit on the Y axis
	
	public GameRenderer(Block block){
		this.block = block;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		spriteBatch = new SpriteBatch();
		loadTextures();
	}
	
	private void loadTextures() {		
		blockTexture = new Texture(Gdx.files.internal("images/block.png"));
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
		spriteBatch.draw(blockTexture, block.getPosition().x * ppuX, block.getPosition().y * ppuY, block.SIZE * ppuX, block.SIZE * ppuY);
	}
}
