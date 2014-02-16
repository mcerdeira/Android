package com.me.mygdxgame.model;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid 
{
	private Rectangle bounds = new Rectangle();
	private Texture texture;
	private float SPEED;
	private StarShip starship;	
	Vector2 position = new Vector2();
	State state;
	
	public enum State 
	{
		ALIVE, DEAD
	}
	
	public Asteroid(Texture texture, StarShip starship)
	{
		this.state = State.ALIVE;
		this.texture = texture;		
		this.SPEED = 0.5f;
		//TODO: Replace this with screen size based values
		this.position.y = 40;
		Random rand = new Random();
		this.position.x = (float)rand.nextInt((10 - 0) + 1) + 0;
		float size = (float)4 * (rand.nextInt(4) + 1);
		this.bounds.height = size;
		this.bounds.width = size;
		this.starship = starship;
	}
	
	public void checkCollision()
	{
		if(starship.hitBox.overlaps(this.bounds)){
			starship.Hit();
			this.state = State.DEAD;
		}
	}
	
	public void update(float delta) 
	{
		this.position.y -= this.SPEED;
		this.bounds.x = this.position.x;
		this.bounds.y = this.position.y;
		if(this.position.y < -5)
		{
			this.state = State.DEAD;
		}
		else
		{
			checkCollision();
		}
	}
		
	public void draw(SpriteBatch spriteBatch,float ppuX, float ppuY) 
	{
		spriteBatch.draw(texture, this.position.x * ppuX, this.position.y * ppuY, this.bounds.width, this.bounds.height);
	}
}
