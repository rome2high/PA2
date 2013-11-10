
public class TaskControlBlock {
	MyTask task;
	boolean ready;
	int priority;
	
	public TaskControlBlock(MyTask mytask, int priority){
		this.task = mytask;
		this.ready = true;
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
