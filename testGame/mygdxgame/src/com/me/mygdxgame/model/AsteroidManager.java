package com.me.mygdxgame.model;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class AsteroidManager {
	public ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
	private int count = 0;
	private int maxcount = 0;
	private StarShip starship;
	private Texture asteroidTexture;
	
	public AsteroidManager(int maxcount,Texture asteroidTexture, StarShip starship){
		this.maxcount = maxcount;
		this.starship = starship;
		this.asteroidTexture = asteroidTexture;
	}
	
	public void generate(){
		if (count < maxcount){
			Asteroid a = new Asteroid(asteroidTexture);
			asteroids.add(a);
			count++;
		}
	}
	
	public void remove(Asteroid asteroid){
		asteroids.remove(asteroid);
		count--;
	}
	
	public void checkCollision(){
		for(Asteroid a : asteroids){
			if(starship.bounds.overlaps(a.bounds)){
				starship.Hit();
				this.remove(a);
				break;
			}
		}
	}
	
	public void update(float delta) {
		generate();
		checkCollision();
		for(Asteroid a : asteroids){
			a.update(delta);
		}
	}
}
