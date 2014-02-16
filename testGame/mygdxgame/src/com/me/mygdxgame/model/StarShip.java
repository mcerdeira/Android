package com.me.mygdxgame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class StarShip 
{
	public static final float SPEED = 4f;
	public static final float SIZE = 0.5f; // half a unit
	public Rectangle hitBox = new Rectangle();
	float stateTime = 0;
	private int score = 0;
	private int best = 0;
	
	public enum State 
	{
		IDLE, MOVING
	}
	State state;
	Vector2 position = new Vector2();
	Vector2 acceleration = new Vector2();
	Vector2 velocity = new Vector2();
	Rectangle bounds = new Rectangle();	
	Texture texture;
	BitmapFont font = new BitmapFont();
	
	public StarShip(Vector2 position, Texture texture)
	{
		this.position = position;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
		this.hitBox.height = SIZE / 2;
		this.hitBox.width = SIZE / 2;
		this.state = State.IDLE;
		this.texture = texture;
	}
	
	public void Hit()
	{
		if(score > best)
		{
			best = score;
		}		
		score = 0;
	}
	
	public Vector2 getAcceleration() 
	{
		return acceleration;
	}

	public Vector2 getVelocity() 
	{
		return velocity;
	}
	
	public Vector2 getPosition() 
	{
		return this.position;
	}
	
	public void setState(State newState) 
	{
		this.state = newState;
	}
	
	public void draw(SpriteBatch spriteBatch, float ppuX, float ppuY)
	{
		spriteBatch.draw(texture, this.position.x * ppuX, this.position.y * ppuY, 32, 32);					
		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);		
		font.draw(spriteBatch, "Score: " + Integer.toString(this.score), 0, 320); 	
		font.draw(spriteBatch, "Best: " + Integer.toString(this.best), 0, 300);
	}

	public void update(float delta) 
	{
		stateTime += delta;
		position.add(velocity.tmp().mul(delta));
		this.bounds.x = this.position.x;
		this.bounds.y = this.position.y;
		this.hitBox.x = this.position.x;
		this.hitBox.y = this.position.y;
		score++;
	}
}
