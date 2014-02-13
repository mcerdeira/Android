package com.me.mygdxgame.controller;

import java.util.HashMap;
import java.util.Map;

import com.me.mygdxgame.model.Block;
import com.me.mygdxgame.model.Block.State;

public class GameController {
	enum Keys {
		LEFT, RIGHT
	}
	
	private Block block;
	
	static Map<Keys, Boolean> keys = new HashMap<GameController.Keys, Boolean>();
	static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
	};
	
	public GameController(Block block) {
		this.block = block;
	}
	
	// ** Key presses and touches **************** //

	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
	}
	
	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));
	}

	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
	}
	
	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
	}

	/** The main update method **/
	public void update(float delta) {
		processInput();
		block.update(delta);
	}
	
	/** Change Block state and parameters based on input controls **/
	private void processInput() {
		if (keys.get(Keys.LEFT)) {
			// left is pressed
			block.setState(State.MOVING);
			block.getVelocity().x = -block.SPEED;
		}
		if (keys.get(Keys.RIGHT)) {
			// left is pressed
			block.setState(State.MOVING);
			block.getVelocity().x = block.SPEED;
		}
		// need to check if both or none direction are pressed, then Bob is idle
		if ((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT)) ||
		    (!keys.get(Keys.LEFT) && !(keys.get(Keys.RIGHT)))) {
			block.setState(State.IDLE);
			// acceleration is 0 on the x
			block.getAcceleration().x = 0;
			// horizontal speed is 0
			block.getVelocity().x = 0;	
		}
	}
}
