// ICS-462 Demo Code for PA2
// By Michael Dorin
// Metro State University
//
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Kernel {
	ArrayList<TaskControlBlock> tcbList = new ArrayList<TaskControlBlock>();
	Queue<TaskControlBlock> rq = new LinkedList<TaskControlBlock>();
 
	public void addTCB(TaskControlBlock tcb) {
		tcbList.add(tcb);
	}

	public void run() {
 
		while(true) {
			for (int i=0;i<tcbList.size();i++) {
				TaskControlBlock tcb = tcbList.get(i);
				
				if (tcb.task.decrementTimer() == true) { //expired
					rq.add(tcb);	
				}
			}
			
			if (!rq.isEmpty()) {
				String s = "";
				for(int i = 0; i < rq.size(); i++){
					s += "   ";
				}
				System.out.println(s + rq.size());
				TaskControlBlock tcb = rq.remove();
				tcb.task.execute();
				tcb.task.resetTimer();
			}
			try {
				Thread.sleep(1);  //simulates a 'tick'
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
