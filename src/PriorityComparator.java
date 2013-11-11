//**********************************************************
// Assignment: ICS-462-50 PA2 JAVA DIY Operating System
//
// Author: Romeo Mai
//
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

import java.util.Comparator;


public class PriorityComparator implements Comparator<TaskControlBlock>
{
	@Override
	public int compare(TaskControlBlock o1, TaskControlBlock o2)
	{
		if(o1.priority < o2.priority)
		{
			return -1;
		}
		if(o1.priority > o2.priority)
		{
			return 1;
		}
		return 0;
	}

}
