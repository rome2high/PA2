//**********************************************************
// Assignment: ICS-462-50 PA2 JAVA DIY Operating System
//
// Author: Romeo Mai
//
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;


public class Kernel extends Thread implements Runnable{
	ArrayList<TaskControlBlock> tcbList = new ArrayList<TaskControlBlock>();
	Comparator<TaskControlBlock> comparator = new PriorityComparator();
	PriorityQueue<TaskControlBlock> rq = new PriorityQueue<TaskControlBlock>(5,comparator);
 
	public void addTCB(TaskControlBlock tcb) {
		tcbList.add(tcb);
	}

	public void run() {
		
		while(true) {	//timer control
			for (int i=0;i<tcbList.size();i++) {
				TaskControlBlock tcb = tcbList.get(i);
				if (!tcb.ready && tcb.task.decrementTimer() == true ) { //not in q and time expired
					tcb.setReady(true);
					rq.add(tcb);
				}
			}
			
			if (!rq.isEmpty()) {
				
					//queue order debug visualization
				for(Iterator<TaskControlBlock> i = rq.iterator(); i.hasNext();){
					int item = i.next().priority;
					//System.out.println(item);
				}
				//System.out.println("----------------");
				
				TaskControlBlock tcb = rq.remove();		//compare and get head item
				tcb.setReady(false);
				tcb.task.execute();
				tcb.task.resetTimer();
			}
			
			try {
				Thread.sleep(1);  //sleep for a quantum
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
