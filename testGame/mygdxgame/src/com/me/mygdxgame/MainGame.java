package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.me.mygdxgame.screens.GameScreen;

public class MainGame extends Game{	
	@Override
	public void create() {
		// Crea la instancia, llama a show() y entre en el loop, llamando a render()
		setScreen(new GameScreen());
	}
}
