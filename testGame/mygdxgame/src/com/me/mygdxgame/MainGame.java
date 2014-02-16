package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.me.mygdxgame.screens.GameScreen;

public class MainGame extends Game{
	GameScreen mainscreen;
	Texture starshipTexture;
	Texture asteroidTexture;
	
	@Override
	public void create() 
	{
		Texture.setEnforcePotImages(false);
		loadTextures();		
		mainscreen = new GameScreen(starshipTexture, asteroidTexture);
		this.setScreen(mainscreen);
	}
	
	private void loadTextures() 
	{		
		starshipTexture = new Texture(Gdx.files.internal("images/ship.png"));
		asteroidTexture = new Texture(Gdx.files.internal("images/asteroid.png"));
	}
}
