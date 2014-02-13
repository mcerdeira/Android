package com.me.mygdxgame.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.mygdxgame.model.Block;

public class Renderer {
	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	private static final float RUNNING_FRAME_DURATION = 0.06f;
	private OrthographicCamera cam;
	private SpriteBatch spriteBatch;
	private Block block;
	private TextureRegion blockTexture;
	
	private int width;
	private int height;
	private float ppuX;	// pixels per unit on the X axis
	private float ppuY;	// pixels per unit on the Y axis
	
	public Renderer(Block block){
		this.block = block;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		spriteBatch = new SpriteBatch();
		loadTextures();
	}
	
	private void loadTextures() {
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("images/textures/textures.pack"));
		blockTexture = atlas.findRegion("block");
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
