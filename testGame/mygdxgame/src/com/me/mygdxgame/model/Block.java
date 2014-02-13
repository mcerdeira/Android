package com.me.mygdxgame.model;

import com.badlogic.gdx.math.Vector2;

public class Block {
	public static final float SPEED = 4f;
	public static final float SIZE = 0.5f; // half a unit
	float stateTime = 0;
	
	public enum State {
		IDLE, MOVING
	}	
	State state;
	Vector2 position = new Vector2();
	Vector2 acceleration = new Vector2();
	Vector2 velocity = new Vector2();
	
	public Block(){
		this.state = State.IDLE;
	}
	
	public Vector2 getAcceleration() {
		return acceleration;
	}

	public Vector2 getVelocity() {
		return velocity;
	}
	
	public Vector2 getPosition() {
		return this.position;
	}
	
	public void setState(State newState) {
		this.state = newState;
	}
	
	public void update(float delta) {
		stateTime += delta;
		position.add(velocity.tmp().mul(delta));
	}
}
