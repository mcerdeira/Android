package com.me.mygdxgame.screens;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.me.mygdxgame.controller.GameController;
import com.me.mygdxgame.model.*;
import com.me.mygdxgame.views.GameRenderer;

public class GameScreen implements Screen, InputProcessor 
{
	private StarShip starship; // The only existing instance of starship
	private GameController gamecontroller;
	private GameRenderer renderer;
	private int width, height;
	private AsteroidManager asteroidmanager;
	
	public GameScreen(	Texture starshipTexture, Texture asteroidTexture)
	{
		//TODO: Replace this with screen size based values
		starship = new StarShip(new Vector2(7, 0), starshipTexture);
		asteroidmanager = new AsteroidManager(10, asteroidTexture, starship);
		renderer = new GameRenderer(starship, asteroidmanager);
		gamecontroller = new GameController(starship, asteroidmanager);
		Gdx.input.setInputProcessor(this);
	}
	
	@Override
	public void show() 
	{
		// called when this screen is set as the screen with game.setScreen();
	}
		
	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gamecontroller.update(delta);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) 
	{
		renderer.setSize(width, height);
		this.width = width;
		this.height = height;		
	}

	@Override
	public void hide() 
	{
		Gdx.input.setInputProcessor(null);		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean keyDown(int keycode) 
	{
		if (keycode == Keys.LEFT)
		{
			gamecontroller.leftPressed();
		}
		if (keycode == Keys.RIGHT)
		{
			gamecontroller.rightPressed();
		}
		return true;
	}
	
	@Override
	public boolean keyUp(int keycode) 
	{
		if (keycode == Keys.LEFT)
		{
			gamecontroller.leftReleased();
		}
		if (keycode == Keys.RIGHT)
		{
			gamecontroller.rightReleased();
		}
		return true;
	}
	
	@Override
	public boolean keyTyped(char character) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) 
	{
		if (!Gdx.app.getType().equals(ApplicationType.Android))
		{
			return false;
		}
		if (x < width / 2 && y > height / 2) 
		{
			gamecontroller.leftPressed();
		}
		if (x > width / 2 && y > height / 2) 
		{
			gamecontroller.rightPressed();
		}
	return true;
	}
	
	@Override
	public boolean touchUp(int x, int y, int pointer, int button) 
	{
		if (!Gdx.app.getType().equals(ApplicationType.Android))
		{
			return false;
		}
		if (x < width / 2 && y > height / 2) 
		{
			gamecontroller.leftReleased();
		}
		if (x > width / 2 && y > height / 2) 
		{
			gamecontroller.rightReleased();
		}
		return true;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) 
	{
		// TODO Auto-generated method stub
		return false;
	}
}
