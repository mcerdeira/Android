package com.me.mygdxgame.controller;

import java.util.HashMap;
import java.util.Map;

import com.me.mygdxgame.model.AsteroidManager;
import com.me.mygdxgame.model.StarShip;
import com.me.mygdxgame.model.StarShip.State;

public class GameController 
{
	enum Keys 
	{
		LEFT, RIGHT
	}
	private StarShip starship;
	private AsteroidManager asteroidmanager;
	
	
	static Map<Keys, Boolean> keys = new HashMap<GameController.Keys, Boolean>();
	static 
	{
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
	};
	
	public GameController(StarShip starship, AsteroidManager asteroidmanager) 
	{
		this.starship = starship;
		this.asteroidmanager = asteroidmanager;
	}
	
	// ** Key presses and touches **************** //

	public void leftPressed() 
	{
		keys.get(keys.put(Keys.LEFT, true));
	}
	
	public void rightPressed() 
	{
		keys.get(keys.put(Keys.RIGHT, true));
	}

	public void leftReleased() 
	{
		keys.get(keys.put(Keys.LEFT, false));
	}
	
	public void rightReleased() 
	{
		keys.get(keys.put(Keys.RIGHT, false));
	}

	/** The main update method **/
	public void update(float delta) 
	{
		processInput();
		starship.update(delta);
		asteroidmanager.update(delta);
	}
	
	/** Change Block state and parameters based on input controls **/
	private void processInput() 
	{
		if (keys.get(Keys.LEFT)) 
		{
			// left is pressed
			starship.setState(State.MOVING);
			starship.getVelocity().x = -starship.SPEED;
		}
		if (keys.get(Keys.RIGHT)) 
		{
			// left is pressed
			starship.setState(State.MOVING);
			starship.getVelocity().x = starship.SPEED;
		}
		// need to check if both or none direction are pressed, then Bob is idle
		if ((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT)) ||
		    (!keys.get(Keys.LEFT) && !(keys.get(Keys.RIGHT)))) 
		{
			starship.setState(State.IDLE);
			// acceleration is 0 on the x
			starship.getAcceleration().x = 0;
			// horizontal speed is 0
			starship.getVelocity().x = 0;	
		}
	}
}
