//**********************************************************
// Assignment: ICS-462-50 PA2 JAVA DIY Operating System
//
// Author: Romeo Mai
//
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

import java.awt.Color;


public class MovingShape implements MyTask {
	public static final int OVAL = 0;
	public static final int RECTANGLE = 1;
	
	int width;
	int height;
	int X;
	int Y;
	Color color;
	int type;
	
	
	public MovingShape()  {
		width = 10;
		height = 10;
	    X = 5;
		Y= 5;
		color = Color.BLUE;
		type = RECTANGLE;
	}
	
	public MovingShape(int width, int height, int x, int y, Color color, int type) {
		super();
		this.width = width;
		this.height = height;
		X = x;
		Y = y;
		this.color = color;
		this.type = type;
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	public Color getColor() {
		return color;
	}
	public int getType() {
		return type;
	}

	@Override
	public void execute() {
		Y++;
		Y = Y % Painter.SQUARE_SIZE;
		 
	}

	public int timer = 0;
	public int reload = 0;
	
	@Override
	public void resetTimer() {
		timer = reload;
	}

	@Override
	public boolean decrementTimer() {
		timer--;
		if (timer<0)
			return true;
		else 
			return false;
	}

	@Override
	public void setTimer(int _value) { 
		reload = _value;
	}
}
