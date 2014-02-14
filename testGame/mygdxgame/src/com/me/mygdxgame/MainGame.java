package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.me.mygdxgame.screens.GameScreen;

public class MainGame extends Game{
	GameScreen mainscreen;
	
	@Override
	public void create() {				
		mainscreen = new GameScreen();
		this.setScreen(mainscreen);
	}
}
