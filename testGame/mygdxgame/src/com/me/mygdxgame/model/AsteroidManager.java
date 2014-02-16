package com.me.mygdxgame.model;

import java.util.ArrayList;
import java.util.Iterator;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.mygdxgame.model.Asteroid.State;

public class AsteroidManager 
{
	public ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	private int count = 0;
	private int maxcount = 0;
	private StarShip starship;
	private Texture asteroidTexture;
	private int generationLoop = 0;
	
	public AsteroidManager(int maxcount,Texture asteroidTexture, StarShip starship)
	{
		this.maxcount = maxcount;
		this.starship = starship;
		this.asteroidTexture = asteroidTexture;
	}
	
	public void generate()
	{
		if (count < maxcount)
		{
			if(generationLoop == 0)
			{
				Asteroid a = new Asteroid(asteroidTexture, starship);
				asteroids.add(a);
				count++;
				generationLoop = 5;
			}
			else
			{
				generationLoop--;
			}
		}
	}
	
	public void remove()
	{
		Iterator<Asteroid> iterator = asteroids.iterator();		
		while (iterator.hasNext()) {
			Asteroid a = iterator.next();
			if(a.state == State.DEAD){
				iterator.remove();
			}
		}
		count--;
	}
	
	public void update(float delta) 
	{		
		for(Asteroid a : asteroids) 
		{			
			a.update(delta);
		}
		remove();
		generate();
	}
	
	public void draw(SpriteBatch spriteBatch, float ppuX, float ppuY) 
	{
		for(Asteroid a : asteroids)
		{
			a.draw(spriteBatch, ppuX, ppuY);
		}
	}
}
