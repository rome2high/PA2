//**********************************************************
// Assignment: ICS-462-50 PA2 JAVA DIY Operating System
//
// Author: Romeo Mai
//
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

public interface MyTask {
	public abstract void execute();	
	public abstract void setTimer(int _value);
	public abstract void resetTimer();
	public abstract boolean decrementTimer(); 
}
