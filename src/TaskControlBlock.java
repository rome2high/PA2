//**********************************************************
// Assignment: ICS-462-50 PA2 JAVA DIY Operating System
//
// Author: Romeo Mai
//
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

public class TaskControlBlock {
	MyTask task;
	boolean ready;
	int priority;
	
	public TaskControlBlock(MyTask mytask, int priority){
		this.task = mytask;
		this.ready = false;
		this.priority = priority;
	}

	public MyTask getTask() {
		return task;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}
