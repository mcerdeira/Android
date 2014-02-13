package com.me.mygdxgame;

import com.badlogic.gdx.math.*;

public class Char {
	public Vector2 Postion;
	public Rectangle hitBox;
	static final float SPEED = 2f;
	
	public Char(Vector2 pos){
		this.hitBox.height = 50;
		this.hitBox.width = 50;
		this.Postion = pos;	
	}	
}
